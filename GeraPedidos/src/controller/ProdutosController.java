/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import UTIL.Alerta;
import gerapedidos.principalController;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

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
    private TextField tfPedoLiquido;
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

    private final String tipos[] = {"Venda", "Uso e Consumo", "Matéria-Prima"};
    private final String unidadesMedida[] = {"UND", "PC", "LT", "CX", "KG"};

    private ObservableList<String> dadosUnidades = FXCollections.observableArrayList();
    private ObservableList<String> dadosTipos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configuraCBUnidadeMedida();
        configuraCBTipoProduto();
    }
    
    private void verificaPodeFinalizar(){
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
    }

    @FXML
    private void actionBtnGerarCodigoBarras(ActionEvent event) {
    }

    @FXML
    private void btnEnterPressed(KeyEvent event) {
    }

    @FXML
    private void actionBtnPrimeiro(ActionEvent event) {
    }

    @FXML
    private void actionBtnAnterior(ActionEvent event) {
    }

    @FXML
    private void actionBtnProximo(ActionEvent event) {
    }

    @FXML
    private void actionBtnUltimo(ActionEvent event) {
    }

    @FXML
    private void actionBtnNovo(ActionEvent event) {
    }

    @FXML
    private void actionBtnEditar(ActionEvent event) {
    }

    @FXML
    private void actionBtnSalvar(ActionEvent event) {
    }

    @FXML
    private void actionBtnCancelar(ActionEvent event) {
    }

    @FXML
    private void actionBtnInativar(ActionEvent event) {
    }

    @FXML
    private void actionBtnSair(ActionEvent event) {
        if (this.Edicao || this.Inclusao) {
            Alerta a = new Alerta(3, "Cadastro de Produto em andamento!", "Finalize ou Cancele o cadastro antes de Sair");
        } else {
            principalController.getTelaProdutos().close();
        }
    }

}
