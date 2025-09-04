package edu.escola;

public class Aluno extends Pessoa {
    
    String ra;

    public Aluno() { 
        super("Anonimo");
    }

    // public Aluno(String nome, String ra) { 
    //     super(nome);
    //     this.ra = ra;
    // }

    public void estudar() { 
        System.out.println(this.nome + "está estudando...");
    }

}
