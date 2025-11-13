package edu.curso;

import java.time.LocalDate;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {

    private long indiceContato = 1;
    private ObservableList<Contato> lista = FXCollections.observableArrayList();
    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty<>(
        LocalDate.now()
    );

    public Contato procurarContatoPorId( long id ) { 
        for (Contato c : lista ) { 
            if (c.getId() == id) { 
                return c;
            }
        }
        return null;
    }

    public void novoContato() { 
        id.set(0);
    }

    public void gravar() {
        Contato contato = paraEntidade();

        if (contato.getId() == 0) {
            contato.setId( indiceContato++ );
            lista.add( contato );
        } else { 
            Contato contatoAntigo = procurarContatoPorId( contato.getId() );
            contatoAntigo.setNome( contato.getNome() );
            contatoAntigo.setTelefone( contato.getTelefone() );
            contatoAntigo.setEmail( contato.getEmail() );
            contatoAntigo.setNascimento( contato.getNascimento() );
        }
    }

    public void editar( int indice ) { 
        Contato c = lista.get( indice );
        if (c != null) { 
            paraTela( c );
        }
    }

    public void apagar(int indice) { 
        lista.remove(indice);
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
        contato.setId( id.get() );
        contato.setNome( nome.get() );
        contato.setTelefone( telefone.get() );
        contato.setEmail( email.get() );
        contato.setNascimento( nascimento.get() );
        return contato;
    }

    public void paraTela( Contato contato ) { 
        if (contato != null) {
            id.set( contato.getId() );
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

    public ObservableList<Contato> getLista() {
        return lista;
    }

    public LongProperty idProperty() { 
        return id;
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
