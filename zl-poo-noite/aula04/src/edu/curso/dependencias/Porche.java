package edu.curso.dependencias;

public class Porche {
    private Motor motor = new Motor();
    Farol farol = new Farol();
    Roda roda = new Roda();

    public void melhorarConsumo() { 
        motor.consumo += 0.5f;
        motor.potencia -= 3;
    }
}
