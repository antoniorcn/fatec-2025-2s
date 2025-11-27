@echo off
REM SET JAVA_HOME=c:\antonio\jdk-21.0.9-full 
REM SET PATH=%JAVA_HOME%\bin;%PATH%
echo Limpando pasta build
rmdir .\build /s /q
echo Recriando pasta build
mkdir build

echo Compilando arquivos
javac -d ./build ./src/edu/curso/*.java

echo Executando
java --class-path .;.\lib\mariadb-java-client-3.5.6.jar;.\build edu.curso.PrincipalView