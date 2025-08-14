package edu.fatec;
public class TesteAluno { 
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		System.out.println("Nome a1 =>" + a1.nome);
		Aluno a2 = new Aluno();
		System.out.println("Nome a2 =>" + a2.nome);
		int j = 10;
		a2.nome = "Joao Silva";
		a1.nome = "Maria Silva";
		a2.ra = "2222";
		System.out.println("Nome a1 =>" + a1.nome);
		System.out.println("Nome a2 =>" + a2.nome);		
	}
}