package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteLayouts extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane panPrincipal = new BorderPane();
        Scene scn = new Scene(panPrincipal, 600, 400);

        Label lblTitulo = new Label("Agenda de Contato");
        panPrincipal.setTop( lblTitulo );

        FlowPane panBotoes = new FlowPane();
        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");
        panBotoes.getChildren().addAll( btnSalvar, btnPesquisar );
        panPrincipal.setBottom( panBotoes );

        GridPane panCampos = new GridPane();
        Label lblNome = new Label("Nome:");
        TextField txtNome = new TextField();
        Label lblTelefone = new Label("Telefone:");
        TextField txtTelefone = new TextField();
        Label lblEmail = new Label("Email:");
        TextField txtEmail = new TextField();
        panCampos.add( lblNome, 0, 0 );
        panCampos.add( txtNome, 1, 0 );
        panCampos.add( lblTelefone, 0, 1 );
        panCampos.add( txtTelefone, 1, 1 );
        panCampos.add( lblEmail, 0, 2 );
        panCampos.add( txtEmail, 1, 2 );
        panPrincipal.setCenter( panCampos );

        stage.setScene(scn);
        stage.setTitle("Teste Layouts");
        stage.show();
    } 

    public static void main(String[] args) {
        Application.launch(TesteLayouts.class, args);
    }

}