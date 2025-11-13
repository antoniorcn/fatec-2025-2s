package edu.curso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class ContatoView implements Tela {
    private Label lblId = new Label("");
    private TextField txtNome = new TextField();
    private TextField txtEmail = new TextField();
    private TextField txtTelefone = new TextField();
    private DatePicker dtaNascimento = new DatePicker();
    private ContatoControl control = new ContatoControl();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private TableView<Contato> tableView = new TableView<>();

    @Override
    public Pane render() {
        BorderPane panPrincipal = new BorderPane();
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
        panCampos.add(dtaNascimento, 1, 4);

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        tableView.setItems( control.getLista() );

        TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory( e -> new ReadOnlyStringWrapper(
            e.getValue().getNome().toUpperCase()
        ));

        tableView.getColumns().add(colNome);

        LocalDateStringConverter converter = new LocalDateStringConverter(dtf, dtf);

        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), control.emailProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
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

        VBox panSuperior = new VBox();
        panSuperior.getChildren().addAll(panCampos, panBotoes);

        panPrincipal.setTop(panSuperior);
        panPrincipal.setCenter(tableView);

        return panPrincipal;
    }
}
