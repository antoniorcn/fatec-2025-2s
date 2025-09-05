package edu.curso;

public class Pessoa { 

    String nome;

    public Pessoa() { 
        this.nome = "Anonimo";
    }

    public Pessoa(String nome) { 
        this.nome = nome;
        System.out.println("Instância de pessoa criada");
        System.out.println("Bem vindo " + this.nome);
    }

}