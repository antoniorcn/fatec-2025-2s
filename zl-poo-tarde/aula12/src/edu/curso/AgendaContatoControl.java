package edu.curso;

import java.util.ArrayList;
import java.util.List;

public class AgendaContatoControl {

    private List<Contato> lista = new ArrayList<>();
    private long idIndice = 1L;


    public void adicionar( Contato contato ) { 
        contato.setId( idIndice++ );
        lista.add( contato );
    }

    public Contato pesquisarPorNome( String nome ) { 
        for (Contato contato : lista) { 
            if (contato.getNome().contains( nome )) { 
                return contato;
            }
        }
        return null;
    }
}
