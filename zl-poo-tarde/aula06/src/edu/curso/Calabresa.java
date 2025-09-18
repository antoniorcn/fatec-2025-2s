package edu.curso;

public class Calabresa extends Pizza {

    @Override
    public void preparar() {
        System.out.println("Preparando a pizza com molho, calabresa, cebola e azeitona");
    }

    @Override
    public void assar() {
        System.out.println("Assando por 5 minutos");
    }
   
}
