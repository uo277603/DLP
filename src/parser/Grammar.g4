grammar Grammar;
import Lexicon;

@parser::header {
    import ast.*;
}

start
	returns[Program ast]:
	clase 'main' IDENT'(' listaexpresionOpt ')' ';' 'end' {$ast = new Program($clase.ast, new MethodCallSentence($IDENT, $listaexpresionOpt.list));};
	

clase returns[ClassNode ast]
	: 'class' nombreClase=IDENT ';' atributosOpt 'create' constructores  lm+=metodo+ 'end'
	{$ast = new ClassNode($nombreClase.text, $atributosOpt.list, $constructores.list, $lm);};

constructores returns[List<String> list = new ArrayList<String>()]
	: (IDENT ';' {$list.add($IDENT.text);})+
	;

atributosOpt returns[List<Definition> list = new ArrayList<Definition>()]
	: (atributos {$list = $atributos.list;})?
	;
atributos returns[List<Definition> list = new ArrayList<Definition>()]
	: 'global' ('types' (deftuple {$list.add($deftuple.ast);})*)? ('vars' (multiDef {$list.add($multiDef.ast);})*)?
	;
deftuple returns[Definition ast]
	: 'deftuple' name=IDENT 'as' ls+=simpleDef* 'end' {$ast = new TupleDefinition($name.text, $ls);}
	;

simpleDef returns[Definition ast]
	: IDENT ':' tipo ';'{List<Token> list = new ArrayList<Token>();
						list.add($IDENT);
		$ast = new VarDefinition(list, $tipo.ast);
		} 
	;
multiDef returns[Definition ast]
	: listaidents ':' tipo ';' {$ast = new VarDefinition($listaidents.list, $tipo.ast);}
	;

listaidents returns[List<Token> list = new ArrayList<Token>()]
	: IDENT {$list.add($IDENT);} (',' IDENT {$list.add($IDENT);})*
	;
tipo returns[Type ast]
	: ('[' INT_CONSTANT ']') tipo {$ast = new ArrayType($INT_CONSTANT, $tipo.ast);}
	| 'INTEGER' {$ast = new IntType();}
	| 'CHARACTER' {$ast = new CharType();}
	| 'DOUBLE' {$ast = new RealType();}
	| IDENT {$ast = new StructType($IDENT.text);}
	;

metodo returns[Method ast]
	:'feature' IDENT parametrosOpt returnType? 'is' localDefOpt 'do' ls+=sentencia* 'end'
	{$ast = new Method($IDENT.text, $parametrosOpt.list, $ctx.returnType != null ? $returnType.ast : new VoidType(), $localDefOpt.list, $ls); $ast.setPositions($ctx.start);}
	;
parametrosOpt returns[List<Parameter> list = new ArrayList<Parameter>()]
	:('(' listaparametros ')' {$list = $listaparametros.list;})?
	;
returnType returns[Type ast]
	: ':' tipo {$ast = $tipo.ast;}
	;
localDefOpt returns[List<Definition> list = new ArrayList<Definition>()]
	: ('local' (multiDef {$list.add($multiDef.ast);})+)?
	;
listaparametros returns[List<Parameter> list = new ArrayList<Parameter>()]
	: parametro {$list.add($parametro.ast);} (',' parametro {$list.add($parametro.ast);})*;

parametro returns[Parameter ast]
	: IDENT ':' tipo {$ast = new Parameter($IDENT, $tipo.ast);}
	;

sentencia returns[Sentence ast]
	:
	t=('print' | 'println') listaexpresionOpt ';' {$ast = new Print($t.text, $listaexpresionOpt.list); $ast.setPositions($ctx.start);}
	| 'read' listaexpresion ';' {$ast = new Read($listaexpresion.list);}
	| asignacion {$ast = $asignacion.ast;}
	| 'if' expr 'then' ls+=sentencia* elseOpt 'end' {$ast = new Conditional($expr.ast, $ls, $elseOpt.list);}
	| fromOpt 'until' expr 'loop' ls+=sentencia* 'end' {$ast = new Loop($fromOpt.list, $expr.ast, $ls);}
	| IDENT '(' listaexpresionOpt ')' ';' {$ast = new MethodCallSentence($IDENT, $listaexpresionOpt.list);}
	| 'return' exprOpt ';' {$ast = new ReturnNode($exprOpt.ast); $ast.setPositions($ctx.start);}
	;

exprOpt returns[Expr ast]
	:	(expr {$ast = $expr.ast; })?
	;

asignacion returns[Sentence ast]
	: left=expr ':=' right=expr ';' {$ast = new Assignment($left.ast, $right.ast);}
	;

elseOpt returns[List<Sentence> list = new ArrayList<Sentence>()]
	: ('else' (sentencia {$list.add($sentencia.ast);})+)?
	;

fromOpt returns[List<Sentence> list = new ArrayList<Sentence>()]
	:	('from' (asignacion {$list.add($asignacion.ast);})*)?
	;


expr returns[Expr ast]
	:
	INT_CONSTANT {$ast = new LitEnt($INT_CONSTANT);}
	| REAL_CONSTANT {$ast = new LitReal($REAL_CONSTANT);}
	| CHAR_CONSTANT {$ast = new LitChar($CHAR_CONSTANT);}
	| IDENT {$ast = new Variable($IDENT);}
	| IDENT '(' listaexpresionOpt ')' {$ast = new MethodCallExpr($IDENT, $listaexpresionOpt.list);}
	| left=expr '[' right=expr ']' {$ast = new ArrayAcces($left.ast, $right.ast);}
	| left=expr op='.' IDENT {$ast = new Acces($left.ast, $op.text, $IDENT);}
	| op='-' expr {$ast = new ExprUnariaAritmetica($op.text, $expr.ast);}	
	| '(' expr ')' {$ast = $expr.ast ;}
	| op='not' expr {$ast = new ExprUnariaLogica($op.text, $expr.ast);}
	| 'to' '<' tipo '>' '(' expr ')' {$ast = new Cast($tipo.ast, $expr.ast);}
	| left=expr op=('*' | '/') right=expr {$ast = new ExprBinariaAritmetica($left.ast, $op.text, $right.ast);}
	| left=expr op=('+' | '-') right=expr {$ast = new ExprBinariaAritmetica($left.ast, $op.text, $right.ast);}
	| left=expr op=('>' | '<' | '>=' | '<=') right=expr {$ast = new ExprBinariaLogica($left.ast, $op.text, $right.ast);}
	| left=expr op=('=' | '<>') right=expr {$ast = new ExprBinariaLogica($left.ast, $op.text, $right.ast);}
	| left=expr op='and' right=expr {$ast = new ExprBinariaLogica($left.ast, $op.text, $right.ast);}
	| left=expr op='or' right=expr {$ast = new ExprBinariaLogica($left.ast, $op.text, $right.ast);}
	;

listaexpresionOpt returns[List<Expr> list = new ArrayList<Expr>()]
	: (listaexpresion {$list = $listaexpresion.list;})?
	;

listaexpresion returns[List<Expr> list = new ArrayList<Expr>()]
	: expr {$list.add($expr.ast);} (',' expr {$list.add($expr.ast);})*
	;

