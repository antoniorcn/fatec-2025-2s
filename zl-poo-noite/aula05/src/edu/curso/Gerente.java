package edu.curso;

public class Gerente extends Funcionario {

    public Gerente(String nome){ 
        super( nome );
    }

    public void receberPagamento( float valor ) { 
        System.out.println(this.nome + " esta recebendo R$ " + valor + " feliz da vida");
    }
}
