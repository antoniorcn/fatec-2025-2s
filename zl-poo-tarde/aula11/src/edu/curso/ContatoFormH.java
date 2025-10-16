package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class ContatoFormH extends Application { 
    private TextField txtNome = new TextField("Joao Silva");

    @Override
    public void start(Stage stage) { 
        BorderPane panPrincipal = new BorderPane();
        Scene scn = new Scene( panPrincipal, 400, 200);

        GridPane panCampos = new GridPane();

        // Label lblNome = new Label("Nome Completo");
        // panCampos.add( lblNome, 0, 0 );

        TextField txtTelefone = new TextField("(11) 1111-1111");
        TextField txtEmail = new TextField("joao@teste.com");

        panCampos.add(new Label("Nome Completo"), 0, 0 );
        panCampos.add(txtNome, 1, 0);
        panCampos.add(new Label("Telefone"), 0, 1 );
        panCampos.add(txtTelefone, 1, 1);
        panCampos.add(new Label("Email"), 0, 2 );
        panCampos.add(txtEmail, 1, 2);

        panPrincipal.setCenter( panCampos );

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        btnSalvar.setOnAction( e -> System.out.println(txtNome.getText()) );
        
        HBox panBotoes = new HBox();
        panBotoes.getChildren().addAll( btnSalvar, btnPesquisar);
        panPrincipal.setBottom(panBotoes);

        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos - H");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ContatoFormE.class, args);
    }
}