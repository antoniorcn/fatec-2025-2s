package edu.curso;

public class Celular {
    public String marca;
    public String modelo;
    public String modeloCamera;
    public int numChips;
    public boolean isDesbloqueado;

    public void fazerLigacao() { 
        System.out.println("Ligando ...");
    }
    
    public void desligar() { 
        System.out.println("Desligando ...");
    }

    public void tocarMusica() { 
        System.out.println("Tocando Musica ...");
    }

    public void exibirDados() { 
        // String marca = "Oba Phone";
        System.out.println("Dados: " + this.marca);
        System.out.println("Dados: " + this.modelo);
        System.out.println("Dados: " + this.modeloCamera);
        System.out.println("Dados: " + this.isDesbloqueado);
        System.out.println("Dados: " + this.numChips);
    }
}
