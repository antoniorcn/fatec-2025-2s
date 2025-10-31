package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class ContatoView extends Application {
    private Label lblId = new Label("");
    private TextField txtNome = new TextField();
    private TextField txtEmail = new TextField();
    private TextField txtTelefone = new TextField();
    // private TextField txtNascimento = new TextField();
    private DatePicker dtaNascimento = new DatePicker();
    private ContatoControl control = new ContatoControl();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void start(Stage stage) { 
        BorderPane panPrincipal = new BorderPane();
        Scene scn = new Scene( panPrincipal, 400, 350);

        GridPane panCampos = new GridPane();

        panCampos.add(new Label("Id: "), 0, 0);
        panCampos.add( lblId, 1, 0);
        panCampos.add(new Label("Nome: "), 0, 1);
        panCampos.add( txtNome, 1, 1);
        panCampos.add(new Label("Email: "), 0, 2);
        panCampos.add( txtEmail, 1, 2);
        panCampos.add(new Label("Telefone: "), 0, 3);
        panCampos.add( txtTelefone, 1, 3);
        panCampos.add(new Label("Nascimento: "), 0, 4);
        // panCampos.add( txtNascimento, 1, 4);
        panCampos.add(dtaNascimento, 1, 4);

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        // txtNome.widthProperty().addListener(
        //     (obj, antigo, novo) -> System.out.println(novo)
        // );

        // txtNome.textProperty().bind( txtTelefone.textProperty() );
        // Bindings.bindBidirectional(txtNome.textProperty(),
        //                                 txtTelefone.textProperty());

        LocalDateStringConverter converter = new LocalDateStringConverter(dtf, dtf);

        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), control.emailProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
        // Bindings.bindBidirectional(txtNascimento.textProperty(), control.nascimentoProperty(), converter);
        Bindings.bindBidirectional(dtaNascimento.valueProperty(), control.nascimentoProperty());

        btnSalvar.setOnAction(
            e ->  {
                control.gravar();
                new Alert(AlertType.INFORMATION, "Contato Salvo com sucesso")
                    .showAndWait();
                control.limparTela();
            }
        );

        btnPesquisar.setOnAction(
            e -> {
                control.pesquisar();
            }
        );

        HBox panBotoes = new HBox();
        panBotoes.getChildren().addAll(btnSalvar, btnPesquisar);

        panPrincipal.setCenter(panCampos);
        panPrincipal.setBottom(panBotoes);

        stage.setScene(scn);
        stage.setTitle("Agenda de Contato");
        stage.show();
    }



    public static void main(String[] args) {
        Application.launch( ContatoView.class, args );
    }
}
