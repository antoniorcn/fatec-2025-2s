package edu.curso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {

    private ObservableList<Contato> lista = FXCollections.observableArrayList();

    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>(
        LocalDate.now()
    );

    public Contato toEntity() { 

        Contato contato = new Contato();
        contato.setNome( nome.get() );
        contato.setEmail( email.get() );
        contato.setTelefone( telefone.get() );
        contato.setNascimento( nascimento.get() );
        return contato;
    }

    public void fromEntity( Contato contato ) { 
        if (contato != null) {
            nome.set( contato.getNome() );
            email.set( contato.getEmail() );
            telefone.set( contato.getTelefone() );
            nascimento.set( contato.getNascimento() );
        }
    }

    public void salvar() { 
        lista.add( toEntity() );
    }

    public void pesquisar() { 
        for (Contato contato : lista) { 
            if (contato.getNome().contains( nome.get() )) { 
                fromEntity( contato );
                break;
            }
        }
    }

    public StringProperty nomeProperty() { 
        return nome;
    }

    public StringProperty emailProperty() { 
        return email;
    }

    public StringProperty telefoneProperty() { 
        return telefone;
    }

    public ObjectProperty<LocalDate> nascimentoProperty() { 
        return nascimento;
    }

    public ObservableList<Contato> getLista() { 
        return lista;
    }

    
}
