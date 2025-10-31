@echo off
REM SET JAVA_HOME=C:\antonio\jdk-21.0.8-full
REM SET PATH=%JAVA_HOME%\bin;%PATH%
echo Removendo diretorio build
rmdir .\build /s /q
echo Recriando diretorio build
mkdir .\build
echo Compilar arquivos .java
javac -d .\build .\src\edu\curso\*.java
echo Executar o programa principal
java --class-path .;.\build edu.curso.ContatoView
