package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class AgendaContatoForm extends Application {

    private  DateTimeFormatter formatter = 
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private List<Contato> lista = new ArrayList<>();
    private long idIndice = 1L;

    @Override
    public void start(Stage stage) { 
        BorderPane panPrincipal = new BorderPane();
        Scene scn = new Scene( panPrincipal, 400, 200);

        GridPane panCampos = new GridPane();

        Label lblId = new Label("");
        TextField txtNome = new TextField("");
        TextField txtTelefone = new TextField("");
        TextField txtEmail = new TextField("");
        TextField txtNascimento = new TextField("");

        panCampos.add(new Label("Id"), 0, 0 );
        panCampos.add(lblId, 1, 0);
        panCampos.add(new Label("Nome Completo"), 0, 1 );
        panCampos.add(txtNome, 1, 1);
        panCampos.add(new Label("Telefone"), 0, 2 );
        panCampos.add(txtTelefone, 1, 2);
        panCampos.add(new Label("Email"), 0, 3 );
        panCampos.add(txtEmail, 1, 3);
        panCampos.add(new Label("Nascimento"), 0, 4 );
        panCampos.add(txtNascimento, 1, 4);

        panPrincipal.setCenter( panCampos );

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        btnSalvar.setOnAction( e -> {
            Contato contato = new Contato();
            contato.setId( idIndice++ );
            contato.setNome( txtNome.getText() );
            contato.setEmail( txtEmail.getText() );
            contato.setTelefone( txtTelefone.getText() );
            LocalDate dtaNasc = LocalDate.parse(txtNascimento.getText(), formatter);
            contato.setNascimento( dtaNasc );
            lista.add( contato );
            new Alert(AlertType.INFORMATION, 
                "Contato gravado com sucesso",
                            new ButtonType[] {ButtonType.OK}
                    ).showAndWait();
            lblId.setText("");
            txtNascimento.setText("");
            txtNome.setText("");
            txtTelefone.setText("");
            txtEmail.setText("");
        });

        btnPesquisar.setOnAction( e-> { 
            String nome = txtNome.getText();
            for (Contato contato : lista) { 
                if (contato.getNome().contains( nome )) { 
                    lblId.setText( String.valueOf(contato.getId()) );
                    txtNome.setText( contato.getNome() );
                    txtEmail.setText( contato.getEmail() );
                    txtTelefone.setText( contato.getTelefone() );
                    txtNascimento.setText( 
                        formatter.format( contato.getNascimento() )
                    );
                }
            }
        });
        
        HBox panBotoes = new HBox();
        panBotoes.getChildren().addAll( btnSalvar, btnPesquisar);
        panPrincipal.setBottom(panBotoes);

        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(AgendaContatoForm.class, args);
    }
}