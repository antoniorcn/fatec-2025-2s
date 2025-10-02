@echo off
deltree build /S /Q
rmdir build /S /Q
mkdir build
C:\usr\jdk-25-full\bin\javac ./src/edu/curso/*.java -s src -d build
C:\usr\jdk-25-full\bin\java --class-path ./build edu.curso.TesteEvento