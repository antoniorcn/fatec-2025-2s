package edu.curso;

abstract public class Pizza { 

    abstract public void preparar();

    abstract public void assar();

    public void cortar() {
        System.out.println("Cortando em 8 pedaços");
    }
}