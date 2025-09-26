package edu.curso;

public class MotoristaApp extends Motorista implements Uber, Colaborador {

    @Override
    public void dirigirComClasse() {
        System.out.println("Motorista dirigindo com classe para ganhar um extra...");
    }

    @Override
    public void agirComResponsabilidade() {
        System.out.println("Motorista dirigindo com responsabilidade...");
    }

    @Override
    public void receberPagamento(double valor) {
        System.out.printf("Eba recebi R$ %f vou trocar os pneus do carro %n", valor);
    }
    
}
