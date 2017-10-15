/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.banco;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByCodpessoa", query = "SELECT c FROM Clientes c WHERE c.codpessoa = :codpessoa")
    , @NamedQuery(name = "Clientes.findByNome", query = "SELECT c FROM Clientes c WHERE c.nome = :nome")
    , @NamedQuery(name = "Clientes.findByUppernome", query = "SELECT c FROM Clientes c WHERE c.uppernome = :uppernome")
    , @NamedQuery(name = "Clientes.findByDtaAdmissao", query = "SELECT c FROM Clientes c WHERE c.dtaAdmissao = :dtaAdmissao")
    , @NamedQuery(name = "Clientes.findByTipo", query = "SELECT c FROM Clientes c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Clientes.findByRazaosocial", query = "SELECT c FROM Clientes c WHERE c.razaosocial = :razaosocial")
    , @NamedQuery(name = "Clientes.findByCnpj", query = "SELECT c FROM Clientes c WHERE c.cnpj = :cnpj")
    , @NamedQuery(name = "Clientes.findByInscest", query = "SELECT c FROM Clientes c WHERE c.inscest = :inscest")
    , @NamedQuery(name = "Clientes.findBySocio1", query = "SELECT c FROM Clientes c WHERE c.socio1 = :socio1")
    , @NamedQuery(name = "Clientes.findBySocio2", query = "SELECT c FROM Clientes c WHERE c.socio2 = :socio2")
    , @NamedQuery(name = "Clientes.findBySocio3", query = "SELECT c FROM Clientes c WHERE c.socio3 = :socio3")
    , @NamedQuery(name = "Clientes.findByCpf", query = "SELECT c FROM Clientes c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Clientes.findByRg", query = "SELECT c FROM Clientes c WHERE c.rg = :rg")
    , @NamedQuery(name = "Clientes.findByInscprodutor", query = "SELECT c FROM Clientes c WHERE c.inscprodutor = :inscprodutor")
    , @NamedQuery(name = "Clientes.findByEstadoCiv", query = "SELECT c FROM Clientes c WHERE c.estadoCiv = :estadoCiv")
    , @NamedQuery(name = "Clientes.findByApelido", query = "SELECT c FROM Clientes c WHERE c.apelido = :apelido")
    , @NamedQuery(name = "Clientes.findByNaturalidade", query = "SELECT c FROM Clientes c WHERE c.naturalidade = :naturalidade")
    , @NamedQuery(name = "Clientes.findByDataNasc", query = "SELECT c FROM Clientes c WHERE c.dataNasc = :dataNasc")
    , @NamedQuery(name = "Clientes.findByConjuge", query = "SELECT c FROM Clientes c WHERE c.conjuge = :conjuge")
    , @NamedQuery(name = "Clientes.findByFiliacaoPai", query = "SELECT c FROM Clientes c WHERE c.filiacaoPai = :filiacaoPai")
    , @NamedQuery(name = "Clientes.findByFiliacaoMae", query = "SELECT c FROM Clientes c WHERE c.filiacaoMae = :filiacaoMae")
    , @NamedQuery(name = "Clientes.findByLocaltrabalho", query = "SELECT c FROM Clientes c WHERE c.localtrabalho = :localtrabalho")
    , @NamedQuery(name = "Clientes.findByTelefonetrabalho", query = "SELECT c FROM Clientes c WHERE c.telefonetrabalho = :telefonetrabalho")
    , @NamedQuery(name = "Clientes.findByRenda", query = "SELECT c FROM Clientes c WHERE c.renda = :renda")
    , @NamedQuery(name = "Clientes.findByLograCom", query = "SELECT c FROM Clientes c WHERE c.lograCom = :lograCom")
    , @NamedQuery(name = "Clientes.findByNumCom", query = "SELECT c FROM Clientes c WHERE c.numCom = :numCom")
    , @NamedQuery(name = "Clientes.findByComplCom", query = "SELECT c FROM Clientes c WHERE c.complCom = :complCom")
    , @NamedQuery(name = "Clientes.findByBairro", query = "SELECT c FROM Clientes c WHERE c.bairro = :bairro")
    , @NamedQuery(name = "Clientes.findByCodcidade", query = "SELECT c FROM Clientes c WHERE c.codcidade = :codcidade")
    , @NamedQuery(name = "Clientes.findByCep", query = "SELECT c FROM Clientes c WHERE c.cep = :cep")
    , @NamedQuery(name = "Clientes.findByLograDom", query = "SELECT c FROM Clientes c WHERE c.lograDom = :lograDom")
    , @NamedQuery(name = "Clientes.findByNumDom", query = "SELECT c FROM Clientes c WHERE c.numDom = :numDom")
    , @NamedQuery(name = "Clientes.findByComplDom", query = "SELECT c FROM Clientes c WHERE c.complDom = :complDom")
    , @NamedQuery(name = "Clientes.findByBairrodom", query = "SELECT c FROM Clientes c WHERE c.bairrodom = :bairrodom")
    , @NamedQuery(name = "Clientes.findByCodcidadedom", query = "SELECT c FROM Clientes c WHERE c.codcidadedom = :codcidadedom")
    , @NamedQuery(name = "Clientes.findByCepdom", query = "SELECT c FROM Clientes c WHERE c.cepdom = :cepdom")
    , @NamedQuery(name = "Clientes.findByAtivo", query = "SELECT c FROM Clientes c WHERE c.ativo = :ativo")
    , @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email")
    , @NamedQuery(name = "Clientes.findByTelefone", query = "SELECT c FROM Clientes c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Clientes.findByCelular", query = "SELECT c FROM Clientes c WHERE c.celular = :celular")
    , @NamedQuery(name = "Clientes.findByPessoacontato", query = "SELECT c FROM Clientes c WHERE c.pessoacontato = :pessoacontato")
    , @NamedQuery(name = "Clientes.findByTipoaliqicms", query = "SELECT c FROM Clientes c WHERE c.tipoaliqicms = :tipoaliqicms")
    , @NamedQuery(name = "Clientes.findByObservacao", query = "SELECT c FROM Clientes c WHERE c.observacao = :observacao")
    , @NamedQuery(name = "Clientes.findByInclusaousuario", query = "SELECT c FROM Clientes c WHERE c.inclusaousuario = :inclusaousuario")
    , @NamedQuery(name = "Clientes.findByInclusaohorario", query = "SELECT c FROM Clientes c WHERE c.inclusaohorario = :inclusaohorario")
    , @NamedQuery(name = "Clientes.findByAlteracaousuario", query = "SELECT c FROM Clientes c WHERE c.alteracaousuario = :alteracaousuario")
    , @NamedQuery(name = "Clientes.findByAlteracaohorario", query = "SELECT c FROM Clientes c WHERE c.alteracaohorario = :alteracaohorario")
    , @NamedQuery(name = "Clientes.findByUltvenda", query = "SELECT c FROM Clientes c WHERE c.ultvenda = :ultvenda")
    , @NamedQuery(name = "Clientes.findByProftrabalho", query = "SELECT c FROM Clientes c WHERE c.proftrabalho = :proftrabalho")
    , @NamedQuery(name = "Clientes.findByDtaAdmtrabalho", query = "SELECT c FROM Clientes c WHERE c.dtaAdmtrabalho = :dtaAdmtrabalho")
    , @NamedQuery(name = "Clientes.findByAtrasodias", query = "SELECT c FROM Clientes c WHERE c.atrasodias = :atrasodias")
    , @NamedQuery(name = "Clientes.findByAtrasovalor", query = "SELECT c FROM Clientes c WHERE c.atrasovalor = :atrasovalor")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codpessoa")
    private Integer codpessoa;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "uppernome")
    private String uppernome;
    @Column(name = "dta_admissao")
    @Temporal(TemporalType.DATE)
    private Date dtaAdmissao;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "razaosocial")
    private String razaosocial;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "inscest")
    private String inscest;
    @Column(name = "socio1")
    private String socio1;
    @Column(name = "socio2")
    private String socio2;
    @Column(name = "socio3")
    private String socio3;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "inscprodutor")
    private String inscprodutor;
    @Column(name = "estado_civ")
    private String estadoCiv;
    @Column(name = "apelido")
    private String apelido;
    @Column(name = "naturalidade")
    private String naturalidade;
    @Column(name = "data_nasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Column(name = "conjuge")
    private String conjuge;
    @Column(name = "filiacao_pai")
    private String filiacaoPai;
    @Column(name = "filiacao_mae")
    private String filiacaoMae;
    @Column(name = "localtrabalho")
    private String localtrabalho;
    @Column(name = "telefonetrabalho")
    private String telefonetrabalho;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "renda")
    private BigDecimal renda;
    @Column(name = "logra_com")
    private String lograCom;
    @Column(name = "num_com")
    private String numCom;
    @Column(name = "compl_com")
    private String complCom;
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "codcidade")
    private int codcidade;
    @Column(name = "cep")
    private String cep;
    @Column(name = "logra_dom")
    private String lograDom;
    @Column(name = "num_dom")
    private String numDom;
    @Column(name = "compl_dom")
    private String complDom;
    @Column(name = "bairrodom")
    private String bairrodom;
    @Column(name = "codcidadedom")
    private Integer codcidadedom;
    @Column(name = "cepdom")
    private String cepdom;
    @Column(name = "ativo")
    private String ativo;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "pessoacontato")
    private String pessoacontato;
    @Column(name = "tipoaliqicms")
    private Integer tipoaliqicms;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "inclusaousuario")
    private Integer inclusaousuario;
    @Column(name = "inclusaohorario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inclusaohorario;
    @Column(name = "alteracaousuario")
    private Integer alteracaousuario;
    @Column(name = "alteracaohorario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alteracaohorario;
    @Column(name = "ultvenda")
    @Temporal(TemporalType.DATE)
    private Date ultvenda;
    @Column(name = "proftrabalho")
    private String proftrabalho;
    @Column(name = "dta_admtrabalho")
    @Temporal(TemporalType.DATE)
    private Date dtaAdmtrabalho;
    @Column(name = "atrasodias")
    private BigDecimal atrasodias;
    @Column(name = "atrasovalor")
    private BigDecimal atrasovalor;

    public Clientes() {
    }

    public Clientes(Integer codpessoa) {
        this.codpessoa = codpessoa;
    }

    public Clientes(Integer codpessoa, String nome, String uppernome, String tipo, int codcidade) {
        this.codpessoa = codpessoa;
        this.nome = nome;
        this.uppernome = uppernome;
        this.tipo = tipo;
        this.codcidade = codcidade;
    }

    public Integer getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(Integer codpessoa) {
        this.codpessoa = codpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUppernome() {
        return uppernome;
    }

    public void setUppernome(String uppernome) {
        this.uppernome = uppernome;
    }

    public Date getDtaAdmissao() {
        return dtaAdmissao;
    }

    public void setDtaAdmissao(Date dtaAdmissao) {
        this.dtaAdmissao = dtaAdmissao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscest() {
        return inscest;
    }

    public void setInscest(String inscest) {
        this.inscest = inscest;
    }

    public String getSocio1() {
        return socio1;
    }

    public void setSocio1(String socio1) {
        this.socio1 = socio1;
    }

    public String getSocio2() {
        return socio2;
    }

    public void setSocio2(String socio2) {
        this.socio2 = socio2;
    }

    public String getSocio3() {
        return socio3;
    }

    public void setSocio3(String socio3) {
        this.socio3 = socio3;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getInscprodutor() {
        return inscprodutor;
    }

    public void setInscprodutor(String inscprodutor) {
        this.inscprodutor = inscprodutor;
    }

    public String getEstadoCiv() {
        return estadoCiv;
    }

    public void setEstadoCiv(String estadoCiv) {
        this.estadoCiv = estadoCiv;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public String getFiliacaoPai() {
        return filiacaoPai;
    }

    public void setFiliacaoPai(String filiacaoPai) {
        this.filiacaoPai = filiacaoPai;
    }

    public String getFiliacaoMae() {
        return filiacaoMae;
    }

    public void setFiliacaoMae(String filiacaoMae) {
        this.filiacaoMae = filiacaoMae;
    }

    public String getLocaltrabalho() {
        return localtrabalho;
    }

    public void setLocaltrabalho(String localtrabalho) {
        this.localtrabalho = localtrabalho;
    }

    public String getTelefonetrabalho() {
        return telefonetrabalho;
    }

    public void setTelefonetrabalho(String telefonetrabalho) {
        this.telefonetrabalho = telefonetrabalho;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public String getLograCom() {
        return lograCom;
    }

    public void setLograCom(String lograCom) {
        this.lograCom = lograCom;
    }

    public String getNumCom() {
        return numCom;
    }

    public void setNumCom(String numCom) {
        this.numCom = numCom;
    }

    public String getComplCom() {
        return complCom;
    }

    public void setComplCom(String complCom) {
        this.complCom = complCom;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(int codcidade) {
        this.codcidade = codcidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLograDom() {
        return lograDom;
    }

    public void setLograDom(String lograDom) {
        this.lograDom = lograDom;
    }

    public String getNumDom() {
        return numDom;
    }

    public void setNumDom(String numDom) {
        this.numDom = numDom;
    }

    public String getComplDom() {
        return complDom;
    }

    public void setComplDom(String complDom) {
        this.complDom = complDom;
    }

    public String getBairrodom() {
        return bairrodom;
    }

    public void setBairrodom(String bairrodom) {
        this.bairrodom = bairrodom;
    }

    public Integer getCodcidadedom() {
        return codcidadedom;
    }

    public void setCodcidadedom(Integer codcidadedom) {
        this.codcidadedom = codcidadedom;
    }

    public String getCepdom() {
        return cepdom;
    }

    public void setCepdom(String cepdom) {
        this.cepdom = cepdom;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPessoacontato() {
        return pessoacontato;
    }

    public void setPessoacontato(String pessoacontato) {
        this.pessoacontato = pessoacontato;
    }

    public Integer getTipoaliqicms() {
        return tipoaliqicms;
    }

    public void setTipoaliqicms(Integer tipoaliqicms) {
        this.tipoaliqicms = tipoaliqicms;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getInclusaousuario() {
        return inclusaousuario;
    }

    public void setInclusaousuario(Integer inclusaousuario) {
        this.inclusaousuario = inclusaousuario;
    }

    public Date getInclusaohorario() {
        return inclusaohorario;
    }

    public void setInclusaohorario(Date inclusaohorario) {
        this.inclusaohorario = inclusaohorario;
    }

    public Integer getAlteracaousuario() {
        return alteracaousuario;
    }

    public void setAlteracaousuario(Integer alteracaousuario) {
        this.alteracaousuario = alteracaousuario;
    }

    public Date getAlteracaohorario() {
        return alteracaohorario;
    }

    public void setAlteracaohorario(Date alteracaohorario) {
        this.alteracaohorario = alteracaohorario;
    }

    public Date getUltvenda() {
        return ultvenda;
    }

    public void setUltvenda(Date ultvenda) {
        this.ultvenda = ultvenda;
    }

    public String getProftrabalho() {
        return proftrabalho;
    }

    public void setProftrabalho(String proftrabalho) {
        this.proftrabalho = proftrabalho;
    }

    public Date getDtaAdmtrabalho() {
        return dtaAdmtrabalho;
    }

    public void setDtaAdmtrabalho(Date dtaAdmtrabalho) {
        this.dtaAdmtrabalho = dtaAdmtrabalho;
    }

    public BigDecimal getAtrasodias() {
        return atrasodias;
    }

    public void setAtrasodias(BigDecimal atrasodias) {
        this.atrasodias = atrasodias;
    }

    public BigDecimal getAtrasovalor() {
        return atrasovalor;
    }

    public void setAtrasovalor(BigDecimal atrasovalor) {
        this.atrasovalor = atrasovalor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpessoa != null ? codpessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codpessoa == null && other.codpessoa != null) || (this.codpessoa != null && !this.codpessoa.equals(other.codpessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codpessoa + " - " + this.nome + "\n Tipo: " + this.tipo + " Ativo: " + this.ativo +
                "\n Tipo Contribuinte: " + this.tipoaliqicms; 
    }
    
}
