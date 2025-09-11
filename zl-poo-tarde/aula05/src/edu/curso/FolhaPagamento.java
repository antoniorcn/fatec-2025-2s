package edu.curso;

public class FolhaPagamento {

    public void fazerPagamento(Funcionario f, float base) { 
        f.receberDinheiro(base * 1.2f);
    }
    
}
