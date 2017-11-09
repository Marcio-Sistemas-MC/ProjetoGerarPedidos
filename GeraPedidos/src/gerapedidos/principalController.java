/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerapedidos;


import UTIL.Alerta;
import controller.ClientesController;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ateliê do Software Sistemas sobre Medida
 */
public class principalController implements Initializable {

    @FXML
    private MenuItem mnCliente;
    @FXML
    private MenuItem mnProdutos;
    @FXML
    private MenuItem mnPedidos;
    @FXML
    private MenuItem mnComprovante;
    @FXML
    private MenuItem mnReceber;
    @FXML
    private MenuItem mnSobre;
    @FXML
    private MenuItem mnSair;
    @FXML
    private Button btnClientes;
    @FXML
    private Button btnProdutos;
    @FXML
    private Button btnPedidos;
    @FXML
    private Button btnComprovante;
    @FXML
    private Button btnReceber;
    @FXML
    private Button btnSair;
    @FXML
    private Pane painelExibir;
    @FXML
    private ImageView imgLogo;

    private final Image clienteIcone = new Image("/icones/cliente.png");
    private final Image produtoIcone = new Image("/icones/produto.png");
    private final Image pedidoIcone = new Image("/icones/pedidos.png");
    private final Image comprovanteIcone = new Image("/icones/comprovante.png");
    private final Image receberIcone = new Image("/icones/receber.png");
    private final Image sobreIcone = new Image("/icones/sobre.png");
    private final Image sairIcone = new Image("/icones/sair.png");
    private final Image imagemLogo = new Image("/icones/icone.png");

    private final double TAMANHO_ICONES = 20;
    private final double TAMNHO_ICONE_BOTAO = 50;

    private static Stage telaVendas;
    private static Stage telaClientes;
    private static Stage telaProdutos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prepraraMenus();
        preparaBotoes();
        //preparaImagemLogo();
    }

    private void prepraraMenus() {
        // Adicionando um ícone aos menus itens
        ImageView img = new ImageView(clienteIcone);
        this.mnCliente.setGraphic(img);
        img.setFitWidth(TAMANHO_ICONES);
        img.setFitHeight(TAMANHO_ICONES);

        img = new ImageView(produtoIcone);
        this.mnProdutos.setGraphic(img);
        img.setFitWidth(TAMANHO_ICONES);
        img.setFitHeight(TAMANHO_ICONES);

        img = new ImageView(pedidoIcone);
        this.mnPedidos.setGraphic(img);
        img.setFitWidth(TAMANHO_ICONES);
        img.setFitHeight(TAMANHO_ICONES);

        img = new ImageView(comprovanteIcone);
        this.mnComprovante.setGraphic(img);
        img.setFitWidth(TAMANHO_ICONES);
        img.setFitHeight(TAMANHO_ICONES);

        img = new ImageView(sobreIcone);
        this.mnSobre.setGraphic(img);
        img.setFitWidth(TAMANHO_ICONES);
        img.setFitHeight(TAMANHO_ICONES);

        img = new ImageView(sairIcone);
        this.mnSair.setGraphic(img);
        img.setFitWidth(TAMANHO_ICONES);
        img.setFitHeight(TAMANHO_ICONES);

        img = new ImageView(receberIcone);
        this.mnReceber.setGraphic(img);
        img.setFitWidth(TAMANHO_ICONES);
        img.setFitHeight(TAMANHO_ICONES);

    }

    private void preparaBotoes() {
        // Adiionando ícones aos botões;
        ImageView img = new ImageView(clienteIcone);
        this.btnClientes.setGraphic(img);
        img.setFitWidth(TAMNHO_ICONE_BOTAO);
        img.setFitHeight(TAMNHO_ICONE_BOTAO);

        img = new ImageView(produtoIcone);
        this.btnProdutos.setGraphic(img);
        img.setFitWidth(TAMNHO_ICONE_BOTAO);
        img.setFitHeight(TAMNHO_ICONE_BOTAO);

        img = new ImageView(pedidoIcone);
        this.btnPedidos.setGraphic(img);
        img.setFitWidth(TAMNHO_ICONE_BOTAO);
        img.setFitHeight(TAMNHO_ICONE_BOTAO);

        img = new ImageView(comprovanteIcone);
        this.btnComprovante.setGraphic(img);
        img.setFitWidth(TAMNHO_ICONE_BOTAO);
        img.setFitHeight(TAMNHO_ICONE_BOTAO);

        img = new ImageView(receberIcone);
        this.btnReceber.setGraphic(img);
        img.setFitWidth(TAMNHO_ICONE_BOTAO);
        img.setFitHeight(TAMNHO_ICONE_BOTAO);

        img = new ImageView(sairIcone);
        this.btnSair.setGraphic(img);
        img.setFitWidth(TAMNHO_ICONE_BOTAO);
        img.setFitHeight(TAMNHO_ICONE_BOTAO);

    }

    private void preparaImagemLogo() {
        this.imgLogo.setImage(imagemLogo);
        this.imgLogo.setFitHeight(300);
        this.imgLogo.setFitWidth(300);
    }

    @FXML
    private void actionMnComprovante(ActionEvent event) {
    }

    @FXML
    private void actionMnSobre(ActionEvent event) {
    }

    @FXML
    private void actionCadClientes(ActionEvent event) throws IOException, Exception {
        Parent cliente = FXMLLoader.load(getClass().getResource("/views/clientes.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(cliente);
        stage.setScene(scene);
        stage.setTitle("Cadastro de Clientes");
        stage.setResizable(false);
        stage.getIcons().add(clienteIcone);
        //stage.setHeight(550);
       // stage.setWidth(995);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(this.painelExibir.getScene().getWindow());
        stage.centerOnScreen();
        telaClientes = stage;
        stage.setOnCloseRequest(new EventHandler() {
            @Override
            public void handle(Event event) {
                if(ClientesController.emEdicaoInclusao()) {
                    Alerta a = new Alerta(0,"Atençao","Cadastro em edição.\n Caso deseje sair, clique em 'Cancelar' primeiro!!!");
                }
                else {
                    stage.close();
                }
            }
        });
        stage.show();
    }

    @FXML
    private void actionCadProdutos(ActionEvent event) throws IOException {
        //Parent cliente = FXMLLoader.load(getClass().getResource("/aplicacao/produtos.fxml"));
        Parent cliente = FXMLLoader.load(getClass().getResource("/views/cadprodutos.fxml"));
        Stage stage = new Stage();
        telaProdutos = stage;
        stage.setScene(new Scene(cliente));
        stage.setTitle("Cadastro de Produtos");
        stage.setResizable(false);
        stage.getIcons().add(produtoIcone);
        //setUserAgentStylesheet(STYLESHEET_MODENA);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(this.painelExibir.getScene().getWindow());
        
        stage.show();
    }

    @FXML
    private void actionPeidosVendas(ActionEvent event) throws IOException {
       // Parent cliente = FXMLLoader.load(getClass().getResource("/aplicacao/vendas.fxml"));
        Parent cliente = FXMLLoader.load(getClass().getResource("/views/telavendas.fxml"));
        Stage stage = new Stage();
        this.telaVendas = stage;
        stage.setScene(new Scene(cliente));
        stage.setTitle("Venda de Produtos");
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);
        stage.getIcons().add(produtoIcone);
        //setUserAgentStylesheet(STYLESHEET_MODENA);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(this.painelExibir.getScene().getWindow());
        
        stage.show();
    }

    @FXML
    private void ActionImprimeComprovante(ActionEvent event) {
    }

    @FXML
    private void actionAReceber(ActionEvent event) {
    }

    @FXML
    private void actionSairSistema(ActionEvent event) {
        GeraPedidos.close();
    }

    public static Stage getTelaClientes() {
        return telaClientes;
    }

    public static Stage getTelaProdutos() {
        return telaProdutos;
    }

    public static Stage getTelaVendas() {
        return telaVendas;
    }

}
