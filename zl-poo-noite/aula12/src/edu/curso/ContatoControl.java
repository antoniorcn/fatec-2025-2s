package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContatoControl {

    private long indiceContato = 0;
    private List<Contato> lista = new ArrayList<>();

    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>(
        LocalDate.now()
    );

    public void gravar() {
        Contato contato = paraEntidade();
        contato.setId( indiceContato++ );
        lista.add( contato );
    }

    public void pesquisar() { 
        for(Contato contato : lista) {
            if (contato.getNome().contains( nome.get() )) {
                paraTela(contato);
                break;
            }
        }
    }

    public Contato paraEntidade() { 
        Contato contato = new Contato();
        contato.setNome( nome.get() );
        contato.setTelefone( telefone.get() );
        contato.setEmail( email.get() );
        contato.setNascimento( nascimento.get() );
        return contato;
    }

    public void paraTela( Contato contato ) { 
        // lblId.setText( String.valueOf(contato.getId()) );
        if (contato != null) {
            nome.set( contato.getNome() );
            telefone.set( contato.getTelefone() );
            email.set( contato.getEmail() );
            nascimento.set(
                contato.getNascimento()
            );
        }
    }

    public void limparTela() {
        nome.set("");
        telefone.set("");
        email.set("");
        nascimento.set(LocalDate.now());
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
    
}
