@echo off
echo Limpando pasta build
rmdir .\build /s /q
echo Recriando pasta build
mkdir build

echo Compilando arquivos
javac -d ./build ./src/edu/curso/*.java

echo Executando
java --class-path .;.\build edu.curso.AgendaContatoForm