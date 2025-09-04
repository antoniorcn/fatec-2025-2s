package edu.curso;

public class Teste {
    public static void main(String[] args) {
        Carro c1 = new Carro();
        System.out.println("Antes da troca");
        c1.acelerar();

        Roda rodaMeiaBoca1 = new Roda("Direction", 13, 130);
        Roda rodaMeiaBoca2 = new Roda("Direction", 13, 130);
        Roda rodaMeiaBoca3 = new Roda("Direction", 13, 130);
        Roda rodaMeiaBoca4 = new Roda("Direction", 13, 130);


        c1.roda1 = rodaMeiaBoca1;
        c1.roda2 = rodaMeiaBoca2;
        c1.roda3 = rodaMeiaBoca3;
        c1.roda4 = rodaMeiaBoca4;
        System.out.println("Depois da troca");
        c1.acelerar();


        System.out.println("Depois de Tirar as rodas");
        c1.roda1 = null;
        c1.roda2 = null;
        c1.roda3 = null;
        c1.roda4 = null;
        c1.acelerar();



        
    }
}
