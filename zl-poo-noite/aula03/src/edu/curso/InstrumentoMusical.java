package edu.curso;

public class InstrumentoMusical {

    public String nome;
    public String familia;
    public String material;
    public double preco;
    public String luthier;

    public void afinar() { 
        System.out.println("Afinando instrumento ...");
    }

    public void tocar() { 
        System.out.println("Tocando o instrumento ...");
    }

    public void exibir() { 
        System.out.println(nome);
        System.out.println(familia);
        System.out.println(material);
        System.out.println(preco);
        System.out.println(luthier);
    }
}
