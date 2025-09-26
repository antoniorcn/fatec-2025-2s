package edu.grafico;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteFX extends Application {
    @Override
    public void start( Stage stage ) { 

        Pane painel = new Pane();
        Scene scn = new Scene( painel, 600, 400 );

        Label lbl1 = new Label("Meu Label");
        painel.getChildren().add( lbl1);

        Button btn = new Button("Aperte Aqui");
        painel.getChildren().add( btn );
        btn.relocate(350, 180 );

        stage.setScene( scn );

        stage.setTitle("Meu primeiro programa JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch( args );
    }
    
}
