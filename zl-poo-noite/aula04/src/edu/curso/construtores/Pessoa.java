package edu.curso.construtores;

public class Pessoa extends Animal {

    String nome = "";

    public Pessoa( String nome ) {
        super();
        this.nome = nome; 
        System.out.println("Construindo instancia de Pessoa");
    }

    public Pessoa() {
        this("Anonimo");
    }
    
}
