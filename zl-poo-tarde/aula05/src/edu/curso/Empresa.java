package edu.curso;

public class Empresa {
    public static void main(String[] args) {
        // FolhaPagamento fp1 = new FolhaPagamento();
        FolhaPagamentoV2 fp2 = new FolhaPagamentoV2();

        Funcionario maria = new Funcionario("Maria");
        Funcionario joao = new Funcionario("Joao");
        Gerente jose = new Gerente("Jose");

        fp2.fazerPagamento(maria, 3000);
        fp2.fazerPagamento(joao, 3000);

        fp2.fazerPagamento(jose, 5000);

    }
}
