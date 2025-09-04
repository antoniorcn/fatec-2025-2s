package edu.escola;

public class Professor extends Pessoa { 
    String horario;

    public Professor(String nome, String horario) { 
        super(nome);
        this.horario = horario;
    }

    public void ensinar() { 
        System.out.println(this.nome + "está dando aula...");
    }

}
