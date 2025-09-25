package edu.curso;

public class Programador implements Colaborador, Freelance {

    @Override
    public void prestarServico() {
        System.out.println("Programando em método Go-Horse");
    }

    @Override
    public void receberValor(double valor) {
        System.out.println("Programador");
        System.out.printf("Eba recebi %f, vou comprar uma placa de vídeo%n", valor);
    }

    @Override
    public void trabalharPorContaPropria() {
        System.out.println("Trabalhando de pijama e pantufa no sofa da sala");        
    }
    
}
