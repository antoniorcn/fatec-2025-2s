package edu.curso;

public class Estagiario extends Estudante implements Colaborador{

    @Override
    public void prestarServico() {
        System.out.println("Aprendendo a executar as atividades");
    }

    @Override
    public void receberValor(double valor) {
        System.out.println("Estagiario");
        System.out.printf("Caraca meu recebi %f, vou gastar o salario em um PS4%n", valor);
    }
    
}
