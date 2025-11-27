package edu.curso;

import java.util.List;

public interface ContatoDAO {
    void criar( Contato contato );
    Contato procurarPorId( long id );
    List<Contato> lerTodos();
    void atualizar( long id, Contato contato);
    void deletar( long id );
}
