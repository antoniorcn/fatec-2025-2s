package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane painel = new Pane();
        Scene scn = new Scene(painel, 600, 400);

        Label lblTitulo = new Label("Agenda de Contato");
        Label lblNome = new Label("Nome:");
        Label lblTelefone = new Label("Telefone:");
        Label lblEmail = new Label("Email:");
        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtEmail = new TextField();
        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        painel.getChildren().addAll( lblTitulo, lblNome, lblTelefone, lblEmail );
        painel.getChildren().addAll( txtNome, txtTelefone, txtEmail );
        painel.getChildren().addAll( btnSalvar, btnPesquisar );

        lblTitulo.relocate( 200, 30 );
        lblNome.relocate(50, 100);
        lblTelefone.relocate(50, 150);
        lblEmail.relocate(50, 200);
        txtNome.relocate(150, 100);
        txtTelefone.relocate(150, 150);
        txtEmail.relocate(150, 200);
        btnSalvar.relocate(100, 300);
        btnPesquisar.relocate(200, 300);
        stage.setScene(scn);
        stage.setTitle("TesteFX");
        stage.show();
    } 

    public static void main(String[] args) {
        Application.launch(TesteFX.class, args);
    }

}