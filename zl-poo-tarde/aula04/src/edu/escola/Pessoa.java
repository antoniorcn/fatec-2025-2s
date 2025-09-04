package edu.escola;

public class Pessoa {
    String nome;

    public Pessoa(String nome) {
        super();
        this.nome = nome;
        System.out.println("Construtor Pessoa(String nome) invocado");
    }

    public Pessoa() { 
        this("Anonimo");
        System.out.println("Construtor Pessoa() invocado");
        // super();
        // this.nome = "Anonimo";
    }

    public void falar() { 
        System.out.println(this.nome + " esta falando");
    }
}
