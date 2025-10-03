package edu.curso;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TesteEvento extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Pane painel = new Pane();
        Scene scn = new Scene(painel, 400, 400);

        ManipuladorMouse man = new ManipuladorMouse();


        Button btnPressMe = new Button("Aperte aqui");
        btnPressMe.relocate( 130, 250);
        painel.getChildren().add( btnPressMe );

        Label lblTexto = new Label("Texto: ");
        painel.getChildren().add( lblTexto );
        lblTexto.relocate( 50, 10 );

        stage.addEventFilter(MouseEvent.ANY, man);

        TextField txtTexto = new TextField();
        painel.getChildren().add( txtTexto );
        txtTexto.relocate( 150  , 10);
        

        stage.setScene(scn);
        stage.setTitle("Teste de Java FX");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(TesteEvento.class, args);
    }
    
}
