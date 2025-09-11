package edu.curso;

public class Gerente extends Funcionario {

    public Gerente(String nome) { 
        super(nome);
    }

    public void liderar() { 
        System.out.println(this.nome + " estã liderando a equipe");
    }

    public void receberDinheiro( float valor ) { 
        System.out.println(this.nome + " esta recebendo R$ " + valor + "muito feliz");
    }
    
}
