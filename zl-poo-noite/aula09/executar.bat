@echo off
del build /S /Q
rmdir build /S /Q
mkdir build

javac -d ./build -s ./src ./src/edu/curso/*.java

java --class-path=.;./build edu.curso.TesteEvento