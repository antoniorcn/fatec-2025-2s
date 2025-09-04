package edu.curso;

public class Roda { 

    String marca;
    int aro;
    int espessura;

    public void rodar() { 
        System.out.println("Roda " + this.marca + " rodando...");
    }

    public void frear() { 
        System.out.println("Roda " + this.marca + "freando...");
    }

    public Roda( String marca, int aro, int espessura) { 
        this.marca = marca;
        this.aro = aro;
        this.espessura = espessura;
    }

}
