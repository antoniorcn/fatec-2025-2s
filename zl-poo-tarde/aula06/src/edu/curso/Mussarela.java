package edu.curso;

public class Mussarela extends Pizza {
    @Override
    public void preparar() { 
        System.out.println("Preparando com molho, queijo mussarela, tomate e orégano");
    }
    @Override
    public void assar() { 
        System.out.println("Assar por 3 minutos");
    }   
}
