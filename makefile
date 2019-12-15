clean:
	find . -type f -path "./ast/*" -name "*.class" -exec rm -f {} \;
	find . -type f -path "./codegen/*" -name "*.class" -exec rm -f {} \;
	find . -type f -path "./compiler/*" -name "*.class" -exec rm -f {} \;
	find . -type f -path "./constrain/*" -name "*.class" -exec rm -f {} \;
	find . -type f -path "./lexer/*" -name "*.class" -exec rm -f {} \;
	find . -type f -path "./parser/*" -name "*.class" -exec rm -f {} \;
	find . -type f -path "./visitor/*" -name "*.class" -exec rm -f {} \;
	find . -type f -path "./sample_files/*" -name "*.x.cod" -exec rm -f {} \;

compile:
	javac compiler/Compiler.java

lexerSetup:
	javac lexer/setup/TokenSetup.java
	java lexer.setup.TokenSetup

lexer/simple:
	javac lexer/Lexer.java
	java lexer.Lexer sample_files/simple.x

semicolon:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/semicolon.x

simple:
	make clean
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/simple.x

void:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/void.x

void2:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/void2.x

string:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/string.x

string2:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/string2.x

stringlit:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/stringLit.x

number:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/number.x

number2:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/number2.x

numberlit:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/numberLit.x

int:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/int.x

greaterThan:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/greaterThan.x

greaterEqual:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/greaterEqual.x

If:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/if.x

Else:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/else.x

Do:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/do.x

While:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/while.x

For:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/for.x

fact:
	javac compiler/Compiler.java
	java compiler.Compiler sample_files/factorial.x
