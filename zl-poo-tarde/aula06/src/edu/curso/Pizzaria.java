package edu.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pizzaria {

    private List<Pizza> pizzas = new ArrayList<>();

    public Pizzaria () { 
        pizzas.add( new Mussarela() );
        pizzas.add( new Calabresa() );
    }

    public void servir() { 
        Random rnd = new Random();
        int indice = rnd.nextInt(pizzas.size());
        Pizza p = pizzas.get( indice );
        p.preparar();
        p.assar();
        p.cortar();       
    }


    public static void main(String[] args) {
        Pizzaria pi = new Pizzaria();
        
        Scanner scan = new Scanner(System.in);
        String texto = null;
        while( !"SAIR".equals(texto) ) { 
            System.out.println("Tecle <ENTER> para servir uma pizza");
            System.out.println("Digite SAIR e <ENTER> para encerrar");
            texto = scan.nextLine();
            pi.servir();
        }
        scan.close();
    }
    
}
