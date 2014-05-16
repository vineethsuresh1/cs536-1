import java.util.*;
import java.io.*;
import java_cup.runtime.*;  // defines Symbol

/**
 * This program is to be used to test the CSX scanner.
 * This version is set up to test all tokens, but more code is needed to test 
 * other aspects of the scanner (e.g., input that causes errors, character 
 * numbers, values associated with tokens)
 */
public class P2 {
    public static void main(String[] args) throws IOException {
                                           // exception may be thrown by yylex
        CharNum.num = 1;
    
        // error check arguments length
        if(args.length < 1) {
            System.err.println("file name to scan required");
            System.exit(-1);
        }
        else {
            // test each file inputted one by one
            for(int i=0; i<args.length; i++) testAllTokens(args[i]);
        }
    }


    /**
     * testAllTokens
     *
     * Open and read from file specified
     * For each token read, write the corresponding string to inFile.out
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the input and output files
     * (e.g., using a 'diff' command).
     *
     * @param testFile file containing tokens to be scanned
     */
    private static void testAllTokens(String testFile) throws IOException {
        // open input and output files
        FileReader inFile = null;
        PrintWriter outFile = null;
        try {
            inFile = new FileReader(testFile);
            outFile = new PrintWriter(new FileWriter(testFile + ".out"));
        } catch (FileNotFoundException ex) {
            System.err.println("File " + testFile + " not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println(testFile + ".out cannot be opened. Skipping.");
            return;
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
            switch (token.sym) {
            // print token type, line number and character number line-separated
            case sym.BOOL:
                outFile.println("Token: BOOL\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n"); 
                break;
	    case sym.INT:
                outFile.println("Token: INT\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.VOID:
                outFile.println("Token: VOID\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.TRUE:
                outFile.println("Token: TRUE\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.FALSE:
                outFile.println("Token: FALSE\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.STRUCT:
                outFile.println("Token: STRUCT\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.CIN:
                outFile.println("Token: CIN\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.COUT:
                outFile.println("Token: COUT\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;				
            case sym.IF:
                outFile.println("Token: IF\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.ELSE:
                outFile.println("Token: ELSE\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.WHILE:
                outFile.println("Token: WHILE\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.RETURN:
                outFile.println("Token: RETURN\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.ID:
                outFile.println("Token: ID\n" + 
                    "LineNum: " + ((TokenVal)token.value).linenum  + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum  + "\n" +
                    "Value: "   + ((IdTokenVal)token.value).idVal + "\n");
                break;
            case sym.INTLITERAL:  
                outFile.println("Token: INTLITERAL\n" +
                    "LineNum: " + ((TokenVal)token.value).linenum  + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum  + "\n" +
                    "Value: "   + ((IntLitTokenVal)token.value).intVal + "\n");
                break;
            case sym.STRINGLITERAL:
                outFile.println("Token: STRINGLITERAL\n" +
                    "LineNum: " + ((TokenVal)token.value).linenum  + "\n" +
                    "CharNum: " + ((TokenVal)token.value).charnum  + "\n" +
                    "Value: "   + ((StrLitTokenVal)token.value).strVal + "\n"); 
                break;    
            case sym.LCURLY:
                outFile.println("Token: LCURLY\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.RCURLY:
                outFile.println("Token: RCURLY\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.LPAREN:
                outFile.println("Token: LPAREN\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.RPAREN:
                outFile.println("Token: RPAREN\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.SEMICOLON:
                outFile.println("Token: SEMICOLON\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.COMMA:
                outFile.println("Token: COMMA\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.DOT:
                outFile.println("Token: DOT\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.WRITE:
                outFile.println("Token: WRITE\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.READ:
                outFile.println("Token: READ\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;				
            case sym.PLUSPLUS:
                outFile.println("Token: PLUSPLUS\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.MINUSMINUS:
                outFile.println("Token: MINUSMINUS\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;	
            case sym.PLUS:
                outFile.println("Token: PLUS\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.MINUS:
                outFile.println("Token: MINUS\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.TIMES:
                outFile.println("Token: TIMES\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.DIVIDE:
                outFile.println("Token: DIVIDE\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.NOT:
                outFile.println("Token: NOT\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.AND:
                outFile.println("Token: AND\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.OR:
                outFile.println("Token: OR\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.EQUALS:
                outFile.println("Token: EQUALS\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.NOTEQUALS:
                outFile.println("Token: NOTEQUALS\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.LESS:
                outFile.println("Token: LESS\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.GREATER:
                outFile.println("Token: GREATER\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.LESSEQ:
                outFile.println("Token: LESSEQ\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
            case sym.GREATEREQ:
                outFile.println("Token: GREATEREQ\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
	    case sym.ASSIGN:
                outFile.println("Token: ASSIGN\n" +
                "LineNum: " + ((TokenVal)token.value).linenum + "\n" +
                "CharNum: " + ((TokenVal)token.value).charnum + "\n");
                break;
	    default:
		outFile.println("UNKNOWN TOKEN");
            } // end switch

            token = scanner.next_token();
        } // end while
        outFile.close();
    }
}
