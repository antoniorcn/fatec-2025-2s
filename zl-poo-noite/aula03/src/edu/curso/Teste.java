package edu.curso;

public class Teste { 
    public static void main(String[] args) {
        Celular c1 = new Celular();
        c1.marca = "Samsung";
        c1.modelo = "A15";
        c1.isDesbloqueado = true;
        c1.numChips = 2;
        c1.modeloCamera = "48mp";

        // System.out.println(c1.marca);
        // System.out.println(c1.modelo);
        // System.out.println(c1.modeloCamera);
        // System.out.println(c1.isDesbloqueado);
        // System.out.println(c1.numChips);

        Celular c2 = new Celular();
        c2.marca = "Xiaomi";
        c2.modelo = "Poco X6";
        c2.isDesbloqueado = true;
        c2.numChips = 2;
        c2.modeloCamera = "32mp";

        // System.out.println(c2.marca);
        // System.out.println(c2.modelo);
        // System.out.println(c2.modeloCamera);
        // System.out.println(c2.isDesbloqueado);
        // System.out.println(c2.numChips);

        c1.exibirDados();
        c2.exibirDados();
    }
}