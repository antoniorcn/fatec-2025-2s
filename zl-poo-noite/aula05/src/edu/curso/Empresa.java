package edu.curso;

public class Empresa {
    
    public static void main(String[] args) {
        FolhaPagamento fp1 = new FolhaPagamento();
        FolhaPagamentoV2 fp2 = new FolhaPagamentoV2();
        
        Funcionario douglas = new Funcionario("Douglas");
        Funcionario jaime = new Funcionario("Jaime");
        Funcionario mariza = new Funcionario("Mariza");
        Gerente marcia = new Gerente("Marcia");

        fp2.fazPagamento(douglas, 2500.0f);
        fp2.fazPagamento(jaime, 3000.0f);
        fp2.fazPagamento(mariza, 4000.0f);
        fp1.fazPagamento(marcia, 5000.0f);

    }
}
