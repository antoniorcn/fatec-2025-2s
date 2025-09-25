package edu.curso;

public class FolhaPagamento {

    private double orcamento;

    public FolhaPagamento(double orcamento) { 
        this.orcamento = orcamento;
    }

    public void fazerPagamento(Colaborador colaborador, int horas, double valorHora) {
        colaborador.receberValor(valorHora * horas);
    }
    
}
