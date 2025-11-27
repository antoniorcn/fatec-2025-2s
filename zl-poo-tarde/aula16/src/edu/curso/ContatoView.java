package edu.curso;

import java.time.format.DateTimeFormatter;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

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

        Button btnNovo = new Button("Novo");
        Button btnSalvar = new Button("Salvar");
        Button btnPesquisar = new Button("Pesquisar");

        panCampos.add(new Label("Id: "), 0, 0);
        panCampos.add( lblId, 1, 0);
        panCampos.add( btnNovo, 2, 0);
        panCampos.add(new Label("Nome: "), 0, 1);
        panCampos.add( txtNome, 1, 1);
        panCampos.add(new Label("Email: "), 0, 2);
        panCampos.add( txtEmail, 1, 2);
        panCampos.add(new Label("Telefone: "), 0, 3);
        panCampos.add( txtTelefone, 1, 3);
        panCampos.add(new Label("Nascimento: "), 0, 4);
        panCampos.add(dtaNascimento, 1, 4);

        tableView.setItems( control.getLista() );

        TableColumn<Contato, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory( e -> new ReadOnlyStringWrapper(
            e.getValue().getNome()
        ));

        TableColumn<Contato, String> colTelefone = new TableColumn<>("Telefone");
        colTelefone.setCellValueFactory( e -> new ReadOnlyStringWrapper(
            e.getValue().getTelefone()
        ));

        TableColumn<Contato, String> colEmail = new TableColumn<>("Email");
        colEmail.setCellValueFactory( e -> new ReadOnlyStringWrapper(
            e.getValue().getEmail()
        ));

        TableColumn<Contato, String> colNascimento = new TableColumn<>("Nascimento");
        colNascimento.setCellValueFactory( e -> new ReadOnlyStringWrapper(
            e.getValue().getNascimento().format( dtf )
        ));


        // TableCell<Contato, Void> fabricanteCelula = new TableCell<>() {
        //     @Override
        //     public void updateItem(Void item, boolean empty) { 
        //         super.updateItem(item, empty);
        //         if (!empty) { 
        //             setGraphic( new Button("Apagar") );
        //         } else { 
        //             setGraphic( new Label("Celula Vazia") );
        //         }
        //     }
        // };

        // Callback<TableColumn<Contato, Void>, TableCell<Contato, Void>> fabricanteColunaAcoes = 
        // new Callback<>() {

        //     @Override
        //     public TableCell<Contato, Void> call(TableColumn<Contato, Void> param) {
        //         return new TableCell<>() {
        //             @Override
        //             public void updateItem(Void item, boolean empty) { 
        //                 super.updateItem(item, empty);
        //                 if (!empty) { 
        //                     setGraphic( new Button("Apagar") );
        //                 } else { 
        //                     setGraphic( null );
        //                 }
        //             }
        //          };
        //     }
        // };

        Callback<TableColumn<Contato, Void>, TableCell<Contato, Void>> fabricanteColunaAcoes =
        ( param ) -> new TableCell<>() {
            private Button btnApagar = new Button("Apagar");
            private Button btnEditar = new Button("Editar");
        
            { 
                btnApagar.setOnAction( e -> { 
                        control.apagar( getIndex() );
                        new Alert(AlertType.INFORMATION, 
                        "Registro apagado com sucesso " )
                        .showAndWait();
                    }
                );

                btnEditar.setOnAction( e -> { 
                        control.editar( getIndex() );
                        new Alert(AlertType.INFORMATION, 
                        "Registro aberto para edição " )
                        .showAndWait();
                    }
                );
            }

            @Override
            public void updateItem(Void item, boolean empty) { 
                super.updateItem(item, empty);
                if (!empty) { 
                    setGraphic( new HBox(btnApagar, btnEditar) );
                } else { 
                    setGraphic( null );
                }
            }
        };

        TableColumn<Contato, Void> colAcoes = new TableColumn<>("Ações");
        colAcoes.setCellFactory(fabricanteColunaAcoes);


        tableView.getColumns().add(colNome);
        tableView.getColumns().add(colTelefone);
        tableView.getColumns().add(colEmail);
        tableView.getColumns().add(colNascimento);
        tableView.getColumns().add(colAcoes);


        Bindings.bindBidirectional(lblId.textProperty(), control.idProperty(), 
                    new NumberStringConverter() );
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), control.emailProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
        Bindings.bindBidirectional(dtaNascimento.valueProperty(), control.nascimentoProperty());

        btnSalvar.setOnAction(
            e ->  {
                control.gravar();
                new Alert(AlertType.INFORMATION, "Contato Salvo com sucesso")
                    .showAndWait();
                tableView.refresh();
                control.limparTela();
            }
        );

        btnPesquisar.setOnAction(
            e -> {
                control.pesquisar();
            }
        );

        btnNovo.setOnAction( e -> { 
            control.idProperty().set( 0 );
        });

        

        HBox panBotoes = new HBox();
        panBotoes.getChildren().addAll(btnSalvar, btnPesquisar);

        VBox panSuperior = new VBox();
        panSuperior.getChildren().addAll(panCampos, panBotoes);

        panPrincipal.setTop(panSuperior);
        panPrincipal.setCenter(tableView);

        return panPrincipal;
    }
}
