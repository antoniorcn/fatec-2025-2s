package edu.curso;
public class Funcionario {
    String nome;

    public Funcionario(String nome) { 
        this.nome = nome;
    }

    public void receberPagamento(float valor) { 
        System.out.println(this.nome + " esta recebendo R$ " + valor);
    }
}
