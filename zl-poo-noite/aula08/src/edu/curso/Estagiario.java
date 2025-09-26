package edu.curso;

public class Estagiario implements Colaborador, AlunoFatec, Uber {

    @Override
    public void dirigirComClasse() {
        System.out.println("Estagiario dirigindo com classe para ganhar um extra...");
    }

    @Override
    public void estudarMuito() {
        System.out.println("Estagiario estudando muito POO para a prova do dia 09/10...");
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiario trabalhando...");
    }

    @Override
    public void agirComResponsabilidade() {
        System.out.println("Estagiario agindo com responsabilidade...");
    }

    @Override
    public void receberPagamento(double valor) {
        System.out.printf("Estagiario recebeu R$ %f e vai comprar um PS4 parcelado %n", valor);
    }

}
