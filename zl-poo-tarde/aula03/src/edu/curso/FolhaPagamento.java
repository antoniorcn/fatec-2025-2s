package edu.curso;

public class FolhaPagamento {
    
    // public void pagarFuncionario( double salario ) { 
    //     System.out.println("Pagando: " + salario);
    // }

    // public void pagarFuncionario( double salario, 
    //                                     double vr ) { 
    //     System.out.println("Pagando: " + (salario + vr));
    // }

    // public void pagarFuncionario( double salario, 
    //                                 double vr,
    //                                 double bonus ) { 
    //     System.out.println("Pagando: " + 
    //                 (salario + vr + bonus));
    // }

    public void pagarFuncionario( String nome, 
                                double ... valores ) {
        double soma = 0;
        for (int i = 0; i < valores.length; i++) { 
            soma += valores[i];
        } 
        System.out.println("Pagando: " + soma + " para " + nome);
    }

    public static void main(String[] args) {
        FolhaPagamento fp = new FolhaPagamento();

        fp.pagarFuncionario("Joao", 2000);
        fp.pagarFuncionario("Maria", 2000, 400);
        fp.pagarFuncionario("Lucas", 2000, 400, 700);
    }
}
