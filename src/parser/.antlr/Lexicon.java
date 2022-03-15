// Generated from d:\ClaseTercero\SegundoCuatri\DLP\TraductorFinal\src\parser\Lexicon.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Lexicon extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENT=1, INT_CONSTANT=2, REAL_CONSTANT=3, CHAR_CONSTANT=4, LINE_COMMENT=5, 
		MULTILINE_COMMENT=6, WHITESPACE=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IDENT", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "LINE_COMMENT", 
			"MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IDENT", "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "LINE_COMMENT", 
			"MULTILINE_COMMENT", "WHITESPACE"
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


	public Lexicon(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexicon.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\tV\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\3\6\3\32\n\3\r\3\16\3\33\3\4\6\4\37\n\4\r\4\16\4 \3\4"+
		"\3\4\6\4%\n\4\r\4\16\4&\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\60\n\5\3\6\3\6"+
		"\3\6\3\6\7\6\66\n\6\f\6\16\69\13\6\3\6\5\6<\n\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\7\7E\n\7\f\7\16\7H\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\6\bQ\n\b\r"+
		"\b\16\bR\3\b\3\b\4\67F\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\b\4\2C\\"+
		"c|\6\2\62;C\\aac|\3\2\62;\4\2\13\f\17\17\3\3\f\f\5\2\13\f\17\17\"\"\2"+
		"]\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\31\3\2\2\2\7\36\3\2\2\2\t/\3\2\2\2\13"+
		"\61\3\2\2\2\r?\3\2\2\2\17P\3\2\2\2\21\25\t\2\2\2\22\24\t\3\2\2\23\22\3"+
		"\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\4\3\2\2\2\27\25\3"+
		"\2\2\2\30\32\t\4\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3"+
		"\2\2\2\34\6\3\2\2\2\35\37\t\4\2\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2"+
		"\2 !\3\2\2\2!\"\3\2\2\2\"$\7\60\2\2#%\t\4\2\2$#\3\2\2\2%&\3\2\2\2&$\3"+
		"\2\2\2&\'\3\2\2\2\'\b\3\2\2\2()\7)\2\2)*\n\5\2\2*\60\7)\2\2+,\7)\2\2,"+
		"-\7^\2\2-.\7p\2\2.\60\7)\2\2/(\3\2\2\2/+\3\2\2\2\60\n\3\2\2\2\61\62\7"+
		"\61\2\2\62\63\7,\2\2\63\67\3\2\2\2\64\66\13\2\2\2\65\64\3\2\2\2\669\3"+
		"\2\2\2\678\3\2\2\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\2:<\t\6\2\2;:\3\2"+
		"\2\2<=\3\2\2\2=>\b\6\2\2>\f\3\2\2\2?@\7\61\2\2@A\7\61\2\2AB\7,\2\2BF\3"+
		"\2\2\2CE\13\2\2\2DC\3\2\2\2EH\3\2\2\2FG\3\2\2\2FD\3\2\2\2GI\3\2\2\2HF"+
		"\3\2\2\2IJ\7,\2\2JK\7\61\2\2KL\7\61\2\2LM\3\2\2\2MN\b\7\2\2N\16\3\2\2"+
		"\2OQ\t\7\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\b\2"+
		"\2U\20\3\2\2\2\f\2\25\33 &/\67;FR\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}