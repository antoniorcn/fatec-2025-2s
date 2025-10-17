@echo off
echo Removendo diretorio build
rmdir .\build /s /q
echo Recriando diretorio build
mkdir .\build
echo Compilar arquivos .java
javac -d .\build .\src\edu\curso\*.java
echo Executar o programa principal
java --class-path .;.\build edu.curso.ContatoPrincipal
