/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import UTIL.Alerta;
import entidades.banco.Cidade;
import entidades.banco.Clientes;
import entidades.banco.Estado;
import entidades.controllers.CidadeJpaController;
import entidades.controllers.ClientesJpaController;
import entidades.controllers.EstadoJpaController;
import gerapedidos.principalController;
import java.math.BigDecimal;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ateliê do Software Sistemas sobre Medida
 */
public class CadastroClientesController implements Initializable {

    @FXML
    private TextField tfcodCliente;
    @FXML
    private TextField tfNomeCliente;
    @FXML
    private DatePicker dtAdimissao;
    @FXML
    private ComboBox<String> cbTipo;
    @FXML
    private Tab abaPessoaFisica;
    @FXML
    private TextField tfCPF;
    @FXML
    private TextField tfRG;
    @FXML
    private ComboBox<String> cbEstadoCivil;
    @FXML
    private TextField tfApelido;
    @FXML
    private TextField tfNaturalidade;
    @FXML
    private TextField tfConjuge;
    @FXML
    private TextField tfMae;
    @FXML
    private TextField tfPai;
    @FXML
    private TextField tfLocalTrabalho;
    @FXML
    private TextField tfTelTrabalho;
    @FXML
    private TextField TfRenda;
    @FXML
    private TextField tfProfissao;
    @FXML
    private DatePicker dtAdimissaoTrabalho;
    @FXML
    private Tab abaPessoaJuridica;
    @FXML
    private TextField tfRazaoSocial;
    @FXML
    private TextField tfCNPJ;
    @FXML
    private TextField tfInscEstadual;
    @FXML
    private Tab abaEndComercial;
    @FXML
    private TextField tfRuaComercial;
    @FXML
    private TextField tfNumComercial;
    @FXML
    private TextField tfCompComercial;
    @FXML
    private TextField tfBairroComercial;
    @FXML
    private ComboBox<String> cbUFComercial;
    @FXML
    private ComboBox<String> cbCidadeComercial;
    @FXML
    private TextField tfCEPComercial;
    @FXML
    private Tab abaEndDomicilio;
    @FXML
    private TextField tfRuaDomicilio;
    @FXML
    private TextField tfNumDomicilio;
    @FXML
    private TextField tfCompComercial1;
    @FXML
    private TextField tfBairroDomicilio;
    @FXML
    private ComboBox<String> cbUFDomicilio;
    @FXML
    private ComboBox<String> cbDomicilio;
    @FXML
    private TextField tfCEPDomicilio;
    @FXML
    private Tab abaContatos;
    @FXML
    private TextField tfTelefone;
    @FXML
    private TextField tfFax;
    @FXML
    private TextField tfCelular;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfContato;
    @FXML
    private Tab abaObservacao;
    @FXML
    private TextArea taObservacao;
    @FXML
    private Tab abaOutras;
    @FXML
    private ComboBox<String> cbContribuinte;
    @FXML
    private Label lbAtivo;
    @FXML
    private Label lbUsuInclusao;
    @FXML
    private Label lbDtInclusao;
    @FXML
    private Label lbUsuAlteracao;
    @FXML
    private Label lbDtAlteracao;
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
    private Tab abaClientes;
    @FXML
    private ComboBox<String> cbCampos; //Código, Nome, Tipo, CPF, CNPJ, Telefone, Ativo
    @FXML
    private TextField tfConsulta;
    @FXML
    private Button btnConsultar;
    @FXML
    private TableView<Clientes> tabelaClientes;
    @FXML
    private TableColumn<Clientes, String> colCodigo;
    @FXML
    private TableColumn<Clientes, String> colNome;
    @FXML
    private TableColumn<Clientes, String> colTipo;
    @FXML
    private TableColumn<Clientes, String> colCPF;
    @FXML
    private TableColumn<Clientes, String> colCNPJ;
    @FXML
    private TableColumn<Clientes, String> colTelefone;
    @FXML
    private TableColumn<Clientes, String> colAtivo;
    @FXML
    private Tab abaDados;
    @FXML
    private TabPane painelPrincipal;
    @FXML
    private DatePicker dtNascimento;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("geraPedidosPU");
    private List<Cidade> cidades = new ArrayList<>();
    private List<Estado> estados = new ArrayList<>();
    private List<Clientes> clientes = new ArrayList<>();
    private boolean edicao = false;
    private final String siglasEstados[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
        "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configuraTabela();
        configuraCBCmpos();
        configuraCBTipo();
        configuraCBUF();
        configuraCbEstadoCivil();
        configuraCBTipoContribuinte();
    }

    private void buscaClientes() {
        ClientesJpaController cliDao = new ClientesJpaController(emf);
        clientes = cliDao.findClientesEntities();
    }

    private void buscaCidades() {
        CidadeJpaController cidDao = new CidadeJpaController(emf);
        cidades.clear();
        cidades = cidDao.findCidadeEntities();
    }

    private void configuraCBCmpos() {
        this.cbCampos.getItems().addAll("Código", "Nome", "Tipo", "CPF", "CNPJ", "Telefone", "Ativo");
        this.cbCampos.setValue(this.cbCampos.getItems().get(0));
    }

    private void configuraCBTipo() {
        this.cbTipo.getItems().addAll("Física", "Jurídica");
    }

    private void configuraCbEstadoCivil() {
        this.cbEstadoCivil.getItems().clear();
        this.cbEstadoCivil.getItems().addAll("Solteiro(a)", "Casodo(a)", "Viúvo(a)", "Divorciado(a)", "Outros");
        this.cbEstadoCivil.getSelectionModel().selectFirst();
    }

    private void configuraCBTipoContribuinte() {
        this.cbContribuinte.getItems().clear();
        this.cbContribuinte.getItems().addAll("Consumidor Final não Contribuinte", "Contribuinte");
    }

    private void configuraCBUF() {
        this.cbUFComercial.getItems().clear();
        this.cbUFDomicilio.getItems().clear();
        EstadoJpaController ufDao = new EstadoJpaController(emf);
        estados = ufDao.findEstadoEntities();
        estados.forEach((e) -> {
            this.cbUFComercial.getItems().add(e.getUf());
            this.cbUFDomicilio.getItems().add(e.getUf());
        });
        //this.cbUFComercial.getItems().addAll(siglasEstados);
        //this.cbUFDomicilio.getItems().addAll(siglasEstados);
    }

    private void configuraTabela() {
        this.colCodigo.setCellValueFactory(new PropertyValueFactory<>("codpessoa"));
        this.colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        this.colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        this.colCNPJ.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        this.colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        this.colAtivo.setCellValueFactory(new PropertyValueFactory<>("ativo"));

    }

    @FXML
    private void btnEnterPressed(KeyEvent event) {
    }

    @FXML
    private void actionBtnPrimeiro(ActionEvent event) {
        this.tabelaClientes.getSelectionModel().selectFirst();
    }

    @FXML
    private void actionBtnAnterior(ActionEvent event) {
        this.tabelaClientes.getSelectionModel().selectPrevious();
    }

    @FXML
    private void actionBtnProximo(ActionEvent event) {
        this.tabelaClientes.getSelectionModel().selectNext();
    }

    @FXML
    private void actionBtnUltimo(ActionEvent event) {
        this.tabelaClientes.getSelectionModel().selectLast();
    }

    @FXML
    private void actionBtnNovo(ActionEvent event) {
        this.edicao = false;
        this.abaClientes.setDisable(true);
        this.painelPrincipal.getSelectionModel().select(abaDados);

        this.btnAnterior.setDisable(true);
        this.btnCancelar.setDisable(false);
        this.btnEditar.setDisable(true);
        this.btnInativar.setDisable(true);
        this.btnNovo.setDisable(true);
        this.btnPrimeiro.setDisable(true);
        this.btnProximo.setDisable(true);
        this.btnSair.setDisable(true);
        this.btnSalvar.setDisable(false);
        this.btnUltimo.setDisable(true);

       configuraDadosIniciais();
        // carregar dados, Salvar;
    }
    
    private void configuraDadosIniciais() {
         this.dtAdimissao.setValue(LocalDate.now());
         this.lbAtivo.setText("SIM");
         this.configuraTextoAtivo();
         this.cbUFComercial.setValue("MG");
         // Talvez será necessário habilitar as cidades....
         this.cbUFDomicilio.setValue("MG");
         this.cbContribuinte.getSelectionModel().selectFirst();
         
    }

    private boolean validaDadosObrigatorios() {// Verificar o preenchimento de alguns campos necessários obrigatóriamente
        if (this.tfNomeCliente.getText().trim().isEmpty()) {
            Alerta a = new Alerta(2, "Campo Obrigatório!", "Nome do Cliente deve ser Preenchido!");
            return false;
        }
        return true;
    }

    private void carregarDadosTela() {
        ClientesJpaController cliDao = new ClientesJpaController(emf);
        Clientes cli = new Clientes();

        cli.setApelido(this.tfApelido.getText());
        cli.setAtivo("S");
        cli.setBairro(this.tfBairroComercial.getText());
        cli.setBairrodom(this.tfBairroDomicilio.getText());
        cli.setCelular(this.tfCelular.getText());
        cli.setCep(this.tfCEPComercial.getText());
        cli.setCepdom(this.tfCEPDomicilio.getText());
        cli.setCnpj(this.tfCNPJ.getText());
        this.capturaCidadeEstado(cli);
        cli.setComplCom(this.tfCompComercial.getText());
        cli.setComplDom(this.tfCompComercial1.getText());
        cli.setConjuge(this.tfConjuge.getText());
        cli.setCpf(this.tfCPF.getText());
        if (!this.dtNascimento.getEditor().getText().isEmpty()) {
            cli.setDataNasc(new Date(this.dtNascimento.getEditor().getText()));
        }
        if (!this.dtAdimissao.getEditor().getText().isEmpty()) {
            cli.setDtaAdmissao(new Date(this.dtAdimissao.getEditor().getText()));
        }
        if (!this.dtAdimissaoTrabalho.getEditor().getText().isEmpty()) {
            cli.setDtaAdmtrabalho(new Date(this.dtAdimissaoTrabalho.getEditor().getText()));
        }
        cli.setEmail(this.tfemail.getText());
        cli.setEstadoCiv(this.cbEstadoCivil.getSelectionModel().getSelectedItem());
        cli.setFiliacaoMae(this.tfMae.getText());
        cli.setFiliacaoPai(this.tfPai.getText());
        cli.setInscest(this.tfInscEstadual.getText());
        cli.setLocaltrabalho(this.tfLocalTrabalho.getText());
        cli.setLograCom(this.tfRuaComercial.getText());
        cli.setLograDom(this.tfRuaDomicilio.getText());
        cli.setNaturalidade(this.tfNaturalidade.getText());
        cli.setNome(this.tfNomeCliente.getText());
        cli.setNumCom(this.tfNumComercial.getText());
        cli.setNumDom(this.tfNumDomicilio.getText());
        cli.setObservacao(this.taObservacao.getText());
        cli.setPessoacontato(this.tfContato.getText());
        cli.setProftrabalho(this.tfProfissao.getText());
        cli.setRazaosocial(this.tfRazaoSocial.getText());
        try {
            cli.setRenda(new BigDecimal(this.TfRenda.getText()));
        } catch (Exception ex) {
            System.out.println("Trstar erro campo Renda");
        }
        cli.setRg(this.tfRG.getText());
        cli.setTelefone(this.tfTelefone.getText());
        cli.setTelefonetrabalho(this.tfTelTrabalho.getText());
        this.capturaTipoCliente(cli); // No banco é salvo F ou J
        this.capturaTipoAliquotaIcms(cli); // 1 - Consumidor Final  / 2 - Contribuinte
        cli.setUppernome(this.tfNomeCliente.getText().toUpperCase());
        if (this.edicao) {
            cli.setCodpessoa(Integer.parseInt(this.tfcodCliente.getText()));
            System.out.println("Cliente que está sendo salvo: " + cli.getCodpessoa() + "-" + cli.getNome());
            try {
                System.out.println(cli.toString());
                cliDao.edit(cli);
            } catch (Exception ex) {
                System.out.println("Erro aqui " + ex.getMessage());
            }
        } else {
            //setando com último encontrado + 1;
            cli.setCodpessoa(this.maiorCodigoCli() + 1);
            System.out.println(cli.toString());
            cliDao.create(cli);
        }
        this.actionConsultarClientes(new ActionEvent());
    }

    private void capturaTipoAliquotaIcms(Clientes cli) {
        int pos = this.cbContribuinte.getSelectionModel().getSelectedIndex();
        if (pos == 0) {
            cli.setTipoaliqicms(1);
        } else {
            cli.setTipoaliqicms(2);
        }
    }

    private void capturaTipoCliente(Clientes cli) {
        String tipo = this.cbTipo.getSelectionModel().getSelectedItem();
        if (tipo.equalsIgnoreCase("Física")) {
            cli.setTipo("F");
        } else {
            cli.setTipo("J");
        }
    }

    // Preenche a cidade Domicílio e Comercial do cliente
    private void capturaCidadeEstado(Clientes cli) {
        for (Cidade c : cidades) {
            if (null != this.cbCidadeComercial.getSelectionModel().getSelectedItem()) {
                if (this.cbCidadeComercial.getSelectionModel().getSelectedItem().equalsIgnoreCase(c.getNome())) {
                    cli.setCodcidade(c.getId());
                }
            }
            if (null != this.cbDomicilio.getSelectionModel().getSelectedItem()) {
                if (this.cbDomicilio.getSelectionModel().getSelectedItem().equalsIgnoreCase(c.getNome())) {
                    cli.setCodcidadedom(c.getId());
                }
            }

        }
    }

    @FXML
    private void actionBtnEditar(ActionEvent event) {
        configuraModoEdicao();
    }

    private void configuraModoEdicao() {
        this.btnAnterior.setDisable(true);
        this.btnCancelar.setDisable(false);
        this.btnEditar.setDisable(true);
        this.btnInativar.setDisable(true);
        this.btnNovo.setDisable(true);
        this.btnPrimeiro.setDisable(true);
        this.btnProximo.setDisable(true);
        this.btnSair.setDisable(true);
        this.btnSalvar.setDisable(false);
        this.btnUltimo.setDisable(true);

        Clientes cli = this.tabelaClientes.getSelectionModel().getSelectedItem();
        editarCliente(cli);
    }

    @FXML
    private void actionBtnSalvar(ActionEvent event) {
        if (this.validaDadosObrigatorios()) {
            this.carregarDadosTela();
            this.btnAnterior.setDisable(false);
            this.btnCancelar.setDisable(true);
            this.btnEditar.setDisable(false);
            this.btnInativar.setDisable(false);
            this.btnNovo.setDisable(false);
            this.btnPrimeiro.setDisable(false);
            this.btnProximo.setDisable(false);
            this.btnSair.setDisable(false);
            this.btnSalvar.setDisable(true);
            this.btnUltimo.setDisable(false);
        }
    }

    @FXML
    private void actionBtnCancelar(ActionEvent event) {
    }

    @FXML
    private void actionBtnInativar(ActionEvent event) {
        try {
            ClientesJpaController cliDao = new ClientesJpaController(emf);
            Clientes c = this.tabelaClientes.getSelectionModel().getSelectedItem();
            if (c.getAtivo().equalsIgnoreCase("S")) {
                c.setAtivo("N");
            } else {
                c.setAtivo("S");
            }
            cliDao.edit(c);
            this.actionConsultarClientes(new ActionEvent());
            alterarBotaoAtivarInativar(c);
        } catch (Exception ex) {
            Alerta a = new Alerta(5, "Selecione um Cliente para Inativar/Ativar", "");
        }
    }

    private void alterarBotaoAtivarInativar(Clientes cli) {
        if (cli.getAtivo().equalsIgnoreCase("S")) {
            this.btnInativar.setText("Inativar");
            this.imgAtivaDesativa.setImage(new Image("/icones/inativar.png"));
        } else {
            this.btnInativar.setText("Ativar");
            this.imgAtivaDesativa.setImage(new Image("/icones/ativar.png"));
        }

    }

    @FXML
    private void actionBtnSair(ActionEvent event) {
        principalController.getTelaClientes().close();
    }

    @FXML
    private void actionConsultarClientes(ActionEvent event) {
        this.clientes.clear();
        this.buscaClientes();
        this.tabelaClientes.getItems().clear();
        String campo = this.cbCampos.getValue();
        if (!this.tfConsulta.getText().trim().isEmpty()) {
            CharSequence termo = this.tfConsulta.getText();
            //Código, Nome, Tipo, CPF, CNPJ, Telefone, Ativo
            switch (campo) {
                case "Código":
                    clientes.stream().filter((c) -> (String.valueOf(c.getCodpessoa()).contains(termo))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "Nome":
                    clientes.stream().filter((c) -> (c.getNome().toUpperCase().contains(termo.toString().toUpperCase()))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "Tipo":
                    clientes.stream().filter((c) -> (c.getTipo().toUpperCase().contains(termo.toString().toUpperCase()))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "CPF":
                    clientes.stream().filter((c) -> (c.getCpf().contains(termo))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "CNPJ":
                    clientes.stream().filter((c) -> (c.getCnpj().contains(termo))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "Telefone":
                    clientes.stream().filter((c) -> (c.getTelefone().contains(termo))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
                case "Ativo":
                    clientes.stream().filter((c) -> (c.getAtivo().toUpperCase().contains(termo.toString().toUpperCase()))).forEachOrdered((c) -> {
                        this.tabelaClientes.getItems().add(c);
                    });
                    break;
            }

        } else {
            this.tabelaClientes.getItems().addAll(clientes);
        }
        if (!this.tabelaClientes.getItems().isEmpty()) {
            this.tabelaClientes.getSelectionModel().selectFirst();
        }
        this.btnAnterior.setDisable(false);
        this.btnPrimeiro.setDisable(false);
        this.btnProximo.setDisable(false);
        this.btnUltimo.setDisable(false);
        this.btnEditar.setDisable(false);
        this.btnInativar.setDisable(false);
    }

    private void editarCliente(Clientes cli) {
        if (!this.tabelaClientes.getItems().isEmpty()) {
            this.edicao = true;
            this.painelPrincipal.getSelectionModel().select(this.abaDados);
            // preenchimento dos campos por ordem alfabética
            this.TfRenda.setText(String.valueOf(cli.getRenda()));
            this.tfApelido.setText(cli.getApelido());
            this.tfBairroComercial.setText(cli.getBairro());
            this.tfBairroDomicilio.setText(cli.getBairrodom());
            this.tfCEPComercial.setText(cli.getCep());
            this.tfCEPDomicilio.setText(cli.getCepdom());
            this.tfCNPJ.setText(cli.getCnpj());
            this.tfCPF.setText(cli.getCpf());
            this.tfCelular.setText(cli.getCelular());
            this.tfCompComercial.setText(cli.getComplCom());
            this.tfCompComercial1.setText(cli.getComplDom());
            this.tfConjuge.setText(cli.getConjuge());
            this.tfContato.setText(cli.getPessoacontato());
            //this.tfFax.setText();
            this.tfInscEstadual.setText(cli.getInscest());
            this.tfLocalTrabalho.setText(cli.getLocaltrabalho());
            this.tfMae.setText(cli.getFiliacaoMae());
            this.tfNaturalidade.setText(cli.getNaturalidade());
            this.tfNomeCliente.setText(cli.getNome());
            this.tfNumComercial.setText(cli.getNumCom());
            this.tfNumDomicilio.setText(cli.getNumDom());
            this.tfPai.setText(cli.getFiliacaoPai());
            this.tfProfissao.setText(cli.getProftrabalho());
            this.tfRG.setText(cli.getRg());
            this.tfRazaoSocial.setText(cli.getRazaosocial());
            this.tfRuaComercial.setText(cli.getLograCom());
            this.tfRuaDomicilio.setText(cli.getLograDom());
            this.tfTelTrabalho.setText(cli.getTelefonetrabalho());
            this.tfTelefone.setText(cli.getTelefone());
            this.tfcodCliente.setText(String.valueOf(cli.getCodpessoa()));
            this.tfemail.setText(cli.getEmail());
            this.cbContribuinte.getSelectionModel().select(tipoAliquotaICMS(cli.getTipoaliqicms()));
            this.CarregaCidadesEstadoCliente(cli);// carrega dados dos estados e cidades do cad. Cliente
            this.cbEstadoCivil.getSelectionModel().select(cli.getEstadoCiv());
            this.cbTipo.getSelectionModel().select(carregaTipoCliente(cli.getTipo()));
            carregaDatas(cli);// carrega as datas no formato LocalDate;
            carregaCampoAtivo(cli);
        }
    }

    private void carregaCampoAtivo(Clientes cli) {
        if (cli.getAtivo().equalsIgnoreCase("S")) {
            this.lbAtivo.setText("SIM");
        } else {
            this.lbAtivo.setText("NÃO");
        }
        configuraTextoAtivo();
    }
    
    private void configuraTextoAtivo() {
        if(this.lbAtivo.getText().equalsIgnoreCase("SIM")) {
            this.lbAtivo.setTextFill(Paint.valueOf("GREEN"));
        } else {
            this.lbAtivo.setTextFill(Paint.valueOf("RED"));
        }
    }

    private void carregaDatas(Clientes cli) {
        if (null != cli.getDtaAdmissao()) {
            LocalDate ld = toLocalDate(cli.getDtaAdmissao());
            this.dtAdimissao.setValue(ld);
        }
        if (null != cli.getDtaAdmtrabalho()) {
            LocalDate ld1 = toLocalDate(cli.getDtaAdmtrabalho());
            this.dtAdimissaoTrabalho.setValue(ld1);
        }
        if (null != cli.getDataNasc()) {
            LocalDate ld2 = toLocalDate(cli.getDataNasc());
            this.dtNascimento.setValue(ld2);
        }
    }

    // Convertendo Date em Local Date;
    public static LocalDate toLocalDate(Date d) {
        Instant instant = Instant.ofEpochMilli(d.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    private void CarregaCidadesEstadoCliente(Clientes cli) {
        this.buscaCidades();
        cidades.stream().map((c) -> {
            if (c.getId() == cli.getCodcidade()) {
                this.cbCidadeComercial.getSelectionModel().select(c.getNome());
                this.cbUFComercial.getSelectionModel().select(c.getEstado().getUf());
            }
            return c;
        }).filter((c) -> (c.getId() == cli.getCodcidadedom())).map((c) -> {
            this.cbDomicilio.getSelectionModel().select(c.getNome());
            return c;
        }).forEachOrdered((c) -> {
            this.cbUFDomicilio.getSelectionModel().select(c.getEstado().getUf());
        });
    }

    @FXML
    private void actionSelecionarCidadeTeclado(KeyEvent event) {
        String uf = this.cbUFComercial.getSelectionModel().getSelectedItem();
        if (null == uf) {
            System.out.println("null mesmo");
            Alerta a = new Alerta(2, "Estado não selecionado", "Selecione o Estado para carregar a lista de Cidades");
        } else {
            this.configuraCBCidadeComercial(uf, this.cbCidadeComercial);
        }
    }

    @FXML
    private void actionSelecionarCidadeMouse(MouseEvent event) {
        String uf = this.cbUFComercial.getSelectionModel().getSelectedItem();
        if (null == uf) {
            System.out.println("null mesmo");
            Alerta a = new Alerta(2, "Estado não selecionado", "Selecione o Estado para carregar a lista de Cidades");
        } else {
            this.configuraCBCidadeComercial(uf, this.cbCidadeComercial);
        }
    }

    private void configuraCBCidadeComercial(String uf, ComboBox cb) {
        cb.getItems().clear();
        ArrayList<Cidade> c;
        for (Estado e : estados) {
            if (e.getUf().equalsIgnoreCase(uf)) {
                c = new ArrayList<>(e.getCidadeCollection());
                for (int i = 0; i < c.size(); i++) {
                    cb.getItems().add(c.get(i).getNome());
                }
            }
        }
    }

    @FXML
    private void actionSelecionarCidadeDomTeclado(KeyEvent event) {
        String uf = this.cbUFDomicilio.getSelectionModel().getSelectedItem();
        if (null == uf) {
            System.out.println("null mesmo");
            Alerta a = new Alerta(2, "Estado não selecionado", "Selecione o Estado para carregar a lista de Cidades");
        } else {
            this.configuraCBCidadeComercial(uf, this.cbDomicilio);
        }
    }

    @FXML
    private void actionSelecionarCidadeDomMouse(MouseEvent event) {
        String uf = this.cbUFDomicilio.getSelectionModel().getSelectedItem();
        if (null == uf) {
            System.out.println("null mesmo");
            Alerta a = new Alerta(2, "Estado não selecionado", "Selecione o Estado para carregar a lista de Cidades");
        } else {
            this.configuraCBCidadeComercial(uf, this.cbDomicilio);
        }
    }

    private String tipoAliquotaICMS(Integer tipoaliqicms) {
        if (tipoaliqicms == 1) {
            return this.cbContribuinte.getItems().get(0);
        } else {
            return this.cbContribuinte.getItems().get(1);
        }
    }

    private String carregaTipoCliente(String tipo) {
        if (tipo.equalsIgnoreCase("F")) {
            return "Física";
        } else {
            return "Jurídica";
        }
    }

    @FXML
    private void verificaSelecaoItem(KeyEvent event) {
        /* if(!this.tabelaClientes.getItems().isEmpty()) {
            Clientes cli = this.tabelaClientes.getSelectionModel().getSelectedItem();
            this.alterarBotaoAtivarInativar(cli);
        }*/
    }

    @FXML
    private void verificaClickItem(MouseEvent event) {
        if (!this.tabelaClientes.getItems().isEmpty()) {
            Clientes cli = this.tabelaClientes.getSelectionModel().getSelectedItem();
            this.alterarBotaoAtivarInativar(cli);
        }
        System.out.println("Clique duplo = " + (event.getClickCount() == 2));
        if (event.getClickCount() == 2) {
            System.out.println("Então entra aqui");
            configuraModoEdicao();
        }
    }

    private int maiorCodigoCli() {
        int max = 0;
        this.buscaClientes();
        for (Clientes c : clientes) {
            if(c.getCodpessoa() > max) {
                max = c.getCodpessoa();
            }
        }
        return max; 
    }
    
}
