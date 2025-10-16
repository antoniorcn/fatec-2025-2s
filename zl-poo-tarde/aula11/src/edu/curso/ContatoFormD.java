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


public class ContatoFormD extends Application { 
    private TextField txtNome = new TextField();

    @Override
    public void start(Stage stage) { 
        BorderPane panPrincipal = new BorderPane();
        Scene scn = new Scene( panPrincipal, 400, 200);

        GridPane panCampos = new GridPane();

        // Label lblNome = new Label("Nome Completo");
        // panCampos.add( lblNome, 0, 0 );

        TextField txtTelefone = new TextField();
        TextField txtEmail = new TextField();

        panCampos.add(new Label("Nome Completo"), 0, 0 );
        panCampos.add(txtNome, 1, 0);
        panCampos.add(new Label("Telefone"), 0, 1 );
        panCampos.add(txtTelefone, 1, 1);
        panCampos.add(new Label("Email"), 0, 2 );
        panCampos.add(txtEmail, 1, 2);

        panPrincipal.setCenter( panCampos );

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        EventHandler<ActionEvent> obj1 = new EventHandler<>() {
                @Override
                public void handle(ActionEvent event) { 
                    System.out.println("Botao foi pressionado");
                    System.out.println("Nome ==> " + txtNome.getText() );
                    System.out.println("Telefone ==> " + txtTelefone.getText() );
                    System.out.println("Email ==> " + txtEmail.getText() );
                }
        };
        btnSalvar.addEventFilter(ActionEvent.ANY, obj1);

        HBox panBotoes = new HBox();
        panBotoes.getChildren().addAll( btnSalvar, btnPesquisar);
        panPrincipal.setBottom(panBotoes);

        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos - D");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ContatoFormD.class, args);
    }
}