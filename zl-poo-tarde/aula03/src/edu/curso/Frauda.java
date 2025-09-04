public class Frauda {

    public String marca;
    public String nome;
    public double preco;
    public String tipo;
    public String tamanho;

    public void absorver() { 
        System.out.println("Absorvendo .... ");
    }
    
    public int qualidadeAbsorcao() { 
        System.out.println("Testando qualidade da absorcao .... ");
        return 9;
    }

    public int horasUsoRestante() { 
        System.out.println("Calculando horas de uso restante.... ");
        return 4;
    }
}
