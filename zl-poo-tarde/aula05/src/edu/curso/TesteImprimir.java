package edu.curso;

import java.util.ArrayList;

public class TesteImprimir {
    
    public static void main(String[] args) {
        Imprimir<String> imp1 = new Imprimir<>();
        imp1.imprimir("Texto");

        Imprimir<Float> imp2 = new Imprimir<>();
        imp2.imprimir(10.8f);

        Imprimir<Float> imp3 = new Imprimir<>();
        imp3.imprimir(10.8f);

        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("teste");
    }

}
