###
# This Makefile can be used to make a scanner for the CSX language
# (Yylex.class) and to make a program that tests the scanner (P2.class).
#
# The default makes both the scanner and the test program.
#
# make clean removes all generated files.
#
# Note: P2.java will not compile unless Yylex.class exists.
#
###

# define the java compiler to be used and the flags
JC = javac
FLAGS = -g

P2.class: P2.java Yylex.class sym.class
	$(JC) $(FLAGS) P2.java

Yylex.class: CSX.jlex.java ErrMsg.class sym.class
	$(JC) $(FLAGS) CSX.jlex.java

CSX.jlex.java: CSX.jlex sym.class
	java JLex.Main CSX.jlex

sym.class: sym.java
	$(JC) $(FLAGS) sym.java

ErrMsg.class: ErrMsg.java
	$(JC) $(FLAGS) ErrMsg.java

	
###
# testing - add more here to run your tester and compare its results
# to expected results
###
test:
	make cleantest
	java P2 tests/allValidChars >& tests/allValidChars.error
	diff tests/allValidChars.error tests/allValidChars.expected.error
	diff tests/allValidChars.out tests/allValidChars.expected.out
	java P2 tests/badInts >& tests/badInts.error
	diff tests/badInts.error tests/badInts.expected.error
	diff tests/badInts.out tests/badInts.expected.out
	java P2 tests/invalidIdentifiers >& tests/invalidIdentifiers.error
	diff tests/invalidIdentifiers.error tests/invalidIdentifiers.expected.error
	diff tests/invalidIdentifiers.out tests/invalidIdentifiers.expected.out
	java P2 tests/validIdentifiers >& tests/validIdentifiers.error
	diff tests/validIdentifiers.error tests/validIdentifiers.expected.error
	diff tests/validIdentifiers.out tests/validIdentifiers.expected.out
	java P2 tests/reservedTokens >& tests/reservedTokens.error
	diff tests/reservedTokens.error tests/reservedTokens.expected.error
	diff tests/reservedTokens.out tests/reservedTokens.expected.out
	java P2 tests/comments >& tests/comments.error
	diff tests/comments.error tests/comments.expected.error
	diff tests/comments.out tests/comments.expected.out
	java P2 tests/unterminatedStrings >& tests/unterminatedStrings.error
	diff tests/unterminatedStrings.error tests/unterminatedStrings.expected.error
	diff tests/unterminatedStrings.out tests/unterminatedStrings.expected.out
	java P2 tests/goodStrings >& tests/goodStrings.error
	diff tests/goodStrings.error tests/goodStrings.expected.error
	diff tests/goodStrings.out tests/goodStrings.expected.out
	java P2 tests/eof.txt >& tests/eof.txt.error
	diff tests/eof.txt.error tests/eof.txt.expected.error
	diff tests/eof.txt.out tests/eof.txt.expected.out
###
# clean up
###

clean:
	rm -f *~ *.class CSX.jlex.java

cleantest:
	rm -f tests/*[!d].out
	rm -f tests/*[!d].error
