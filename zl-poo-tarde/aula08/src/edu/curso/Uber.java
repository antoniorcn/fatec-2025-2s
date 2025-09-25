package edu.curso;

public class Uber extends Motorista implements Parceiro {

    @Override
    public void receberValor(double valor) { }


    @Override
    public void dirigir() {
        System.out.println("Dirigindo com classe");
    }

    @Override
    public void ajudar() { }

    @Override
    public void prestarServico() { }


    @Override
    public void agirComResponsabilidade() {
        System.out.println("Dirigindo com responsabilidade...");
    }    
}
