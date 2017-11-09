/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import UTIL.Alerta;
import UTIL.GeraReferenciasEAN13;
import entidades.banco.Produtos;
import entidades.controllers.ProdutosJpaController;
import gerapedidos.principalController;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ateliê do Software Sistemas sobre Medida
 */
public class ProdutosController implements Initializable {

    public boolean Edicao = true;
    public boolean Inclusao = true;

    @FXML
    private TextField tfCodProduto;
    @FXML
    private TextField tfDescricaoProduto;
    @FXML
    private ComboBox<String> cbTipoProduto;
    @FXML
    private Tab abaProduto;
    @FXML
    private TextField tfCodBarras;
    @FXML
    private Button btnGerarCodigoBarras;
    @FXML
    private TextField tfApresentacao;
    @FXML
    private TextField tfCodGtin;
    @FXML
    private TextField tfMedida;
    @FXML
    private CheckBox ckAtivo;
    @FXML
    private ComboBox<String> cbUnidMedida;
    @FXML
    private TextField tfPesoBruto;
    @FXML
    private TextField tfCodNcm;
    @FXML
    private TextField tfCodCest;
    @FXML
    private TextField tfVaidade;
    @FXML
    private Tab abaObservacao;
    @FXML
    private TextArea taObservacao;
    @FXML
    private Tab abaPrecos;
    @FXML
    private TextField tfCustoCompra;
    @FXML
    private TextField tfMargemLucro;
    @FXML
    private TextField tfPrecoVista;
    @FXML
    private TextField tfAcrescimoFin;
    @FXML
    private TextField tfPrecoPrazo;
    @FXML
    private Label lbDataReajuste;
    @FXML
    private Label lbUsuarioReajuste;
    @FXML
    private Tab abaEstoques;
    @FXML
    private Button btnPrimeiro;
    @FXML
    private Button btnAnterior;
    @FXML
    private Button btnProximo;
    @FXML
    private Button btnUltimo;
    @FXML
    private Button btnNovo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnInativar;
    @FXML
    private ImageView imgAtivaDesativa;
    @FXML
    private Button btnSair;
    @FXML
    private TabPane painelPrincipal;
    @FXML
    private Tab abaProdutos;
    @FXML
    private TableView<Produtos> tabelaProdutos;
    @FXML
    private TableColumn<Produtos, String> colCodigo;
    @FXML
    private TableColumn<Produtos, String> colDescricao;
    @FXML
    private TableColumn<Produtos, String> colReferencia;
    @FXML
    private TableColumn<Produtos, String> colunMedida;
    @FXML
    private TableColumn<Produtos, Double> colCusto;
    @FXML
    private TableColumn<Produtos, Double> colVista;
    @FXML
    private TableColumn<Produtos, Double> colPrazo;
    @FXML
    private ComboBox<String> cbCampos;
    @FXML
    private TextField tfConsulta;
    @FXML
    private Button btnConsultar;
    @FXML
    private Tab abaDados;

    private final String campos[] = {"Código", "Descrição", "Referência", "Unid. Medida", "Custo", "À Vista", "A Prazo"};
    private final String tipos[] = {"Venda", "Uso e Consumo", "Matéria-Prima"};
    private final String unidadesMedida[] = {"UND", "PC", "LT", "CX", "KG"};

    private ObservableList<String> dadosUnidades = FXCollections.observableArrayList();
    private ObservableList<String> dadosTipos = FXCollections.observableArrayList();

    private List<Produtos> produtos = new ArrayList<>();

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("geraPedidosPU");
    @FXML
    private TextField tfPesoLiquido;
    @FXML
    private TextField tfEstoque;
    @FXML
    private TextField tfEstoqueMin;
    @FXML
    private TextField tfEstoqueMax;
    @FXML
    private TextField tfQdPedidos;
    @FXML
    private TextField tfQdCompra;
    @FXML
    private Label lbUltimaVenda;
    @FXML
    private Label lbQdUltVenda;
    @FXML
    private Label lbUltCompra;
    @FXML
    private Label lbQdultCompra;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configuraCBUnidadeMedida();
        configuraCBTipoProduto();
        configuraCBCampos();
        configuartaTabela();
    }

    private void configuraCBCampos() {
        this.cbCampos.getItems().addAll(campos);
        this.cbCampos.getSelectionModel().selectFirst();
    }

    private void configuartaTabela() {
        this.colCodigo.setCellValueFactory(new PropertyValueFactory<>("codpro"));
        this.colCusto.setCellValueFactory(new PropertyValueFactory<>("custocompra"));
        this.colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.colPrazo.setCellValueFactory(new PropertyValueFactory<>("precoPraz"));
        this.colReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        this.colVista.setCellValueFactory(new PropertyValueFactory<>("precoVist"));
        this.colunMedida.setCellValueFactory(new PropertyValueFactory<>("unidmed"));
    }

    private void buscarProdutos() {
        this.produtos.clear();
        ProdutosJpaController prodDao = new ProdutosJpaController(emf);
        produtos = prodDao.findProdutosEntities();
    }

    private void verificaPodeFinalizar() {
        //Verificar como impedir o fechamento da janela com item em edição;
    }

    private void configuraCBUnidadeMedida() {
        this.dadosUnidades.addAll(unidadesMedida);
        this.cbUnidMedida.setItems(dadosUnidades);
    }

    private void configuraCBTipoProduto() {
        this.dadosTipos.addAll(tipos);
        this.cbTipoProduto.setItems(dadosTipos);
    }

    @FXML
    private void btnCodBarrasPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            this.tfCodBarras.setText(gerarCodigoBarras());
        }
    }

    @FXML
    private void actionBtnGerarCodigoBarras(ActionEvent event) {
        this.tfCodBarras.setText(gerarCodigoBarras());
    }

    private String gerarCodigoBarras() {
        GeraReferenciasEAN13 cod = new GeraReferenciasEAN13();
        String codBar;
        while (true) {
            codBar = cod.gerarReferenciaEAN13();
            boolean existe = false;
            for (Produtos p : produtos) {
                if (p.getReferencia().equalsIgnoreCase(codBar)) {
                    existe = true;
                }
            }
            if (!existe) {
                return codBar;
            }
        }
    }

    @FXML
    private void btnEnterPressed(KeyEvent event) {
    }

    @FXML
    private void actionBtnPrimeiro(ActionEvent event) {
        if(!this.tabelaProdutos.getItems().isEmpty()) {
            this.tabelaProdutos.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void actionBtnAnterior(ActionEvent event) {
        if(!this.tabelaProdutos.getItems().isEmpty()) {
            this.tabelaProdutos.getSelectionModel().selectPrevious();
        }
    }

    @FXML
    private void actionBtnProximo(ActionEvent event) {
        if(!this.tabelaProdutos.getItems().isEmpty()) {
            this.tabelaProdutos.getSelectionModel().selectNext();
        }
    }

    @FXML
    private void actionBtnUltimo(ActionEvent event) {
        if(!this.tabelaProdutos.getItems().isEmpty()) {
            this.tabelaProdutos.getSelectionModel().selectLast();
        }
    }

    @FXML
    private void actionBtnNovo(ActionEvent event) {
    }

    @FXML
    private void actionBtnEditar(ActionEvent event) {
        if(!this.tabelaProdutos.getItems().isEmpty()) {
            Produtos prod = this.tabelaProdutos.getSelectionModel().getSelectedItem();
            this.Edicao = true;
            this.Inclusao = false;
            configuraEdicao(prod);
            System.out.println(prod.getCodpro() + " - " + prod.getDescricao() + " -> " + prod.getUnidmed());
        }
    }

    @FXML
    private void actionBtnSalvar(ActionEvent event
    ) {
    }

    @FXML
    private void actionBtnCancelar(ActionEvent event
    ) {
    }

    @FXML
    private void actionBtnInativar(ActionEvent event
    ) {
    }

    @FXML
    private void actionBtnSair(ActionEvent event) {
        if (this.Edicao || this.Inclusao) {
            Alerta a = new Alerta(3, "Cadastro de Produto em andamento!", "Finalize ou Cancele o cadastro antes de Sair");
        } else {
            principalController.getTelaProdutos().close();
        }
    }

    @FXML
    private void verificaSelecaoItem(KeyEvent event
    ) {
    }

    @FXML
    private void verificaClickItem(MouseEvent event
    ) {
    }

    @FXML
    private void actionConsultarProdutos(ActionEvent event) {
        this.produtos.clear();
        this.buscarProdutos();
        this.tabelaProdutos.getItems().clear();
        String campo = this.cbCampos.getValue();
        if (!this.tfConsulta.getText().trim().isEmpty()) {
            CharSequence termo = this.tfConsulta.getText();
            //"Código", "Descrição", "Referência", "Unid. Medida", "Custo", "À Vista", "A Prazo"
            switch (campo) {
                case "Código":
                    produtos.stream().filter((c) -> (String.valueOf(c.getCodpro()).contains(termo))).forEachOrdered((c) -> {
                        this.tabelaProdutos.getItems().add(c);
                    });
                    break;
                case "Descrição":
                    produtos.stream().filter((c) -> (c.getDescricao().toUpperCase().contains(termo.toString().toUpperCase()))).forEachOrdered((c) -> {
                        this.tabelaProdutos.getItems().add(c);
                    });
                    break;
                case "Referência":
                    produtos.stream().filter((c) -> (c.getReferencia().toUpperCase().contains(termo.toString().toUpperCase()))).forEachOrdered((c) -> {
                        this.tabelaProdutos.getItems().add(c);
                    });
                    break;
                case "Unid. Medida":
                    produtos.stream().filter((c) -> (c.getUnidmed().contains(termo))).forEachOrdered((c) -> {
                        this.tabelaProdutos.getItems().add(c);
                    });
                    break;
                case "Custo":
                    produtos.stream().filter((c) -> (String.valueOf(c.getCustocompra()).contains(termo))).forEachOrdered((c) -> {
                        this.tabelaProdutos.getItems().add(c);
                    });
                    break;
                case "À Vista":
                    produtos.stream().filter((c) -> (String.valueOf(c.getPrecoVist()).contains(termo))).forEachOrdered((c) -> {
                        this.tabelaProdutos.getItems().add(c);
                    });
                    break;
                case "A Prazo":
                    produtos.stream().filter((c) -> (String.valueOf(c.getPrecoPraz()).contains(termo))).forEachOrdered((c) -> {
                        this.tabelaProdutos.getItems().add(c);
                    });
                    break;
            }
        } else {
            this.tabelaProdutos.getItems().addAll(produtos);
        }
        if (!this.tabelaProdutos.getItems().isEmpty()) {
            this.tabelaProdutos.getSelectionModel().selectFirst();
        }
        this.btnAnterior.setDisable(false);
        this.btnPrimeiro.setDisable(false);
        this.btnProximo.setDisable(false);
        this.btnUltimo.setDisable(false);
        this.btnEditar.setDisable(false);
        this.btnInativar.setDisable(false);
    }

    private void configuraEdicao(Produtos prod) {
        this.abaProdutos.setDisable(true);
        this.painelPrincipal.getSelectionModel().select(abaDados);
        
        this.tfAcrescimoFin.setText(String.valueOf(prod.getAcresfin()));
        this.tfApresentacao.setText(prod.getApresentacao());
        this.tfCodBarras.setText(prod.getReferencia());
        this.tfCodCest.setText(prod.getCodcest());
        this.tfCodGtin.setText(prod.getCodgtin());
        this.tfCodNcm.setText(prod.getCodncm());
        this.tfCodProduto.setText(String.valueOf(prod.getCodpro()));
        this.tfCustoCompra.setText(String.valueOf(prod.getCustocompra()));
        this.tfDescricaoProduto.setText(prod.getDescricao());
        this.tfMargemLucro.setText(String.valueOf(prod.getMargem()));
        this.tfMedida.setText(prod.getMedida());
        this.tfPesoBruto.setText(String.valueOf(prod.getPesobruto()));
        this.tfPesoLiquido.setText(String.valueOf(prod.getPesoliq()));
        this.tfPrecoPrazo.setText(String.valueOf(prod.getPrecoPraz()));
        this.tfPrecoVista.setText(String.valueOf(prod.getPrecoVist()));
        this.tfVaidade.setText(String.valueOf(prod.getValidade()));
        this.tfEstoque.setText(String.valueOf(prod.getQdEst()));
        this.tfEstoqueMax.setText(String.valueOf(prod.getQdMax()));
        this.tfEstoqueMin.setText(String.valueOf(prod.getPontopedido()));
        this.tfQdCompra.setText(String.valueOf(prod.getQdPedcompra()));
        this.tfQdPedidos.setText(String.valueOf(prod.getQdPedido()));
        if(null != prod.getFlaginativo() && prod.getFlaginativo().equalsIgnoreCase("S")) {
            this.ckAtivo.setSelected(true);
        } else {
            this.ckAtivo.setSelected(false);
        }
        this.lbDataReajuste.setText(String.valueOf(prod.getDataPreco()));
        this.lbQdUltVenda.setText(String.valueOf(prod.getUltvendaqtde()));
        this.lbQdultCompra.setText(String.valueOf(0)); // Verificar campo no banco de dados
        this.lbUltCompra.setText(String.valueOf(""));// Verificar campo no banco de dados
        this.lbUltimaVenda.setText(String.valueOf(prod.getUltvendadta()));
        this.lbUsuarioReajuste.setText("Administrador");
        this.taObservacao.setText(prod.getObs());
        //this.cbTipoProduto.getSelectionModel().select(TipoProduto.getTipo(prod.getCodtipo()));
        this.cbUnidMedida.getSelectionModel().select(prod.getUnidmed());
    }

}
