package edu.curso;

import java.time.LocalDate;

public class TesteContato {
    

    public static void main(String[] args) {
        
        Contato c1 = new Contato();
        c1.setId(1);
        c1.setNome("Joao Silva");
        c1.setEmail("joao@teste.com");
        c1.setTelefone("(11) 1111-1111");
        c1.setNascimento(
            LocalDate.of(2002, 7, 8)
        );

        // Contato c2 = new Contato();
        // c2.setId(1);
        // c2.setNome("Joao Silva");
        // c2.setEmail("joao@teste.com");
        // c2.setTelefone("(11) 1111-1111");
        // c2.setNascimento(
        //     LocalDate.of(2002, 7, 8)
        // );

        Contato c2 = new Contato();
        c2.setId(1);
        c2.setNome("Maria Silva");
        c2.setEmail("maria@teste.com");
        c2.setTelefone("(11) 2222-2222");
        c2.setNascimento(
            LocalDate.of(2003, 8, 10)
        );
        
        System.out.println("HashCode (c1) ==> " + c1.hashCode());
        System.out.println("Contato (c1) ==> " + c1);
        System.out.println("HashCode (c2) ==> " + c2.hashCode());
        System.out.println("Contato (c2) ==> " + c2);

        if (c1.equals(c2)) { 
            System.out.println("c1 é igual a c2");
        } else { 
            System.out.println("c1 é diferente de c2");
        }
    }
}
