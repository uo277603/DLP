// Generated from d:\ClaseTercero\SegundoCuatri\DLP\DLP\src\parser\Grammar.g4 by ANTLR 4.8

    import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, IDENT=50, INT_CONSTANT=51, REAL_CONSTANT=52, 
		CHAR_CONSTANT=53, LINE_COMMENT=54, MULTILINE_COMMENT=55, WHITESPACE=56;
	public static final int
		RULE_start = 0, RULE_clase = 1, RULE_constructores = 2, RULE_atributosOpt = 3, 
		RULE_atributos = 4, RULE_deftuple = 5, RULE_simpleDef = 6, RULE_multiDef = 7, 
		RULE_listaidents = 8, RULE_tipo = 9, RULE_metodo = 10, RULE_parametrosOpt = 11, 
		RULE_returnType = 12, RULE_localDefOpt = 13, RULE_listaparametros = 14, 
		RULE_parametro = 15, RULE_sentencia = 16, RULE_listaAsignacion = 17, RULE_exprOpt = 18, 
		RULE_asignacion = 19, RULE_elseOpt = 20, RULE_fromOpt = 21, RULE_expr = 22, 
		RULE_listaexpresionOpt = 23, RULE_listaexpresion = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "clase", "constructores", "atributosOpt", "atributos", "deftuple", 
			"simpleDef", "multiDef", "listaidents", "tipo", "metodo", "parametrosOpt", 
			"returnType", "localDefOpt", "listaparametros", "parametro", "sentencia", 
			"listaAsignacion", "exprOpt", "asignacion", "elseOpt", "fromOpt", "expr", 
			"listaexpresionOpt", "listaexpresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'('", "')'", "';'", "'end'", "'class'", "'create'", 
			"'global'", "'types'", "'vars'", "'deftuple'", "'as'", "':'", "','", 
			"'['", "']'", "'INTEGER'", "'CHARACTER'", "'DOUBLE'", "'feature'", "'is'", 
			"'do'", "'local'", "'print'", "'println'", "'read'", "':='", "'if'", 
			"'then'", "'until'", "'loop'", "'return'", "'else'", "'from'", "'.'", 
			"'-'", "'not'", "'to'", "'<'", "'>'", "'*'", "'/'", "'+'", "'>='", "'<='", 
			"'='", "'<>'", "'and'", "'or'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "IDENT", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public ClaseContext clase;
		public Token IDENT;
		public ListaexpresionOptContext listaexpresionOpt;
		public ClaseContext clase() {
			return getRuleContext(ClaseContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ListaexpresionOptContext listaexpresionOpt() {
			return getRuleContext(ListaexpresionOptContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((StartContext)_localctx).clase = clase();
			setState(51);
			match(T__0);
			setState(52);
			((StartContext)_localctx).IDENT = match(IDENT);
			setState(53);
			match(T__1);
			setState(54);
			((StartContext)_localctx).listaexpresionOpt = listaexpresionOpt();
			setState(55);
			match(T__2);
			setState(56);
			match(T__3);
			setState(57);
			match(T__4);
			((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).clase.ast, new MethodCallSentence(((StartContext)_localctx).IDENT, ((StartContext)_localctx).listaexpresionOpt.list));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClaseContext extends ParserRuleContext {
		public ClassNode ast;
		public Token nombreClase;
		public AtributosOptContext atributosOpt;
		public ConstructoresContext constructores;
		public MetodoContext metodo;
		public List<MetodoContext> lm = new ArrayList<MetodoContext>();
		public AtributosOptContext atributosOpt() {
			return getRuleContext(AtributosOptContext.class,0);
		}
		public ConstructoresContext constructores() {
			return getRuleContext(ConstructoresContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<MetodoContext> metodo() {
			return getRuleContexts(MetodoContext.class);
		}
		public MetodoContext metodo(int i) {
			return getRuleContext(MetodoContext.class,i);
		}
		public ClaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clase; }
	}

	public final ClaseContext clase() throws RecognitionException {
		ClaseContext _localctx = new ClaseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_clase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__5);
			setState(61);
			((ClaseContext)_localctx).nombreClase = match(IDENT);
			setState(62);
			match(T__3);
			setState(63);
			((ClaseContext)_localctx).atributosOpt = atributosOpt();
			setState(64);
			match(T__6);
			setState(65);
			((ClaseContext)_localctx).constructores = constructores();
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66);
				((ClaseContext)_localctx).metodo = metodo();
				((ClaseContext)_localctx).lm.add(((ClaseContext)_localctx).metodo);
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__19 );
			setState(71);
			match(T__4);
			((ClaseContext)_localctx).ast =  new ClassNode((((ClaseContext)_localctx).nombreClase!=null?((ClaseContext)_localctx).nombreClase.getText():null), ((ClaseContext)_localctx).atributosOpt.list, ((ClaseContext)_localctx).constructores.list, ((ClaseContext)_localctx).lm);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructoresContext extends ParserRuleContext {
		public List<String> list = new ArrayList<String>();
		public Token IDENT;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public ConstructoresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructores; }
	}

	public final ConstructoresContext constructores() throws RecognitionException {
		ConstructoresContext _localctx = new ConstructoresContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constructores);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74);
				((ConstructoresContext)_localctx).IDENT = match(IDENT);
				setState(75);
				match(T__3);
				_localctx.list.add((((ConstructoresContext)_localctx).IDENT!=null?((ConstructoresContext)_localctx).IDENT.getText():null));
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtributosOptContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public AtributosContext atributos;
		public AtributosContext atributos() {
			return getRuleContext(AtributosContext.class,0);
		}
		public AtributosOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributosOpt; }
	}

	public final AtributosOptContext atributosOpt() throws RecognitionException {
		AtributosOptContext _localctx = new AtributosOptContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atributosOpt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(81);
				((AtributosOptContext)_localctx).atributos = atributos();
				((AtributosOptContext)_localctx).list =  ((AtributosOptContext)_localctx).atributos.list;
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtributosContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public DeftupleContext deftuple;
		public MultiDefContext multiDef;
		public List<DeftupleContext> deftuple() {
			return getRuleContexts(DeftupleContext.class);
		}
		public DeftupleContext deftuple(int i) {
			return getRuleContext(DeftupleContext.class,i);
		}
		public List<MultiDefContext> multiDef() {
			return getRuleContexts(MultiDefContext.class);
		}
		public MultiDefContext multiDef(int i) {
			return getRuleContext(MultiDefContext.class,i);
		}
		public AtributosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributos; }
	}

	public final AtributosContext atributos() throws RecognitionException {
		AtributosContext _localctx = new AtributosContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atributos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__7);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(87);
				match(T__8);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(88);
					((AtributosContext)_localctx).deftuple = deftuple();
					_localctx.list.add(((AtributosContext)_localctx).deftuple.ast);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(98);
				match(T__9);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(99);
					((AtributosContext)_localctx).multiDef = multiDef();
					_localctx.list.add(((AtributosContext)_localctx).multiDef.ast);
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeftupleContext extends ParserRuleContext {
		public Definition ast;
		public Token name;
		public SimpleDefContext simpleDef;
		public List<SimpleDefContext> ls = new ArrayList<SimpleDefContext>();
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<SimpleDefContext> simpleDef() {
			return getRuleContexts(SimpleDefContext.class);
		}
		public SimpleDefContext simpleDef(int i) {
			return getRuleContext(SimpleDefContext.class,i);
		}
		public DeftupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deftuple; }
	}

	public final DeftupleContext deftuple() throws RecognitionException {
		DeftupleContext _localctx = new DeftupleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_deftuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__10);
			setState(110);
			((DeftupleContext)_localctx).name = match(IDENT);
			setState(111);
			match(T__11);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(112);
				((DeftupleContext)_localctx).simpleDef = simpleDef();
				((DeftupleContext)_localctx).ls.add(((DeftupleContext)_localctx).simpleDef);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(T__4);
			((DeftupleContext)_localctx).ast =  new TupleDefinition((((DeftupleContext)_localctx).name!=null?((DeftupleContext)_localctx).name.getText():null), ((DeftupleContext)_localctx).ls);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleDefContext extends ParserRuleContext {
		public Definition ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public SimpleDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleDef; }
	}

	public final SimpleDefContext simpleDef() throws RecognitionException {
		SimpleDefContext _localctx = new SimpleDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_simpleDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			((SimpleDefContext)_localctx).IDENT = match(IDENT);
			setState(122);
			match(T__12);
			setState(123);
			((SimpleDefContext)_localctx).tipo = tipo();
			setState(124);
			match(T__3);
			List<Token> list = new ArrayList<Token>();
									list.add(((SimpleDefContext)_localctx).IDENT);
					((SimpleDefContext)_localctx).ast =  new VarDefinition(list, ((SimpleDefContext)_localctx).tipo.ast);
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiDefContext extends ParserRuleContext {
		public Definition ast;
		public ListaidentsContext listaidents;
		public TipoContext tipo;
		public ListaidentsContext listaidents() {
			return getRuleContext(ListaidentsContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public MultiDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiDef; }
	}

	public final MultiDefContext multiDef() throws RecognitionException {
		MultiDefContext _localctx = new MultiDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multiDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			((MultiDefContext)_localctx).listaidents = listaidents();
			setState(128);
			match(T__12);
			setState(129);
			((MultiDefContext)_localctx).tipo = tipo();
			setState(130);
			match(T__3);
			((MultiDefContext)_localctx).ast =  new VarDefinition(((MultiDefContext)_localctx).listaidents.list, ((MultiDefContext)_localctx).tipo.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaidentsContext extends ParserRuleContext {
		public List<Token> list = new ArrayList<Token>();
		public Token IDENT;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public ListaidentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaidents; }
	}

	public final ListaidentsContext listaidents() throws RecognitionException {
		ListaidentsContext _localctx = new ListaidentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_listaidents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			((ListaidentsContext)_localctx).IDENT = match(IDENT);
			_localctx.list.add(((ListaidentsContext)_localctx).IDENT);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(135);
				match(T__13);
				setState(136);
				((ListaidentsContext)_localctx).IDENT = match(IDENT);
				_localctx.list.add(((ListaidentsContext)_localctx).IDENT);
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public Type ast;
		public Token INT_CONSTANT;
		public TipoContext tipo;
		public Token IDENT;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tipo);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(143);
				match(T__14);
				setState(144);
				((TipoContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(145);
				match(T__15);
				}
				setState(147);
				((TipoContext)_localctx).tipo = tipo();
				((TipoContext)_localctx).ast =  new ArrayType(((TipoContext)_localctx).INT_CONSTANT, ((TipoContext)_localctx).tipo.ast);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__16);
				((TipoContext)_localctx).ast =  new IntType();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				match(T__17);
				((TipoContext)_localctx).ast =  new CharType();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(T__18);
				((TipoContext)_localctx).ast =  new RealType();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				((TipoContext)_localctx).IDENT = match(IDENT);
				((TipoContext)_localctx).ast =  new StructType((((TipoContext)_localctx).IDENT!=null?((TipoContext)_localctx).IDENT.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetodoContext extends ParserRuleContext {
		public Method ast;
		public Token IDENT;
		public ParametrosOptContext parametrosOpt;
		public ReturnTypeContext returnType;
		public LocalDefOptContext localDefOpt;
		public SentenciaContext sentencia;
		public List<SentenciaContext> ls = new ArrayList<SentenciaContext>();
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ParametrosOptContext parametrosOpt() {
			return getRuleContext(ParametrosOptContext.class,0);
		}
		public LocalDefOptContext localDefOpt() {
			return getRuleContext(LocalDefOptContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public MetodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metodo; }
	}

	public final MetodoContext metodo() throws RecognitionException {
		MetodoContext _localctx = new MetodoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_metodo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__19);
			setState(161);
			((MetodoContext)_localctx).IDENT = match(IDENT);
			setState(162);
			((MetodoContext)_localctx).parametrosOpt = parametrosOpt();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(163);
				((MetodoContext)_localctx).returnType = returnType();
				}
			}

			setState(166);
			match(T__20);
			setState(167);
			((MetodoContext)_localctx).localDefOpt = localDefOpt();
			setState(168);
			match(T__21);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(169);
				((MetodoContext)_localctx).sentencia = sentencia();
				((MetodoContext)_localctx).ls.add(((MetodoContext)_localctx).sentencia);
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175);
			match(T__4);
			((MetodoContext)_localctx).ast =  new Method((((MetodoContext)_localctx).IDENT!=null?((MetodoContext)_localctx).IDENT.getText():null), ((MetodoContext)_localctx).parametrosOpt.list, _localctx.returnType != null ? ((MetodoContext)_localctx).returnType.ast : new VoidType(), ((MetodoContext)_localctx).localDefOpt.list, ((MetodoContext)_localctx).ls);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametrosOptContext extends ParserRuleContext {
		public List<Parameter> list = new ArrayList<Parameter>();
		public ListaparametrosContext listaparametros;
		public ListaparametrosContext listaparametros() {
			return getRuleContext(ListaparametrosContext.class,0);
		}
		public ParametrosOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametrosOpt; }
	}

	public final ParametrosOptContext parametrosOpt() throws RecognitionException {
		ParametrosOptContext _localctx = new ParametrosOptContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parametrosOpt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(178);
				match(T__1);
				setState(179);
				((ParametrosOptContext)_localctx).listaparametros = listaparametros();
				setState(180);
				match(T__2);
				((ParametrosOptContext)_localctx).list =  ((ParametrosOptContext)_localctx).listaparametros.list;
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnTypeContext extends ParserRuleContext {
		public Type ast;
		public TipoContext tipo;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_returnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__12);
			setState(186);
			((ReturnTypeContext)_localctx).tipo = tipo();
			((ReturnTypeContext)_localctx).ast =  ((ReturnTypeContext)_localctx).tipo.ast;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalDefOptContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public MultiDefContext multiDef;
		public List<MultiDefContext> multiDef() {
			return getRuleContexts(MultiDefContext.class);
		}
		public MultiDefContext multiDef(int i) {
			return getRuleContext(MultiDefContext.class,i);
		}
		public LocalDefOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localDefOpt; }
	}

	public final LocalDefOptContext localDefOpt() throws RecognitionException {
		LocalDefOptContext _localctx = new LocalDefOptContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_localDefOpt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(189);
				match(T__22);
				setState(193); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(190);
					((LocalDefOptContext)_localctx).multiDef = multiDef();
					_localctx.list.add(((LocalDefOptContext)_localctx).multiDef.ast);
					}
					}
					setState(195); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IDENT );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaparametrosContext extends ParserRuleContext {
		public List<Parameter> list = new ArrayList<Parameter>();
		public ParametroContext parametro;
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public ListaparametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaparametros; }
	}

	public final ListaparametrosContext listaparametros() throws RecognitionException {
		ListaparametrosContext _localctx = new ListaparametrosContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_listaparametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			((ListaparametrosContext)_localctx).parametro = parametro();
			_localctx.list.add(((ListaparametrosContext)_localctx).parametro.ast);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(201);
				match(T__13);
				setState(202);
				((ListaparametrosContext)_localctx).parametro = parametro();
				_localctx.list.add(((ListaparametrosContext)_localctx).parametro.ast);
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroContext extends ParserRuleContext {
		public Parameter ast;
		public Token IDENT;
		public TipoContext tipo;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			((ParametroContext)_localctx).IDENT = match(IDENT);
			setState(211);
			match(T__12);
			setState(212);
			((ParametroContext)_localctx).tipo = tipo();
			((ParametroContext)_localctx).ast =  new Parameter(((ParametroContext)_localctx).IDENT, ((ParametroContext)_localctx).tipo.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContext extends ParserRuleContext {
		public Sentence ast;
		public Token t;
		public ListaexpresionOptContext listaexpresionOpt;
		public ListaexpresionContext listaexpresion;
		public AsignacionContext asignacion;
		public ListaAsignacionContext listaAsignacion;
		public ExprContext valor;
		public ExprContext expr;
		public SentenciaContext sentencia;
		public List<SentenciaContext> ls = new ArrayList<SentenciaContext>();
		public ElseOptContext elseOpt;
		public FromOptContext fromOpt;
		public Token IDENT;
		public ExprOptContext exprOpt;
		public ListaexpresionOptContext listaexpresionOpt() {
			return getRuleContext(ListaexpresionOptContext.class,0);
		}
		public ListaexpresionContext listaexpresion() {
			return getRuleContext(ListaexpresionContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ListaAsignacionContext listaAsignacion() {
			return getRuleContext(ListaAsignacionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ElseOptContext elseOpt() {
			return getRuleContext(ElseOptContext.class,0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public FromOptContext fromOpt() {
			return getRuleContext(FromOptContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ExprOptContext exprOpt() {
			return getRuleContext(ExprOptContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sentencia);
		int _la;
		try {
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				((SentenciaContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__24) ) {
					((SentenciaContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(216);
				((SentenciaContext)_localctx).listaexpresionOpt = listaexpresionOpt();
				setState(217);
				match(T__3);
				((SentenciaContext)_localctx).ast =  new Print((((SentenciaContext)_localctx).t!=null?((SentenciaContext)_localctx).t.getText():null), ((SentenciaContext)_localctx).listaexpresionOpt.list);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(T__25);
				setState(221);
				((SentenciaContext)_localctx).listaexpresion = listaexpresion();
				setState(222);
				match(T__3);
				((SentenciaContext)_localctx).ast =  new Read(((SentenciaContext)_localctx).listaexpresion.list);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				((SentenciaContext)_localctx).asignacion = asignacion();
				((SentenciaContext)_localctx).ast =  ((SentenciaContext)_localctx).asignacion.ast;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				((SentenciaContext)_localctx).listaAsignacion = listaAsignacion();
				setState(229);
				match(T__26);
				setState(230);
				((SentenciaContext)_localctx).valor = expr(0);
				setState(231);
				match(T__3);
				((SentenciaContext)_localctx).ast =  new MultipleAssignment(((SentenciaContext)_localctx).listaAsignacion.list, ((SentenciaContext)_localctx).valor.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				match(T__27);
				setState(235);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(236);
				match(T__28);
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(237);
					((SentenciaContext)_localctx).sentencia = sentencia();
					((SentenciaContext)_localctx).ls.add(((SentenciaContext)_localctx).sentencia);
					}
					}
					setState(242);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(243);
				((SentenciaContext)_localctx).elseOpt = elseOpt();
				setState(244);
				match(T__4);
				((SentenciaContext)_localctx).ast =  new Conditional(((SentenciaContext)_localctx).expr.ast, ((SentenciaContext)_localctx).ls, ((SentenciaContext)_localctx).elseOpt.list);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(247);
				((SentenciaContext)_localctx).fromOpt = fromOpt();
				setState(248);
				match(T__29);
				setState(249);
				((SentenciaContext)_localctx).expr = expr(0);
				setState(250);
				match(T__30);
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(251);
					((SentenciaContext)_localctx).sentencia = sentencia();
					((SentenciaContext)_localctx).ls.add(((SentenciaContext)_localctx).sentencia);
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(257);
				match(T__4);
				((SentenciaContext)_localctx).ast =  new Loop(((SentenciaContext)_localctx).fromOpt.list, ((SentenciaContext)_localctx).expr.ast, ((SentenciaContext)_localctx).ls);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(260);
				((SentenciaContext)_localctx).IDENT = match(IDENT);
				setState(261);
				match(T__1);
				setState(262);
				((SentenciaContext)_localctx).listaexpresionOpt = listaexpresionOpt();
				setState(263);
				match(T__2);
				setState(264);
				match(T__3);
				((SentenciaContext)_localctx).ast =  new MethodCallSentence(((SentenciaContext)_localctx).IDENT, ((SentenciaContext)_localctx).listaexpresionOpt.list);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(267);
				match(T__31);
				setState(268);
				((SentenciaContext)_localctx).exprOpt = exprOpt();
				setState(269);
				match(T__3);
				((SentenciaContext)_localctx).ast =  new ReturnNode(((SentenciaContext)_localctx).exprOpt.ast);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaAsignacionContext extends ParserRuleContext {
		public List<Expr> list = new ArrayList<Expr>();
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ListaAsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaAsignacion; }
	}

	public final ListaAsignacionContext listaAsignacion() throws RecognitionException {
		ListaAsignacionContext _localctx = new ListaAsignacionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_listaAsignacion);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			((ListaAsignacionContext)_localctx).expr = expr(0);
			_localctx.list.add(((ListaAsignacionContext)_localctx).expr.ast);
			setState(280); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(276);
					match(T__26);
					setState(277);
					((ListaAsignacionContext)_localctx).expr = expr(0);
					_localctx.list.add(((ListaAsignacionContext)_localctx).expr.ast);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(282); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprOptContext extends ParserRuleContext {
		public Expr ast;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOpt; }
	}

	public final ExprOptContext exprOpt() throws RecognitionException {
		ExprOptContext _localctx = new ExprOptContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exprOpt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				setState(284);
				((ExprOptContext)_localctx).expr = expr(0);
				((ExprOptContext)_localctx).ast =  ((ExprOptContext)_localctx).expr.ast; 
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsignacionContext extends ParserRuleContext {
		public Sentence ast;
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			((AsignacionContext)_localctx).left = expr(0);
			setState(290);
			match(T__26);
			setState(291);
			((AsignacionContext)_localctx).right = expr(0);
			setState(292);
			match(T__3);
			((AsignacionContext)_localctx).ast =  new Assignment(((AsignacionContext)_localctx).left.ast, ((AsignacionContext)_localctx).right.ast);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseOptContext extends ParserRuleContext {
		public List<Sentence> list = new ArrayList<Sentence>();
		public SentenciaContext sentencia;
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public ElseOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseOpt; }
	}

	public final ElseOptContext elseOpt() throws RecognitionException {
		ElseOptContext _localctx = new ElseOptContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_elseOpt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__32) {
				{
				setState(295);
				match(T__32);
				setState(299); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(296);
					((ElseOptContext)_localctx).sentencia = sentencia();
					_localctx.list.add(((ElseOptContext)_localctx).sentencia.ast);
					}
					}
					setState(301); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0) );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromOptContext extends ParserRuleContext {
		public List<Sentence> list = new ArrayList<Sentence>();
		public AsignacionContext asignacion;
		public List<AsignacionContext> asignacion() {
			return getRuleContexts(AsignacionContext.class);
		}
		public AsignacionContext asignacion(int i) {
			return getRuleContext(AsignacionContext.class,i);
		}
		public FromOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromOpt; }
	}

	public final FromOptContext fromOpt() throws RecognitionException {
		FromOptContext _localctx = new FromOptContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_fromOpt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(305);
				match(T__33);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(306);
					((FromOptContext)_localctx).asignacion = asignacion();
					_localctx.list.add(((FromOptContext)_localctx).asignacion.ast);
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Expr ast;
		public ExprContext left;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token IDENT;
		public ListaexpresionOptContext listaexpresionOpt;
		public Token op;
		public ExprContext expr;
		public TipoContext tipo;
		public ExprContext right;
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ListaexpresionOptContext listaexpresionOpt() {
			return getRuleContext(ListaexpresionOptContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(317);
				((ExprContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExprContext)_localctx).ast =  new LitEnt(((ExprContext)_localctx).INT_CONSTANT);
				}
				break;
			case 2:
				{
				setState(319);
				((ExprContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExprContext)_localctx).ast =  new LitReal(((ExprContext)_localctx).REAL_CONSTANT);
				}
				break;
			case 3:
				{
				setState(321);
				((ExprContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExprContext)_localctx).ast =  new LitChar(((ExprContext)_localctx).CHAR_CONSTANT);
				}
				break;
			case 4:
				{
				setState(323);
				((ExprContext)_localctx).IDENT = match(IDENT);
				((ExprContext)_localctx).ast =  new Variable(((ExprContext)_localctx).IDENT);
				}
				break;
			case 5:
				{
				setState(325);
				((ExprContext)_localctx).IDENT = match(IDENT);
				setState(326);
				match(T__1);
				setState(327);
				((ExprContext)_localctx).listaexpresionOpt = listaexpresionOpt();
				setState(328);
				match(T__2);
				((ExprContext)_localctx).ast =  new MethodCallExpr(((ExprContext)_localctx).IDENT, ((ExprContext)_localctx).listaexpresionOpt.list);
				}
				break;
			case 6:
				{
				setState(331);
				((ExprContext)_localctx).op = match(T__35);
				setState(332);
				((ExprContext)_localctx).expr = expr(10);
				((ExprContext)_localctx).ast =  new ExprUnariaAritmetica((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).expr.ast);
				}
				break;
			case 7:
				{
				setState(335);
				match(T__1);
				setState(336);
				((ExprContext)_localctx).expr = expr(0);
				setState(337);
				match(T__2);
				((ExprContext)_localctx).ast =  ((ExprContext)_localctx).expr.ast ;
				}
				break;
			case 8:
				{
				setState(340);
				((ExprContext)_localctx).op = match(T__36);
				setState(341);
				((ExprContext)_localctx).expr = expr(8);
				((ExprContext)_localctx).ast =  new ExprUnariaLogica((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).expr.ast);
				}
				break;
			case 9:
				{
				setState(344);
				match(T__37);
				setState(345);
				match(T__38);
				setState(346);
				((ExprContext)_localctx).tipo = tipo();
				setState(347);
				match(T__39);
				setState(348);
				match(T__1);
				setState(349);
				((ExprContext)_localctx).expr = expr(0);
				setState(350);
				match(T__2);
				((ExprContext)_localctx).ast =  new Cast(((ExprContext)_localctx).tipo.ast, ((ExprContext)_localctx).expr.ast);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(397);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(395);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(355);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(356);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__40 || _la==T__41) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(357);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(7);
						((ExprContext)_localctx).ast =  new ExprBinariaAritmetica(((ExprContext)_localctx).left.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(360);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(361);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__42) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(362);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(6);
						((ExprContext)_localctx).ast =  new ExprBinariaAritmetica(((ExprContext)_localctx).left.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(365);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(366);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__39) | (1L << T__43) | (1L << T__44))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(367);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(5);
						((ExprContext)_localctx).ast =  new ExprBinariaLogica(((ExprContext)_localctx).left.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(370);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(371);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__45 || _la==T__46) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(372);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(4);
						((ExprContext)_localctx).ast =  new ExprBinariaLogica(((ExprContext)_localctx).left.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(375);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(376);
						((ExprContext)_localctx).op = match(T__47);
						setState(377);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(3);
						((ExprContext)_localctx).ast =  new ExprBinariaLogica(((ExprContext)_localctx).left.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(380);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(381);
						((ExprContext)_localctx).op = match(T__48);
						setState(382);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(2);
						((ExprContext)_localctx).ast =  new ExprBinariaLogica(((ExprContext)_localctx).left.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.ast);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(385);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(386);
						match(T__14);
						setState(387);
						((ExprContext)_localctx).right = ((ExprContext)_localctx).expr = expr(0);
						setState(388);
						match(T__15);
						((ExprContext)_localctx).ast =  new ArrayAcces(((ExprContext)_localctx).left.ast, ((ExprContext)_localctx).right.ast);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(391);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(392);
						((ExprContext)_localctx).op = match(T__34);
						setState(393);
						((ExprContext)_localctx).IDENT = match(IDENT);
						((ExprContext)_localctx).ast =  new Acces(((ExprContext)_localctx).left.ast, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).IDENT);
						}
						break;
					}
					} 
				}
				setState(399);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ListaexpresionOptContext extends ParserRuleContext {
		public List<Expr> list = new ArrayList<Expr>();
		public ListaexpresionContext listaexpresion;
		public ListaexpresionContext listaexpresion() {
			return getRuleContext(ListaexpresionContext.class,0);
		}
		public ListaexpresionOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaexpresionOpt; }
	}

	public final ListaexpresionOptContext listaexpresionOpt() throws RecognitionException {
		ListaexpresionOptContext _localctx = new ListaexpresionOptContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_listaexpresionOpt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << IDENT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				setState(400);
				((ListaexpresionOptContext)_localctx).listaexpresion = listaexpresion();
				((ListaexpresionOptContext)_localctx).list =  ((ListaexpresionOptContext)_localctx).listaexpresion.list;
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListaexpresionContext extends ParserRuleContext {
		public List<Expr> list = new ArrayList<Expr>();
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ListaexpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listaexpresion; }
	}

	public final ListaexpresionContext listaexpresion() throws RecognitionException {
		ListaexpresionContext _localctx = new ListaexpresionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_listaexpresion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			((ListaexpresionContext)_localctx).expr = expr(0);
			_localctx.list.add(((ListaexpresionContext)_localctx).expr.ast);
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13) {
				{
				{
				setState(407);
				match(T__13);
				setState(408);
				((ListaexpresionContext)_localctx).expr = expr(0);
				_localctx.list.add(((ListaexpresionContext)_localctx).expr.ast);
				}
				}
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u01a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\6\3F\n\3\r\3\16\3G\3\3\3\3\3\3\3\4\3\4\3\4\6\4P\n\4\r\4\16\4"+
		"Q\3\5\3\5\3\5\5\5W\n\5\3\6\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\5\6"+
		"c\n\6\3\6\3\6\3\6\3\6\7\6i\n\6\f\6\16\6l\13\6\5\6n\n\6\3\7\3\7\3\7\3\7"+
		"\7\7t\n\7\f\7\16\7w\13\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n\u008d\n\n\f\n\16\n\u0090\13\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u00a1\n\13\3\f\3\f\3\f\3\f\5\f\u00a7\n\f\3\f\3\f\3\f\3\f\7\f"+
		"\u00ad\n\f\f\f\16\f\u00b0\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00ba"+
		"\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\6\17\u00c4\n\17\r\17\16\17"+
		"\u00c5\5\17\u00c8\n\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00d0\n\20\f"+
		"\20\16\20\u00d3\13\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\7\22\u00f1\n\22\f\22\16\22\u00f4\13\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00ff\n\22\f\22\16\22\u0102\13"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\5\22\u0113\n\22\3\23\3\23\3\23\3\23\3\23\3\23\6\23\u011b\n\23"+
		"\r\23\16\23\u011c\3\24\3\24\3\24\5\24\u0122\n\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\6\26\u012e\n\26\r\26\16\26\u012f\5\26\u0132"+
		"\n\26\3\27\3\27\3\27\3\27\7\27\u0138\n\27\f\27\16\27\u013b\13\27\5\27"+
		"\u013d\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0164\n\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u018e"+
		"\n\30\f\30\16\30\u0191\13\30\3\31\3\31\3\31\5\31\u0196\n\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\7\32\u019e\n\32\f\32\16\32\u01a1\13\32\3\32\2\3."+
		"\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\7\3\2\32\33"+
		"\3\2+,\4\2&&--\4\2)*./\3\2\60\61\2\u01bd\2\64\3\2\2\2\4>\3\2\2\2\6O\3"+
		"\2\2\2\bV\3\2\2\2\nX\3\2\2\2\fo\3\2\2\2\16{\3\2\2\2\20\u0081\3\2\2\2\22"+
		"\u0087\3\2\2\2\24\u00a0\3\2\2\2\26\u00a2\3\2\2\2\30\u00b9\3\2\2\2\32\u00bb"+
		"\3\2\2\2\34\u00c7\3\2\2\2\36\u00c9\3\2\2\2 \u00d4\3\2\2\2\"\u0112\3\2"+
		"\2\2$\u0114\3\2\2\2&\u0121\3\2\2\2(\u0123\3\2\2\2*\u0131\3\2\2\2,\u013c"+
		"\3\2\2\2.\u0163\3\2\2\2\60\u0195\3\2\2\2\62\u0197\3\2\2\2\64\65\5\4\3"+
		"\2\65\66\7\3\2\2\66\67\7\64\2\2\678\7\4\2\289\5\60\31\29:\7\5\2\2:;\7"+
		"\6\2\2;<\7\7\2\2<=\b\2\1\2=\3\3\2\2\2>?\7\b\2\2?@\7\64\2\2@A\7\6\2\2A"+
		"B\5\b\5\2BC\7\t\2\2CE\5\6\4\2DF\5\26\f\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2"+
		"GH\3\2\2\2HI\3\2\2\2IJ\7\7\2\2JK\b\3\1\2K\5\3\2\2\2LM\7\64\2\2MN\7\6\2"+
		"\2NP\b\4\1\2OL\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\7\3\2\2\2ST\5\n"+
		"\6\2TU\b\5\1\2UW\3\2\2\2VS\3\2\2\2VW\3\2\2\2W\t\3\2\2\2Xb\7\n\2\2Y_\7"+
		"\13\2\2Z[\5\f\7\2[\\\b\6\1\2\\^\3\2\2\2]Z\3\2\2\2^a\3\2\2\2_]\3\2\2\2"+
		"_`\3\2\2\2`c\3\2\2\2a_\3\2\2\2bY\3\2\2\2bc\3\2\2\2cm\3\2\2\2dj\7\f\2\2"+
		"ef\5\20\t\2fg\b\6\1\2gi\3\2\2\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2"+
		"\2kn\3\2\2\2lj\3\2\2\2md\3\2\2\2mn\3\2\2\2n\13\3\2\2\2op\7\r\2\2pq\7\64"+
		"\2\2qu\7\16\2\2rt\5\16\b\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3"+
		"\2\2\2wu\3\2\2\2xy\7\7\2\2yz\b\7\1\2z\r\3\2\2\2{|\7\64\2\2|}\7\17\2\2"+
		"}~\5\24\13\2~\177\7\6\2\2\177\u0080\b\b\1\2\u0080\17\3\2\2\2\u0081\u0082"+
		"\5\22\n\2\u0082\u0083\7\17\2\2\u0083\u0084\5\24\13\2\u0084\u0085\7\6\2"+
		"\2\u0085\u0086\b\t\1\2\u0086\21\3\2\2\2\u0087\u0088\7\64\2\2\u0088\u008e"+
		"\b\n\1\2\u0089\u008a\7\20\2\2\u008a\u008b\7\64\2\2\u008b\u008d\b\n\1\2"+
		"\u008c\u0089\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\23\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7\21\2\2\u0092"+
		"\u0093\7\65\2\2\u0093\u0094\7\22\2\2\u0094\u0095\3\2\2\2\u0095\u0096\5"+
		"\24\13\2\u0096\u0097\b\13\1\2\u0097\u00a1\3\2\2\2\u0098\u0099\7\23\2\2"+
		"\u0099\u00a1\b\13\1\2\u009a\u009b\7\24\2\2\u009b\u00a1\b\13\1\2\u009c"+
		"\u009d\7\25\2\2\u009d\u00a1\b\13\1\2\u009e\u009f\7\64\2\2\u009f\u00a1"+
		"\b\13\1\2\u00a0\u0091\3\2\2\2\u00a0\u0098\3\2\2\2\u00a0\u009a\3\2\2\2"+
		"\u00a0\u009c\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\25\3\2\2\2\u00a2\u00a3"+
		"\7\26\2\2\u00a3\u00a4\7\64\2\2\u00a4\u00a6\5\30\r\2\u00a5\u00a7\5\32\16"+
		"\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9"+
		"\7\27\2\2\u00a9\u00aa\5\34\17\2\u00aa\u00ae\7\30\2\2\u00ab\u00ad\5\"\22"+
		"\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\7\7\2\2\u00b2"+
		"\u00b3\b\f\1\2\u00b3\27\3\2\2\2\u00b4\u00b5\7\4\2\2\u00b5\u00b6\5\36\20"+
		"\2\u00b6\u00b7\7\5\2\2\u00b7\u00b8\b\r\1\2\u00b8\u00ba\3\2\2\2\u00b9\u00b4"+
		"\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\31\3\2\2\2\u00bb\u00bc\7\17\2\2\u00bc"+
		"\u00bd\5\24\13\2\u00bd\u00be\b\16\1\2\u00be\33\3\2\2\2\u00bf\u00c3\7\31"+
		"\2\2\u00c0\u00c1\5\20\t\2\u00c1\u00c2\b\17\1\2\u00c2\u00c4\3\2\2\2\u00c3"+
		"\u00c0\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\35\3\2\2\2\u00c9\u00ca\5 \21\2\u00ca\u00d1\b\20\1\2\u00cb\u00cc\7\20"+
		"\2\2\u00cc\u00cd\5 \21\2\u00cd\u00ce\b\20\1\2\u00ce\u00d0\3\2\2\2\u00cf"+
		"\u00cb\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\37\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7\64\2\2\u00d5\u00d6"+
		"\7\17\2\2\u00d6\u00d7\5\24\13\2\u00d7\u00d8\b\21\1\2\u00d8!\3\2\2\2\u00d9"+
		"\u00da\t\2\2\2\u00da\u00db\5\60\31\2\u00db\u00dc\7\6\2\2\u00dc\u00dd\b"+
		"\22\1\2\u00dd\u0113\3\2\2\2\u00de\u00df\7\34\2\2\u00df\u00e0\5\62\32\2"+
		"\u00e0\u00e1\7\6\2\2\u00e1\u00e2\b\22\1\2\u00e2\u0113\3\2\2\2\u00e3\u00e4"+
		"\5(\25\2\u00e4\u00e5\b\22\1\2\u00e5\u0113\3\2\2\2\u00e6\u00e7\5$\23\2"+
		"\u00e7\u00e8\7\35\2\2\u00e8\u00e9\5.\30\2\u00e9\u00ea\7\6\2\2\u00ea\u00eb"+
		"\b\22\1\2\u00eb\u0113\3\2\2\2\u00ec\u00ed\7\36\2\2\u00ed\u00ee\5.\30\2"+
		"\u00ee\u00f2\7\37\2\2\u00ef\u00f1\5\"\22\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4"+
		"\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f5\u00f6\5*\26\2\u00f6\u00f7\7\7\2\2\u00f7\u00f8\b\22"+
		"\1\2\u00f8\u0113\3\2\2\2\u00f9\u00fa\5,\27\2\u00fa\u00fb\7 \2\2\u00fb"+
		"\u00fc\5.\30\2\u00fc\u0100\7!\2\2\u00fd\u00ff\5\"\22\2\u00fe\u00fd\3\2"+
		"\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\7\7\2\2\u0104\u0105\b\22"+
		"\1\2\u0105\u0113\3\2\2\2\u0106\u0107\7\64\2\2\u0107\u0108\7\4\2\2\u0108"+
		"\u0109\5\60\31\2\u0109\u010a\7\5\2\2\u010a\u010b\7\6\2\2\u010b\u010c\b"+
		"\22\1\2\u010c\u0113\3\2\2\2\u010d\u010e\7\"\2\2\u010e\u010f\5&\24\2\u010f"+
		"\u0110\7\6\2\2\u0110\u0111\b\22\1\2\u0111\u0113\3\2\2\2\u0112\u00d9\3"+
		"\2\2\2\u0112\u00de\3\2\2\2\u0112\u00e3\3\2\2\2\u0112\u00e6\3\2\2\2\u0112"+
		"\u00ec\3\2\2\2\u0112\u00f9\3\2\2\2\u0112\u0106\3\2\2\2\u0112\u010d\3\2"+
		"\2\2\u0113#\3\2\2\2\u0114\u0115\5.\30\2\u0115\u011a\b\23\1\2\u0116\u0117"+
		"\7\35\2\2\u0117\u0118\5.\30\2\u0118\u0119\b\23\1\2\u0119\u011b\3\2\2\2"+
		"\u011a\u0116\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011d%\3\2\2\2\u011e\u011f\5.\30\2\u011f\u0120\b\24\1\2\u0120"+
		"\u0122\3\2\2\2\u0121\u011e\3\2\2\2\u0121\u0122\3\2\2\2\u0122\'\3\2\2\2"+
		"\u0123\u0124\5.\30\2\u0124\u0125\7\35\2\2\u0125\u0126\5.\30\2\u0126\u0127"+
		"\7\6\2\2\u0127\u0128\b\25\1\2\u0128)\3\2\2\2\u0129\u012d\7#\2\2\u012a"+
		"\u012b\5\"\22\2\u012b\u012c\b\26\1\2\u012c\u012e\3\2\2\2\u012d\u012a\3"+
		"\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0132\3\2\2\2\u0131\u0129\3\2\2\2\u0131\u0132\3\2\2\2\u0132+\3\2\2\2"+
		"\u0133\u0139\7$\2\2\u0134\u0135\5(\25\2\u0135\u0136\b\27\1\2\u0136\u0138"+
		"\3\2\2\2\u0137\u0134\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u0133\3\2"+
		"\2\2\u013c\u013d\3\2\2\2\u013d-\3\2\2\2\u013e\u013f\b\30\1\2\u013f\u0140"+
		"\7\65\2\2\u0140\u0164\b\30\1\2\u0141\u0142\7\66\2\2\u0142\u0164\b\30\1"+
		"\2\u0143\u0144\7\67\2\2\u0144\u0164\b\30\1\2\u0145\u0146\7\64\2\2\u0146"+
		"\u0164\b\30\1\2\u0147\u0148\7\64\2\2\u0148\u0149\7\4\2\2\u0149\u014a\5"+
		"\60\31\2\u014a\u014b\7\5\2\2\u014b\u014c\b\30\1\2\u014c\u0164\3\2\2\2"+
		"\u014d\u014e\7&\2\2\u014e\u014f\5.\30\f\u014f\u0150\b\30\1\2\u0150\u0164"+
		"\3\2\2\2\u0151\u0152\7\4\2\2\u0152\u0153\5.\30\2\u0153\u0154\7\5\2\2\u0154"+
		"\u0155\b\30\1\2\u0155\u0164\3\2\2\2\u0156\u0157\7\'\2\2\u0157\u0158\5"+
		".\30\n\u0158\u0159\b\30\1\2\u0159\u0164\3\2\2\2\u015a\u015b\7(\2\2\u015b"+
		"\u015c\7)\2\2\u015c\u015d\5\24\13\2\u015d\u015e\7*\2\2\u015e\u015f\7\4"+
		"\2\2\u015f\u0160\5.\30\2\u0160\u0161\7\5\2\2\u0161\u0162\b\30\1\2\u0162"+
		"\u0164\3\2\2\2\u0163\u013e\3\2\2\2\u0163\u0141\3\2\2\2\u0163\u0143\3\2"+
		"\2\2\u0163\u0145\3\2\2\2\u0163\u0147\3\2\2\2\u0163\u014d\3\2\2\2\u0163"+
		"\u0151\3\2\2\2\u0163\u0156\3\2\2\2\u0163\u015a\3\2\2\2\u0164\u018f\3\2"+
		"\2\2\u0165\u0166\f\b\2\2\u0166\u0167\t\3\2\2\u0167\u0168\5.\30\t\u0168"+
		"\u0169\b\30\1\2\u0169\u018e\3\2\2\2\u016a\u016b\f\7\2\2\u016b\u016c\t"+
		"\4\2\2\u016c\u016d\5.\30\b\u016d\u016e\b\30\1\2\u016e\u018e\3\2\2\2\u016f"+
		"\u0170\f\6\2\2\u0170\u0171\t\5\2\2\u0171\u0172\5.\30\7\u0172\u0173\b\30"+
		"\1\2\u0173\u018e\3\2\2\2\u0174\u0175\f\5\2\2\u0175\u0176\t\6\2\2\u0176"+
		"\u0177\5.\30\6\u0177\u0178\b\30\1\2\u0178\u018e\3\2\2\2\u0179\u017a\f"+
		"\4\2\2\u017a\u017b\7\62\2\2\u017b\u017c\5.\30\5\u017c\u017d\b\30\1\2\u017d"+
		"\u018e\3\2\2\2\u017e\u017f\f\3\2\2\u017f\u0180\7\63\2\2\u0180\u0181\5"+
		".\30\4\u0181\u0182\b\30\1\2\u0182\u018e\3\2\2\2\u0183\u0184\f\16\2\2\u0184"+
		"\u0185\7\21\2\2\u0185\u0186\5.\30\2\u0186\u0187\7\22\2\2\u0187\u0188\b"+
		"\30\1\2\u0188\u018e\3\2\2\2\u0189\u018a\f\r\2\2\u018a\u018b\7%\2\2\u018b"+
		"\u018c\7\64\2\2\u018c\u018e\b\30\1\2\u018d\u0165\3\2\2\2\u018d\u016a\3"+
		"\2\2\2\u018d\u016f\3\2\2\2\u018d\u0174\3\2\2\2\u018d\u0179\3\2\2\2\u018d"+
		"\u017e\3\2\2\2\u018d\u0183\3\2\2\2\u018d\u0189\3\2\2\2\u018e\u0191\3\2"+
		"\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190/\3\2\2\2\u0191\u018f"+
		"\3\2\2\2\u0192\u0193\5\62\32\2\u0193\u0194\b\31\1\2\u0194\u0196\3\2\2"+
		"\2\u0195\u0192\3\2\2\2\u0195\u0196\3\2\2\2\u0196\61\3\2\2\2\u0197\u0198"+
		"\5.\30\2\u0198\u019f\b\32\1\2\u0199\u019a\7\20\2\2\u019a\u019b\5.\30\2"+
		"\u019b\u019c\b\32\1\2\u019c\u019e\3\2\2\2\u019d\u0199\3\2\2\2\u019e\u01a1"+
		"\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\63\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2 GQV_bjmu\u008e\u00a0\u00a6\u00ae\u00b9\u00c5\u00c7\u00d1"+
		"\u00f2\u0100\u0112\u011c\u0121\u012f\u0131\u0139\u013c\u0163\u018d\u018f"+
		"\u0195\u019f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}