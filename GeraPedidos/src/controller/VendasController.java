/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import UTIL.DigitalClock;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 *
 * @author Ateliê do Software Sistemas sobre Medida
 */
public class VendasController implements Initializable {

    @FXML
    private Label lbNomeCli;
    @FXML
    private Label lbEnderecoCli;
    @FXML
    private Label lbCidadeCli;
    @FXML
    private Label lbCPFCNPJCli;
    @FXML
    private Label lbStatusCli;
    @FXML
    private TextField tfCodBarras;
    @FXML
    private TextField tfQuantidadeItem;
    @FXML
    private TextField tfValorItem;
    @FXML
    private TextField tfTotalItem;
    @FXML
    private Label lbQtdeProdutos;
    @FXML
    private Label lbTotalCompra;
    @FXML
    private Hyperlink hlNovaVenda;
    @FXML
    private Hyperlink hlConsultarVenda;
    @FXML
    private Hyperlink hlSelecionarCliente;
    @FXML
    private Hyperlink hlImprimirComprovante;
    @FXML
    private Hyperlink hlConsultarPreco;
    @FXML
    private Hyperlink hlFinalizarVenda;
    @FXML
    private Hyperlink hlSair;
    @FXML
    private Hyperlink hlExcluirItem;
    @FXML
    private ListView<?> litsaItens;
    @FXML
    private Label lbDataAtual;
    @FXML
    private Pane painelDataHora;
    @FXML
    private Label lbHoraAtual;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configuraDataHora();
    }
    
    private void configuraDataHora() {
        DigitalClock dc = new DigitalClock();
        dc.setFont(Font.font("Comic Sans MS Bold", 14));
        dc.setTextFill(Paint.valueOf("White"));
        this.painelDataHora.getChildren().add(dc);
        
        LocalDateTime dt = LocalDateTime.now();
        String dataAtual = dt.getDayOfMonth() + "/" + dt.getMonthValue() + "/" + dt.getYear();
        this.lbDataAtual.setText(dataAtual);
    }

    @FXML
    private void actionTeclaAtalho(KeyEvent event) {
    }

    @FXML
    private void actionNovaVenda(ActionEvent event) {
    }

    @FXML
    private void actionConsultaVenda(ActionEvent event) {
    }

    @FXML
    private void actionSelecionarCliente(ActionEvent event) {
    }

    @FXML
    private void actionImprimirComprovante(ActionEvent event) {
    }

    @FXML
    private void actionConsultaPreco(ActionEvent event) {
    }

    @FXML
    private void actionFinalizarVenda(ActionEvent event) {
    }

    @FXML
    private void actionSair(ActionEvent event) {
    }

    @FXML
    private void actionExcluirItem(ActionEvent event) {
    }

}
