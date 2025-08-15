plugins {
    kotlin("jvm") version "2.0.21"
    application // Colocar a linha application para adicionar o plugin de application
}

group = "edu.curso"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

// Adicionar este bloco para definir o codigo que contém a função main()
application {
    mainClass.set("edu.curso.MainKt") // Substitua com o caminho completo da sua main
}