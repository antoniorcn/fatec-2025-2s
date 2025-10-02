package edu.curso;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ManipuladorMouse implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        System.out.println( "Botao apertado ==> " + event.getButton().name() );
        System.out.println( "Pos do mouse X ==> " + event.getScreenX() );
        System.out.println( "Pos do mouse Y ==> " + event.getScreenY() );
    }
    
}
