package edu.escola;

public class Escola {

    Professor professor;
    Aluno aluno1;
    Aluno aluno2;

    public Escola() { 
        professor = new Professor("Colevatti", "13:00 as 16:30h");
        aluno1 = new Aluno("Joao Silva", "11111");
        aluno2 = new Aluno("Maria Silva", "22222");
    }   

    public void abrir() { 
        System.out.println("Escola aberta");
    }

    public void fechar() { 
        System.out.println("Escola fechada");
    }

    public void gerir() { 
        aluno1.estudar();
        aluno1.falar();
        aluno2.falar();
        aluno2.estudar();

        professor.falar();
        professor.ensinar();
    }
}
