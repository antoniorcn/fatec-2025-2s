public class Consumidor implements Assinante {

    public void receber( String novoTexto ) { 
        System.out.println("Recebido o novo texto : " + novoTexto);
    }
    
}
