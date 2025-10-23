package edu.curso;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TesteJavaFXProperties {

    public static void main(String[] args) {

        StringProperty nome = new SimpleStringProperty("Silva");

        // ChangeListener<String> change = new ChangeListener<>() {
        //     @Override
        //     public void changed(ObservableValue<? extends String> observable, 
        //                     String oldValue, String newValue) {
        //         System.out.println("Nome foi trocado de " + oldValue + " para " + newValue);
        //     }           
        // };
        // nome.addListener( change );

        nome.addListener((observable, oldValue, newValue) -> {
            System.out.println("Nome foi trocado de " + oldValue + " para " + newValue);
        });


        DoubleProperty valor = new SimpleDoubleProperty( 100.0 );
        valor.addListener((obs, velho, novo) -> {
            System.out.println("Valor foi trocado de " + velho + " para " + novo);
        });

        System.out.println( nome.get() );
        nome.set("Santos");
        System.out.println( nome.get() );

        nome.set("Almeida" );
        nome.set("Oliveira");


        for (int i = 0; i < 10; i++ ) { 
            valor.set( 100.0 + i );
        }
       
    }
    
}
