package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;




public class ContatoViewC extends Application implements EventHandler<ActionEvent>{
    private TextField txtNome = new TextField();

    public void handle(ActionEvent e){ 
        // System.out.println("Botao Pressionado");
        System.out.println( txtNome.getText() );
    }

    @Override
    public void start(Stage stage) { 
        BorderPane panPrincipal = new BorderPane();
        Scene scn = new Scene( panPrincipal, 400, 350);

        GridPane panCampos = new GridPane();

        // Label lblNome = new Label("Nome: ");
        // panCampos.add(lblNome, 0, 0);

        TextField txtEmail = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtNascimento = new TextField();


        panCampos.add(new Label("Nome: "), 0, 0);
        panCampos.add( txtNome, 1, 0);
        panCampos.add(new Label("Email: "), 0, 1);
        panCampos.add( txtEmail, 1, 1);
        panCampos.add(new Label("Telefone: "), 0, 2);
        panCampos.add( txtTelefone, 1, 2);
        panCampos.add(new Label("Nascimento: "), 0, 3);
        panCampos.add( txtNascimento, 1, 3);

        Button btnSalvar = new Button("Salvar");
        btnSalvar.addEventFilter(ActionEvent.ANY, this);

        Button btnPesquisar = new Button("Pesquisar");

        HBox panBotoes = new HBox();
        panBotoes.getChildren().addAll(btnSalvar, btnPesquisar);

        panPrincipal.setCenter(panCampos);
        panPrincipal.setBottom(panBotoes);

        stage.setScene(scn);
        stage.setTitle("Agenda de Contato - C");
        stage.show();
    }    
}
