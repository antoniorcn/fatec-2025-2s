package edu.curso;

public class FolhaPagamentoV2 extends FolhaPagamento {

    @Override
    public void fazerPagamento( Funcionario f, float b) { 
        f.receberDinheiro(b * 1.3f);
    }
    
}
