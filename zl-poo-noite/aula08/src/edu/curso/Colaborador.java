package edu.curso;

public interface Colaborador extends Responsavel, Trabalhador {
    
    void receberPagamento(double valor);
}
