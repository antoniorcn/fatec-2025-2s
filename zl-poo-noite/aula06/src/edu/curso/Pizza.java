package edu.curso;
abstract public class Pizza {
    abstract public void preparar();

    public void assar() { 
        System.out.println("Assando a pizza em 3 minutos");
    }

    public void cortar() { 
        System.out.println("Cortando em 8 pedacos");
    }
}
