###
# This Makefile can be used to make a parser for the CSX language
# (parser.class) and to make a program (P3.class) that tests the parser and
# the unparse methods in ast.java.
#
# make clean removes all generated files.
#
# Augmented by John Peterson
# 31 MAR 2014
# CS536 P3
###

JC = javac

P3.class: P3.java parser.class Yylex.class ASTnode.class
	$(JC) -g P3.java

parser.class: parser.java ASTnode.class Yylex.class ErrMsg.class
	$(JC) parser.java

parser.java: CSX.cup
	java java_cup.Main < CSX.cup

Yylex.class: CSX.jlex.java sym.class ErrMsg.class
	$(JC) CSX.jlex.java

ASTnode.class: ast.java
	$(JC) -g ast.java

CSX.jlex.java: CSX.jlex sym.class
	java JLex.Main CSX.jlex

sym.class: sym.java
	$(JC) -g sym.java

sym.java: CSX.cup
	java java_cup.Main < CSX.cup

ErrMsg.class: ErrMsg.java
	$(JC) ErrMsg.java

test: test.csx P3.java
	java P3 test.csx test.out
###
# clean
###
clean:
	rm -f *~ *.class parser.java CSX.jlex.java sym.java
