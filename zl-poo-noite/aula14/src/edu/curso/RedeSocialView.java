package edu.curso;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RedeSocialView implements Tela {
    private Label lblId = new Label("");
    private TextField txtNome = new TextField();
    private TextField txtUserName = new TextField();
    private TextField txtBio = new TextField();

    private TableView<Contato> tableView = new TableView<>();
    @Override
    public Pane render() { 
        BorderPane panPrincipal = new BorderPane();

        GridPane panCampos = new GridPane();

        panCampos.add(new Label("Id: "), 0, 0);
        panCampos.add( lblId, 1, 0);
        panCampos.add(new Label("Nome: "), 0, 1);
        panCampos.add( txtNome, 1, 1);
        panCampos.add(new Label("UserName: "), 0, 2);
        panCampos.add( txtUserName, 1, 2);
        panCampos.add(new Label("Bio: "), 0, 3);
        panCampos.add( txtBio, 1, 3);

        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory( e -> new ReadOnlyStringWrapper(
            e.getValue().getNome().toUpperCase()
        ));

        tableView.getColumns().add(colNome);

        btnSalvar.setOnAction(
            e ->  {
            }
        );

        btnPesquisar.setOnAction(
            e -> {
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
