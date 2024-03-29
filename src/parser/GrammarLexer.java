// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"IDENT", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "LINE_COMMENT", 
			"MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'('", "')'", "';'", "'end'", "'class'", "'create'", 
			"'global'", "'types'", "'vars'", "'deftuple'", "'as'", "':'", "','", 
			"'['", "']'", "'INTEGER'", "'CHARACTER'", "'DOUBLE'", "'feature'", "'is'", 
			"'do'", "'local'", "'print'", "'println'", "'read'", "'if'", "'then'", 
			"'until'", "'loop'", "'return'", "':='", "'else'", "'from'", "'.'", "'-'", 
			"'not'", "'to'", "'<'", "'>'", "'*'", "'/'", "'+'", "'>='", "'<='", "'='", 
			"'<>'", "'and'", "'or'"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u0188\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3%\3%\3&\3&\3&\3&\3\'\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\60"+
		"\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\7\63\u0146\n\63\f\63\16"+
		"\63\u0149\13\63\3\64\6\64\u014c\n\64\r\64\16\64\u014d\3\65\6\65\u0151"+
		"\n\65\r\65\16\65\u0152\3\65\3\65\6\65\u0157\n\65\r\65\16\65\u0158\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0162\n\66\3\67\3\67\3\67\3\67\7\67"+
		"\u0168\n\67\f\67\16\67\u016b\13\67\3\67\5\67\u016e\n\67\3\67\3\67\38\3"+
		"8\38\38\38\78\u0177\n8\f8\168\u017a\138\38\38\38\38\38\38\39\69\u0183"+
		"\n9\r9\169\u0184\39\39\4\u0169\u0178\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:\3\2\b\4\2C\\c|\6\2\62;C\\"+
		"aac|\3\2\62;\4\2\13\f\17\17\3\3\f\f\5\2\13\f\17\17\"\"\2\u018f\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2"+
		"c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3"+
		"\2\2\2\2q\3\2\2\2\3s\3\2\2\2\5x\3\2\2\2\7z\3\2\2\2\t|\3\2\2\2\13~\3\2"+
		"\2\2\r\u0082\3\2\2\2\17\u0088\3\2\2\2\21\u008f\3\2\2\2\23\u0096\3\2\2"+
		"\2\25\u009c\3\2\2\2\27\u00a1\3\2\2\2\31\u00aa\3\2\2\2\33\u00ad\3\2\2\2"+
		"\35\u00af\3\2\2\2\37\u00b1\3\2\2\2!\u00b3\3\2\2\2#\u00b5\3\2\2\2%\u00bd"+
		"\3\2\2\2\'\u00c7\3\2\2\2)\u00ce\3\2\2\2+\u00d6\3\2\2\2-\u00d9\3\2\2\2"+
		"/\u00dc\3\2\2\2\61\u00e2\3\2\2\2\63\u00e8\3\2\2\2\65\u00f0\3\2\2\2\67"+
		"\u00f5\3\2\2\29\u00f8\3\2\2\2;\u00fd\3\2\2\2=\u0103\3\2\2\2?\u0108\3\2"+
		"\2\2A\u010f\3\2\2\2C\u0112\3\2\2\2E\u0117\3\2\2\2G\u011c\3\2\2\2I\u011e"+
		"\3\2\2\2K\u0120\3\2\2\2M\u0124\3\2\2\2O\u0127\3\2\2\2Q\u0129\3\2\2\2S"+
		"\u012b\3\2\2\2U\u012d\3\2\2\2W\u012f\3\2\2\2Y\u0131\3\2\2\2[\u0134\3\2"+
		"\2\2]\u0137\3\2\2\2_\u0139\3\2\2\2a\u013c\3\2\2\2c\u0140\3\2\2\2e\u0143"+
		"\3\2\2\2g\u014b\3\2\2\2i\u0150\3\2\2\2k\u0161\3\2\2\2m\u0163\3\2\2\2o"+
		"\u0171\3\2\2\2q\u0182\3\2\2\2st\7o\2\2tu\7c\2\2uv\7k\2\2vw\7p\2\2w\4\3"+
		"\2\2\2xy\7*\2\2y\6\3\2\2\2z{\7+\2\2{\b\3\2\2\2|}\7=\2\2}\n\3\2\2\2~\177"+
		"\7g\2\2\177\u0080\7p\2\2\u0080\u0081\7f\2\2\u0081\f\3\2\2\2\u0082\u0083"+
		"\7e\2\2\u0083\u0084\7n\2\2\u0084\u0085\7c\2\2\u0085\u0086\7u\2\2\u0086"+
		"\u0087\7u\2\2\u0087\16\3\2\2\2\u0088\u0089\7e\2\2\u0089\u008a\7t\2\2\u008a"+
		"\u008b\7g\2\2\u008b\u008c\7c\2\2\u008c\u008d\7v\2\2\u008d\u008e\7g\2\2"+
		"\u008e\20\3\2\2\2\u008f\u0090\7i\2\2\u0090\u0091\7n\2\2\u0091\u0092\7"+
		"q\2\2\u0092\u0093\7d\2\2\u0093\u0094\7c\2\2\u0094\u0095\7n\2\2\u0095\22"+
		"\3\2\2\2\u0096\u0097\7v\2\2\u0097\u0098\7{\2\2\u0098\u0099\7r\2\2\u0099"+
		"\u009a\7g\2\2\u009a\u009b\7u\2\2\u009b\24\3\2\2\2\u009c\u009d\7x\2\2\u009d"+
		"\u009e\7c\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7u\2\2\u00a0\26\3\2\2\2\u00a1"+
		"\u00a2\7f\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5\7v\2\2"+
		"\u00a5\u00a6\7w\2\2\u00a6\u00a7\7r\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9"+
		"\7g\2\2\u00a9\30\3\2\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7u\2\2\u00ac\32"+
		"\3\2\2\2\u00ad\u00ae\7<\2\2\u00ae\34\3\2\2\2\u00af\u00b0\7.\2\2\u00b0"+
		"\36\3\2\2\2\u00b1\u00b2\7]\2\2\u00b2 \3\2\2\2\u00b3\u00b4\7_\2\2\u00b4"+
		"\"\3\2\2\2\u00b5\u00b6\7K\2\2\u00b6\u00b7\7P\2\2\u00b7\u00b8\7V\2\2\u00b8"+
		"\u00b9\7G\2\2\u00b9\u00ba\7I\2\2\u00ba\u00bb\7G\2\2\u00bb\u00bc\7T\2\2"+
		"\u00bc$\3\2\2\2\u00bd\u00be\7E\2\2\u00be\u00bf\7J\2\2\u00bf\u00c0\7C\2"+
		"\2\u00c0\u00c1\7T\2\2\u00c1\u00c2\7C\2\2\u00c2\u00c3\7E\2\2\u00c3\u00c4"+
		"\7V\2\2\u00c4\u00c5\7G\2\2\u00c5\u00c6\7T\2\2\u00c6&\3\2\2\2\u00c7\u00c8"+
		"\7F\2\2\u00c8\u00c9\7Q\2\2\u00c9\u00ca\7W\2\2\u00ca\u00cb\7D\2\2\u00cb"+
		"\u00cc\7N\2\2\u00cc\u00cd\7G\2\2\u00cd(\3\2\2\2\u00ce\u00cf\7h\2\2\u00cf"+
		"\u00d0\7g\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7w\2\2"+
		"\u00d3\u00d4\7t\2\2\u00d4\u00d5\7g\2\2\u00d5*\3\2\2\2\u00d6\u00d7\7k\2"+
		"\2\u00d7\u00d8\7u\2\2\u00d8,\3\2\2\2\u00d9\u00da\7f\2\2\u00da\u00db\7"+
		"q\2\2\u00db.\3\2\2\2\u00dc\u00dd\7n\2\2\u00dd\u00de\7q\2\2\u00de\u00df"+
		"\7e\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7n\2\2\u00e1\60\3\2\2\2\u00e2\u00e3"+
		"\7r\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6\7p\2\2\u00e6"+
		"\u00e7\7v\2\2\u00e7\62\3\2\2\2\u00e8\u00e9\7r\2\2\u00e9\u00ea\7t\2\2\u00ea"+
		"\u00eb\7k\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7n\2\2"+
		"\u00ee\u00ef\7p\2\2\u00ef\64\3\2\2\2\u00f0\u00f1\7t\2\2\u00f1\u00f2\7"+
		"g\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7f\2\2\u00f4\66\3\2\2\2\u00f5\u00f6"+
		"\7k\2\2\u00f6\u00f7\7h\2\2\u00f78\3\2\2\2\u00f8\u00f9\7v\2\2\u00f9\u00fa"+
		"\7j\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7p\2\2\u00fc:\3\2\2\2\u00fd\u00fe"+
		"\7w\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7v\2\2\u0100\u0101\7k\2\2\u0101"+
		"\u0102\7n\2\2\u0102<\3\2\2\2\u0103\u0104\7n\2\2\u0104\u0105\7q\2\2\u0105"+
		"\u0106\7q\2\2\u0106\u0107\7r\2\2\u0107>\3\2\2\2\u0108\u0109\7t\2\2\u0109"+
		"\u010a\7g\2\2\u010a\u010b\7v\2\2\u010b\u010c\7w\2\2\u010c\u010d\7t\2\2"+
		"\u010d\u010e\7p\2\2\u010e@\3\2\2\2\u010f\u0110\7<\2\2\u0110\u0111\7?\2"+
		"\2\u0111B\3\2\2\2\u0112\u0113\7g\2\2\u0113\u0114\7n\2\2\u0114\u0115\7"+
		"u\2\2\u0115\u0116\7g\2\2\u0116D\3\2\2\2\u0117\u0118\7h\2\2\u0118\u0119"+
		"\7t\2\2\u0119\u011a\7q\2\2\u011a\u011b\7o\2\2\u011bF\3\2\2\2\u011c\u011d"+
		"\7\60\2\2\u011dH\3\2\2\2\u011e\u011f\7/\2\2\u011fJ\3\2\2\2\u0120\u0121"+
		"\7p\2\2\u0121\u0122\7q\2\2\u0122\u0123\7v\2\2\u0123L\3\2\2\2\u0124\u0125"+
		"\7v\2\2\u0125\u0126\7q\2\2\u0126N\3\2\2\2\u0127\u0128\7>\2\2\u0128P\3"+
		"\2\2\2\u0129\u012a\7@\2\2\u012aR\3\2\2\2\u012b\u012c\7,\2\2\u012cT\3\2"+
		"\2\2\u012d\u012e\7\61\2\2\u012eV\3\2\2\2\u012f\u0130\7-\2\2\u0130X\3\2"+
		"\2\2\u0131\u0132\7@\2\2\u0132\u0133\7?\2\2\u0133Z\3\2\2\2\u0134\u0135"+
		"\7>\2\2\u0135\u0136\7?\2\2\u0136\\\3\2\2\2\u0137\u0138\7?\2\2\u0138^\3"+
		"\2\2\2\u0139\u013a\7>\2\2\u013a\u013b\7@\2\2\u013b`\3\2\2\2\u013c\u013d"+
		"\7c\2\2\u013d\u013e\7p\2\2\u013e\u013f\7f\2\2\u013fb\3\2\2\2\u0140\u0141"+
		"\7q\2\2\u0141\u0142\7t\2\2\u0142d\3\2\2\2\u0143\u0147\t\2\2\2\u0144\u0146"+
		"\t\3\2\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148f\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014c\t\4\2\2"+
		"\u014b\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e"+
		"\3\2\2\2\u014eh\3\2\2\2\u014f\u0151\t\4\2\2\u0150\u014f\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2"+
		"\2\2\u0154\u0156\7\60\2\2\u0155\u0157\t\4\2\2\u0156\u0155\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159j\3\2\2\2"+
		"\u015a\u015b\7)\2\2\u015b\u015c\n\5\2\2\u015c\u0162\7)\2\2\u015d\u015e"+
		"\7)\2\2\u015e\u015f\7^\2\2\u015f\u0160\7p\2\2\u0160\u0162\7)\2\2\u0161"+
		"\u015a\3\2\2\2\u0161\u015d\3\2\2\2\u0162l\3\2\2\2\u0163\u0164\7\61\2\2"+
		"\u0164\u0165\7,\2\2\u0165\u0169\3\2\2\2\u0166\u0168\13\2\2\2\u0167\u0166"+
		"\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u016a\3\2\2\2\u0169\u0167\3\2\2\2\u016a"+
		"\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016e\t\6\2\2\u016d\u016c\3\2"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u0170\b\67\2\2\u0170n\3\2\2\2\u0171\u0172"+
		"\7\61\2\2\u0172\u0173\7\61\2\2\u0173\u0174\7,\2\2\u0174\u0178\3\2\2\2"+
		"\u0175\u0177\13\2\2\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0179"+
		"\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b"+
		"\u017c\7,\2\2\u017c\u017d\7\61\2\2\u017d\u017e\7\61\2\2\u017e\u017f\3"+
		"\2\2\2\u017f\u0180\b8\2\2\u0180p\3\2\2\2\u0181\u0183\t\7\2\2\u0182\u0181"+
		"\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u0186\u0187\b9\2\2\u0187r\3\2\2\2\f\2\u0147\u014d\u0152"+
		"\u0158\u0161\u0169\u016d\u0178\u0184\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}