package edu.curso;

public class Empresa {

    public static void main(String[] args) {
        FolhaPagamento folha = new FolhaPagamento();
        Estagiario estagiario = new Estagiario();
        MotoristaApp motorista = new MotoristaApp();

        folha.pagar(estagiario);
        folha.pagar(motorista);
    }
    
}
