package edu.curso;

abstract public class Ideia { 

    public abstract void como();


    public void descrever() { 
        System.out.println(" A ideia é assim .... ");
    }

    public static void main(String[] args) {
        Ideia i = new Pensamento();
    }
}

