package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ContatoViewH extends Application {

    private List<Contato> lista = new ArrayList<>();
    private long indiceContato = 1L;

    @Override
    public void start(Stage stage) { 
        BorderPane panPrincipal = new BorderPane();
        Scene scn = new Scene( panPrincipal, 400, 350);

        GridPane panCampos = new GridPane();

        // Label lblNome = new Label("Nome: ");
        // panCampos.add(lblNome, 0, 0);
        Label lblId = new Label("");
        TextField txtNome = new TextField();
        TextField txtEmail = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtNascimento = new TextField();

        panCampos.add(new Label("Id: "), 0, 0);
        panCampos.add( lblId, 1, 0);
        panCampos.add(new Label("Nome: "), 0, 1);
        panCampos.add( txtNome, 1, 1);
        panCampos.add(new Label("Email: "), 0, 2);
        panCampos.add( txtEmail, 1, 2);
        panCampos.add(new Label("Telefone: "), 0, 3);
        panCampos.add( txtTelefone, 1, 3);
        panCampos.add(new Label("Nascimento: "), 0, 4);
        panCampos.add( txtNascimento, 1, 4);
        
        Button btnSalvar = new Button("Salvar");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        btnSalvar.setOnAction( 
            e ->  {
                Contato contato = new Contato();
                contato.setId( indiceContato++ );
                contato.setNome( txtNome.getText() );
                contato.setTelefone( txtTelefone.getText() );
                contato.setEmail( txtEmail.getText() );
                LocalDate data = LocalDate.parse( txtNascimento.getText(), dtf );
                contato.setNascimento( data );

                lista.add( contato );

                new Alert(AlertType.INFORMATION, "Contato Salvo com sucesso")
                    .showAndWait();

                txtNome.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");
                txtNascimento.setText("");
            }
        );

        Button btnPesquisar = new Button("Pesquisar");

        btnPesquisar.setOnAction( 
            e -> {
                for(Contato contato : lista) { 
                    if (contato.getNome().contains( txtNome.getText() )) { 
                        lblId.setText( String.valueOf(contato.getId()) );
                        txtNome.setText( contato.getNome() );
                        txtTelefone.setText( contato.getTelefone() );
                        txtEmail.setText( contato.getEmail() );
                        txtNascimento.setText( 
                            dtf.format( contato.getNascimento() ) 
                        );
                        break;
                    }
                }
            }
        );

        HBox panBotoes = new HBox();
        panBotoes.getChildren().addAll(btnSalvar, btnPesquisar);

        panPrincipal.setCenter(panCampos);
        panPrincipal.setBottom(panBotoes);

        stage.setScene(scn);
        stage.setTitle("Agenda de Contato - H");
        stage.show();
    }    
}
