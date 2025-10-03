package edu.curso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Agenda extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Pane painel = new Pane();
        Scene scn = new Scene(painel, 600, 300);


        Label lblNome = new Label("Nome: ");
        painel.getChildren().add( lblNome );
        lblNome.relocate( 25, 20 );
        TextField txtNome = new TextField();
        painel.getChildren().add( txtNome );
        txtNome.relocate( 150  , 20);
        txtNome.setPrefSize(400, 30);

        Label lblTelefone = new Label("Telefone: ");
        painel.getChildren().add( lblTelefone );
        lblTelefone.relocate( 25, 70 );
        TextField txtTelefone = new TextField();
        painel.getChildren().add( txtTelefone );
        txtTelefone.relocate( 150  , 70);
        txtTelefone.setPrefSize(400, 30);


        Label lblEmail = new Label("Email: ");
        painel.getChildren().add( lblEmail );
        lblEmail.relocate( 25, 120 );
        TextField txtEmail = new TextField();
        painel.getChildren().add( txtEmail );
        txtEmail.relocate( 150  , 120);         
        txtEmail.setPrefSize(400, 30);

        Button btnSalvar = new Button("Salvar");
        btnSalvar.relocate( 25, 170);
        painel.getChildren().add( btnSalvar );
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.relocate( 100, 170);
        painel.getChildren().add( btnPesquisar );        
        

        stage.setScene(scn);
        stage.setTitle("Agenda de Contato");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Agenda.class, args);
    }
    
}
