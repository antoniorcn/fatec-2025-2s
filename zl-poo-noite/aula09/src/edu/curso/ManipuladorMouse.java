package edu.curso;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ManipuladorMouse implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent evento) { 
        System.out.println("Tipo: " + evento.getEventType().getName());
        System.out.println("Botão: " + evento.getButton().name());
        System.out.println("X: " + evento.getX());
        System.out.println("Y: " + evento.getY());
    }
    
}
