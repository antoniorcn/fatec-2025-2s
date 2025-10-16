package edu.curso;

import java.time.LocalDate;

public class TesteContato {

    public static void main(String[] args) {
        
        Contato c1 = new Contato();
        c1.setId( 1L );
        c1.setNome("João Silva");
        c1.setTelefone("(11) 1111-1111");
        c1.setEmail("joao@teste.com");
        c1.setNascimento( LocalDate.of(2002, 10, 5) );


        Contato c2 = new Contato();
        c2.setId( 1L );
        c2.setNome("João Silva");
        c2.setTelefone("(11) 1111-1111");
        c2.setEmail("joao@teste.com");
        c2.setNascimento( LocalDate.of(2002, 10, 5) );


        System.out.println("Contato 1 Hash: " +  c1.hashCode() );
        System.out.println("Contato 1: " +  c1 );
        System.out.println("Contato 2 Hash: " +  c2.hashCode() );
        System.out.println("Contato 2: " +  c2 );

        if (c1.equals(c2)) {
            System.out.println("c1 é Igual a c2");
        } else { 
            System.out.println("c1 é Diferente de c2");
        }


    }
    
}
