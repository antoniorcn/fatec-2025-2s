package edu.curso;

public class Funcionario {

    String nome;

    public Funcionario( String nome ) { 
        this.nome = nome;
    }

    public void trabalhar() { 
        System.out.println(this.nome + " esta trabalhando...");
    }

    public void receberDinheiro( float valor ) { 
        System.out.println(this.nome + " recebeu R$" + valor);
    }
    
}
