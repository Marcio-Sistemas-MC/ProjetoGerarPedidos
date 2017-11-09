/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import UTIL.Alerta;
import entidades.banco.Cidade;
import entidades.banco.Clientes;
import entidades.controllers.CidadeJpaController;
import entidades.controllers.ClientesJpaController;
import gerapedidos.principalController;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author Ateliê do Software Sistemas sobre Medida
 */
public class ClientesController implements Initializable {

    @FXML
    private ComboBox<String> cbCliente;
    @FXML
    private TextField tfCodigo;
    @FXML
    private TextField tfEmpresa;
    @FXML
    private TextField tfEndereco;
    @FXML
    private TextField tfNumero;
    @FXML
    private TextField tfBairro;
    @FXML
    private ComboBox<String> cbCidade;
    @FXML
    private TextField tfUF;
    @FXML
    private CheckBox ckAtivo;
    @FXML
    private TextField tftelefone;
    @FXML
    private TextField tfCelular;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfcpfcnpj;
    @FXML
    private TextField tfIeRg;
    @FXML
    private TableView<Clientes> tbClientes;
    @FXML
    private TableColumn<Clientes, Integer> clCodigo;
    @FXML
    private TableColumn<Clientes, String> clNome;
    @FXML
    private TableColumn<Clientes, String> clEmpresa;
    @FXML
    private TableColumn<Clientes, String> clEndereco;
    @FXML
    private TableColumn<Clientes, String> clNumero;
    @FXML
    private TableColumn<Clientes, String> clBairro;
    @FXML
    private TableColumn<Clientes, String> clCidade;
    @FXML
    private TableColumn<Clientes, String> clUF;
    @FXML
    private TableColumn<Clientes, String> clTelefone;
    @FXML
    private TableColumn<Clientes, String> clCelular;
    @FXML
    private TableColumn<Clientes, String> clEmail;
    @FXML
    private TableColumn<Clientes, String> clAtivo;
    @FXML
    private TableColumn<Clientes, String> clCpfCnpj;
    @FXML
    private TableColumn<Clientes, String> clIeRg;
    @FXML
    private Button btnPrimeiro;
    @FXML
    private Button btnAnterior;
    @FXML
    private Button btnProximo;
    @FXML
    private Button btnUltimo;
    @FXML
    private Button btnIncluir;
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnSair;
    @FXML
    private Button btnSalvar;

    private static boolean edicao_inclusao = false; // controlar quando a tela estáem edição ou inclusão para verificar fechamento da janela;
    private boolean edicao; // verificar se está em edição para atualizar (update) no banco de dados
    private boolean inclusao; // verificar se está em inclusão para inserir (insert) no banco de dados
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("geraPedidosPU");
    private final ClientesJpaController cliDao = new ClientesJpaController(emf);
    private List<Clientes> clientes = new ArrayList<>();
    private List<Cidade> cidades = new ArrayList<>();

    // utilizado para filtragem na tabela
    private final ObservableList<Clientes> masterData = FXCollections.observableArrayList();
    private final ObservableList<String> masterCidade = FXCollections.observableArrayList();
    
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configuraTabela();
        carregarDadosClientes();
        configuraCBCidades();
        configuraCBNome();
        configuraModoConsulta();
    }

    private void configuraModoConsulta() {
        // desabilitar os campos
        this.tfBairro.setDisable(true);
        this.tfCelular.setDisable(true);
        this.tfCodigo.setDisable(true);
        this.tfEmail.setDisable(true);
        this.tfEmpresa.setDisable(true);
        this.tfEndereco.setDisable(true);
        this.tfNumero.setDisable(true);
        this.tfUF.setDisable(true);
        this.tftelefone.setDisable(true);
        this.cbCidade.setDisable(true);
        this.ckAtivo.setDisable(true);
        this.tfcpfcnpj.setDisable(true);
        this.tfIeRg.setDisable(true);
        // limpar conteúdo dos campos;
        this.tfBairro.clear();
        this.tfCelular.clear();
        this.tfCodigo.clear();
        this.tfEmail.clear();
        this.tfEmpresa.clear();
        this.tfEndereco.clear();
        this.tfNumero.clear();
        this.tfUF.clear();
        this.tftelefone.clear();
        this.cbCidade.getEditor().clear();
        this.ckAtivo.setSelected(false);
        this.cbCliente.getEditor().clear();
        // botões
        this.btnAlterar.setDisable(false);
        this.btnAnterior.setDisable(false);
        this.btnCancelar.setDisable(true);
        this.btnIncluir.setDisable(false);
        this.btnPrimeiro.setDisable(false);
        this.btnProximo.setDisable(false);
        this.btnSair.setDisable(false);
        this.btnUltimo.setDisable(false);
        this.btnSalvar.setDisable(true);
        // indicar que a tela não está em edição
        edicao_inclusao = false;
        this.edicao = false;
        this.inclusao = false;
    }

    private void configuraModoInclusaoEdicao() {
        // habilitar os campos
        this.tfBairro.setDisable(false);
        this.tfCelular.setDisable(false);
        this.tfCodigo.setDisable(true);
        this.tfEmail.setDisable(false);
        this.tfEmpresa.setDisable(false);
        this.tfEndereco.setDisable(false);
        this.tfNumero.setDisable(false);
        this.tfUF.setDisable(false);
        this.tftelefone.setDisable(false);
        this.cbCidade.setDisable(false);
        this.ckAtivo.setDisable(false);
        this.tfcpfcnpj.setDisable(false);
        this.tfIeRg.setDisable(false);
        // limpar conteúdo dos campos;
        this.tfBairro.clear();
        this.tfCelular.clear();
        this.tfCodigo.clear();
        this.tfEmail.clear();
        this.tfEmpresa.clear();
        this.tfEndereco.clear();
        this.tfNumero.clear();
        this.tfUF.clear();
        this.tftelefone.clear();
        this.cbCidade.getEditor().clear();
        this.ckAtivo.setSelected(true);
        this.cbCliente.getEditor().clear();
        // botões
        this.btnAlterar.setDisable(true);
        this.btnAnterior.setDisable(true);
        this.btnCancelar.setDisable(false);
        this.btnIncluir.setDisable(true);
        this.btnPrimeiro.setDisable(true);
        this.btnProximo.setDisable(true);
        this.btnSair.setDisable(true);
        this.btnUltimo.setDisable(true);
        this.btnSalvar.setDisable(false);
        // indicar que a tela está em edição
        edicao_inclusao = true;
    }

    private void configuraCBNome() {
        // código copiado de : http://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Clientes> filteredData = new FilteredList<>(masterData, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        this.cbCliente.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cliente -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                // Does not match.
                return cliente.getNome().toLowerCase().contains(lowerCaseFilter);
            });
        });
        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Clientes> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(this.tbClientes.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        this.tbClientes.setItems(sortedData);
    }

    private void configuraCBCidades() {
        // carrega as cidades do banco de dados
        CidadeJpaController cidadeDao = new CidadeJpaController(emf);
        cidades = cidadeDao.findCidadeEntities();
        // carrega as cidades no combobox de cidades
        cidades.forEach((c) -> {
            this.masterCidade.add(c.getNome());
        });
        // configura o preenchimento automático do campo UF
        FilteredList<String> filteredData = new FilteredList<>(masterCidade, p -> true);
        this.cbCidade.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            cidades.forEach((c) -> {
                if (c.getNome().toLowerCase().equals(newValue.toLowerCase())) {
                    this.tfUF.setText(c.getEstado().getUf());
                }
            });
        });
        this.cbCidade.setItems(masterCidade);
    }

    private void carregarDadosClientes() {
        // carrega clientes do banco de dados
        clientes.clear();
        clientes = cliDao.findClientesEntities();
        // carrega clientes na tabela de clientes;
        this.masterData.clear();
        this.masterData.addAll(clientes);
    }

    private void configuraTabela() {
        this.clCodigo.setCellValueFactory(new PropertyValueFactory<>("codpessoa"));
        this.clNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.clEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        this.clEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        this.clNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        this.clBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
        this.clCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        this.clUF.setCellValueFactory(new PropertyValueFactory<>("uf"));
        this.clAtivo.setCellValueFactory(new PropertyValueFactory<>("flgativo"));
        this.clTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        this.clCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
        this.clEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.clCpfCnpj.setCellValueFactory(new PropertyValueFactory<>("cpfCnpj"));
        this.clIeRg.setCellValueFactory(new PropertyValueFactory<>("ieRg"));
    }

    @FXML
    private void actionBtnPrimeiro(ActionEvent event) {
        if (this.tbClientes.getSelectionModel() != null) {
            this.tbClientes.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void actionBtnAnterior(ActionEvent event) {
        if (this.tbClientes.getSelectionModel() != null) {
            this.tbClientes.getSelectionModel().selectPrevious();
        }
    }

    @FXML
    private void actionBtnProximo(ActionEvent event) {
        if (this.tbClientes.getSelectionModel() != null) {
            this.tbClientes.getSelectionModel().selectNext();
        }
    }

    @FXML
    private void actionBtnUltimo(ActionEvent event) {
        if (this.tbClientes.getSelectionModel() != null) {
            this.tbClientes.getSelectionModel().selectLast();
        }
    }

    @FXML
    private void actionBtnIncluir(ActionEvent event) {
        configuraModoInclusaoEdicao();
        this.edicao = false;
        this.inclusao = true;
        this.cbCidade.getEditor().setText("Monte Carmelo");
    }

    @FXML
    private void actionBtnAlterar(ActionEvent event) {
        configuraModoInclusaoEdicao();
        this.edicao = true;
        this.inclusao = false;
        carregarDadosClienteEdicao();
    }

    @FXML
    private void actionBtnCancelar(ActionEvent event) {
        configuraModoConsulta();
    }

    @FXML
    private void ActionBtnSair(ActionEvent event) {
        if (!edicao_inclusao) {
            principalController.getTelaClientes().close();
        }
    }

    public static boolean emEdicaoInclusao() {
        return edicao_inclusao;
    }

    @FXML
    private void actionBtnSalvar(ActionEvent event) {
        if (this.cbCliente.getEditor().getText().isEmpty()) {
            Alerta a = new Alerta(2, "Campo Obrigatório", "Nome deve ser preenchido");
        } else {
            Clientes cli = new Clientes();
            cli.setNome(this.cbCliente.getEditor().getText());
            cli.setEmpresa(this.tfEmpresa.getText());
            cli.setBairro(this.tfBairro.getText());
            cli.setCelular(this.tfCelular.getText());
            cli.setCidade(this.cbCidade.getEditor().getText());
            cli.setEmail(this.tfEmail.getText());
            cli.setEndereco(this.tfEndereco.getText());
            if (this.ckAtivo.isSelected()) {
                cli.setFlgativo('S');
            } else {
                cli.setFlgativo('N');
            }
            cli.setNumero(this.tfNumero.getText());
            cli.setTelefone(this.tftelefone.getText());
            cli.setUf(this.tfUF.getText());
            cli.setCpfCnpj(this.tfcpfcnpj.getText());
            cli.setIeRg(this.tfIeRg.getText());
            if (this.edicao) {
                try {
                    cli.setCodpessoa(Integer.parseInt(this.tfCodigo.getText()));
                    cliDao.edit(cli);
                    Alerta a = new Alerta(3, "Atualização realizada!", "Cliente " + cli.getNome() + " Atualizado com sucesso");
                } catch (Exception ex) {
                    Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
                    Alerta a = new Alerta(0, "Erro ao atualizar cliente", ex.getMessage());
                }
            } else if (this.inclusao) {
                try {
                    cli.setCodpessoa(this.proximoCliente());
                    this.tfCodigo.setText(String.valueOf(cli.getCodpessoa()));
                    cliDao.create(cli);
                    Alerta a = new Alerta(3, "Cadastro realizado!", "Cliente " + cli.getNome() + " cadastrado com sucesso");
                } catch (Exception ex) {
                    Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
                    Alerta a = new Alerta(0, "Erro ao cadastrar cliente!", ex.getMessage());
                }
            }
            this.configuraModoConsulta();
            this.carregarDadosClientes();
        }
    }

    private int proximoCliente() {
        int max = 0;
        for (Clientes c : clientes) {
            if (c.getCodpessoa() > max) {
                max = c.getCodpessoa();
            }
        }
        // o próximo será o maior código cadastrado mais 1;
        return max + 1;
    }

    private void carregarDadosClienteEdicao() {
        Clientes cli = this.tbClientes.getSelectionModel().getSelectedItem();
        if (cli != null) {
            this.cbCliente.getEditor().setText(cli.getNome());
            this.tfCodigo.setText(String.valueOf(cli.getCodpessoa()));
            this.tfBairro.setText(cli.getBairro());
            this.tfCelular.setText(cli.getCelular());
            this.tfEmail.setText(cli.getEmail());
            this.tfEmpresa.setText(cli.getEmpresa());
            this.tfEndereco.setText(cli.getEndereco());
            this.tfNumero.setText(cli.getNumero());
            this.tfUF.setText(cli.getUf());
            this.tftelefone.setText(cli.getTelefone());
            this.cbCidade.getEditor().setText(cli.getCidade());
            this.tfcpfcnpj.setText(cli.getCpfCnpj());
            this.tfIeRg.setText(cli.getIeRg());
        }
    }

}
