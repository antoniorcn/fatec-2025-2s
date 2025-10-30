package edu.curso;

import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class ContatoView extends Application { 

    private ContatoControl control = new ContatoControl();
    private TableView<Contato> tableView = new TableView<>();

    public void start(Stage stage) { 
        BorderPane panPrincipal = new BorderPane();
        GridPane panForm = new GridPane();

        Scene scn = new Scene(panPrincipal, 400, 300);

        TextField txtNome = new TextField();
        TextField txtTelefone = new TextField();
        TextField txtEmail = new TextField();
        TextField txtNascimento = new TextField();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateStringConverter conversor = new LocalDateStringConverter(formatter, formatter);
        

        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), control.emailProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
        Bindings.bindBidirectional(txtNascimento.textProperty(), 
        control.nascimentoProperty(), conversor);

        tableView.setItems( control.getLista() );

        TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory( 
            item -> new ReadOnlyStringWrapper( item.getValue().getNome() )
        );

        tableView.getSelectionModel().selectedItemProperty().addListener(
           (obj, antigo, novo) -> control.fromEntity(novo)
        );

        tableView.getColumns().add( colNome );

        panPrincipal.setCenter(tableView);
        

        panForm.add(new Label("Nome: "), 0, 0);
        panForm.add(txtNome, 1, 0);
        panForm.add(new Label("Telefone: "), 0, 1);
        panForm.add(txtTelefone, 1, 1);
        panForm.add(new Label("Email: "), 0, 2);
        panForm.add(txtEmail, 1, 2);
        panForm.add(new Label("Nascimento: "), 0, 3);
        panForm.add(txtNascimento, 1, 3);

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setOnAction( e -> control.salvar() );
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction( e -> control.pesquisar() );
        
        VBox panSuperior = new VBox();
        HBox panBotoes = new HBox();
        panBotoes.getChildren().addAll( btnSalvar, btnPesquisar);       
        panPrincipal.setBottom( panBotoes );
        panSuperior.getChildren().addAll( panForm, panBotoes );
        panPrincipal.setTop(panSuperior);

        // txtNome.widthProperty().addListener(
        //     (obj, antigo, novo) -> {
        //         System.out.println(novo);
        //     }
        // );

        // Label lblTexto = new Label();
        // panForm.add(lblTexto, 0, 4);

        // txtNome.textProperty().addListener(
        //     (obj, antigo, novo) -> { 
        //         lblTexto.setText("Nome Completo: " + novo);
        //     }
        // );

        // lblTexto.textProperty().bind( txtNome.textProperty() );

        // Bindings.bindBidirectional(txtEmail.textProperty(), txtTelefone.textProperty());


        stage.setScene(scn);
        stage.setTitle("Agenda de Contatos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ContatoView.class, args);
    }

}