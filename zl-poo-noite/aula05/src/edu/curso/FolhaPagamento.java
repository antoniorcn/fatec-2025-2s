package edu.curso;

public class FolhaPagamento {
    
    public void fazPagamento(Funcionario f, 
                            float valorBase) {
        f.receberPagamento(valorBase * 1.2f);
    }
}
