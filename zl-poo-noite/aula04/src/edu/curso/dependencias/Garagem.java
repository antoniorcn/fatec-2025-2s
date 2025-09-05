package edu.curso.dependencias;

public class Garagem {
    public static void main(String[] args) {
        Porche p1 = new Porche();
        
        Roda r1 = new Roda();
        r1.aro = 14;
        r1.espessura = 165;
        r1.marca = "Precision";

        System.out.println("Motor da porche ==> Não da para ver");
        System.out.println("Roda da porche ==> " + p1.roda.marca);

        p1.roda = r1;

        System.out.println("Motor da porche ==> Não da para ver");
        System.out.println("Roda da porche ==> " + p1.roda.marca);



    }
}
