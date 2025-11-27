package edu.curso;

import java.util.List;

public interface ContatoDAO {
    void criar(Contato c);
    List<Contato> lerTodos();
    void apagar( long id );
    void atualizar( long id, Contato c);
}
