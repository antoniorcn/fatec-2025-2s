public class TesteObserver {
    public static void main(String[] args) { 
        Fornecedor f = new Fornecedor();
        Consumidor c = new Consumidor();
        f.adicionarAssinante( c );
        f.setNome("Joao");
        f.setNome("Maria");
        f.setNome("Jose");


    }
}
