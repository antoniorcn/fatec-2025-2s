public interface Publicador {
    void adicionarAssinante( Assinante a );
    void removerAssinante( Assinante a );
    void notificarMudanca( String novoTexto );
}
