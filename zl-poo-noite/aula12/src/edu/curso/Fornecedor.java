import java.util.ArrayList;
import java.util.List;

public class Fornecedor implements 
    Publicador {
    private List<Assinante> assinantes = new ArrayList<>();
    private String nome = "";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        notificarMudanca(nome);
    }

    public void adicionarAssinante( Assinante a ) { 
        assinantes.add( a );
    }

    public void removerAssinante( Assinante a ) { 
        assinantes.remove( a );
    }

    public void notificarMudanca( String novoTexto ) { 
        for (Assinante a : assinantes ) {
            a.receber(novoTexto);
        }
    }
    
}
