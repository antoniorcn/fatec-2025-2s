package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteEvento extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane painel = new BorderPane();
        Scene scn = new Scene(painel, 600, 400);

        Label lblTitulo = new Label("Teste de Evento");
        Button btnPressMe = new Button("Aperte aqui");

        ManipuladorMouse man = new ManipuladorMouse();

        stage.addEventFilter(MouseEvent.ANY, man);

        painel.setTop( lblTitulo );
        painel.setBottom( btnPressMe );

        stage.setScene(scn);
        stage.setTitle("TesteFX");
        stage.show();
    } 

    public static void main(String[] args) {
        Application.launch(TesteEvento.class, args);
    }

}