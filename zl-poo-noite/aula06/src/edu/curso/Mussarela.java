package edu.curso;

public class Mussarela extends Pizza {
    
    @Override
    public void preparar() { 
        System.out.println("Preparando pizza de Mussarela");
        System.out.println("Colocando molho, queijo, tomate e orégano");
    }
}
