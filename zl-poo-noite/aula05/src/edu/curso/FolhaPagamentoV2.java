package edu.curso;

public class FolhaPagamentoV2 extends FolhaPagamento {

    @Override
    public void fazPagamento(Funcionario f, float valorBase) { 
        f.receberPagamento(valorBase * 1.4f);
    }
    
}
