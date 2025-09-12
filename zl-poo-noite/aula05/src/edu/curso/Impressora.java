package edu.curso;

public class Impressora<T> {

    public void imprimir( T[] lista ) { 
        for (T valor : lista) {
            System.out.println( valor );
        }
    }

    public static void main(String[] args) {
    //    Impressora<Integer> imp1 = new Impressora<>();
    //    imp1.imprimir( 20 );

    //    Impressora<Float> imp2 = new Impressora<>();
    //    imp2.imprimir( 20.0f );

    //    Impressora<String> imp3 = new Impressora<>();
    //    imp3.imprimir( "Texto" );

    }
    
}
