package edu.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pizzaria {

    private List<Pizza> lista = new ArrayList<>();

    public Pizzaria() { 
        lista.add( new Mussarela() );
        lista.add( new Calabresa() );
    }

    public void rodizio() { 

        int pizzaIndice = 0;

        Scanner input = new Scanner(System.in);
        String texto = null;
        Random rnd = new Random();
        while( !"SAIR".equals(texto) ) {
            System.out.println("Tecle <ENTER> para receber uma Pizza");
            System.out.println("Tecle SAIR e <ENTER> para encerrar");
            texto = input.nextLine();

            
            pizzaIndice = rnd.nextInt( 2 );

            Pizza p = lista.get( pizzaIndice );
            p.preparar();
            p.assar();
            p.cortar();
        }
        input.close();

    }

    public static void main(String[] args) {
        Pizzaria pizzaria = new Pizzaria();
        pizzaria.rodizio();
    }
    
}
