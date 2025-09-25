package edu.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteJavaFX extends Application {

    @Override
    public void start(Stage stage) {

        Pane painelPrincipal = new Pane();
        Scene scn = new Scene( painelPrincipal, 400, 300 );
        stage.setScene( scn );

        Button button1 = new Button("Aperte aqui");
        Label label1 = new Label("Meu primeiro label");
        painelPrincipal.getChildren().add( label1);
        painelPrincipal.getChildren().add( button1);

        stage.setTitle("Minha primeira janela JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
