package edu.curso;

public class Teste {

    public static void main(String[] args) {
        Programador p1 = new Programador();
        Estagiario e1 = new Estagiario();

        FolhaPagamento fp1 = new FolhaPagamento(100000);
        fp1.fazerPagamento( p1, 80, 40.0);
        fp1.fazerPagamento(e1, 240, 12.0);
    }
}
