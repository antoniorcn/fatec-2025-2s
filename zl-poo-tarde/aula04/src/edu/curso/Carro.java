package edu.curso;

public class Carro {
    String marca;
    String modelo;
    int ano;
    int velocidade;

    private Motor motor = new Motor();
    Roda roda1 = new Roda("Goodyear", 18, 285);
    Roda roda2 = new Roda("Goodyear", 18, 285);
    Roda roda3 = new Roda("Goodyear", 18, 285);
    Roda roda4 = new Roda("Goodyear", 18, 285);

    public void acelerar() { 
        this.motor.acelerar();
        this.roda1.rodar();
        this.roda2.rodar();
        this.roda3.rodar();
        this.roda4.rodar();
        this.velocidade += 10;
    }

    public void frear() { 
        this.roda1.frear();
        this.roda2.frear();
        this.roda3.frear();
        this.roda4.frear();
        this.velocidade -= 10;
    }

}
