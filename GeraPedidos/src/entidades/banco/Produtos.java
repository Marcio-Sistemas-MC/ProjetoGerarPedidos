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
@Table(name = "produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p")
    , @NamedQuery(name = "Produtos.findByCodpro", query = "SELECT p FROM Produtos p WHERE p.codpro = :codpro")
    , @NamedQuery(name = "Produtos.findByDescricao", query = "SELECT p FROM Produtos p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Produtos.findByReferencia", query = "SELECT p FROM Produtos p WHERE p.referencia = :referencia")
    , @NamedQuery(name = "Produtos.findByApresentacao", query = "SELECT p FROM Produtos p WHERE p.apresentacao = :apresentacao")
    , @NamedQuery(name = "Produtos.findByUnidmed", query = "SELECT p FROM Produtos p WHERE p.unidmed = :unidmed")
    , @NamedQuery(name = "Produtos.findByQdEst", query = "SELECT p FROM Produtos p WHERE p.qdEst = :qdEst")
    , @NamedQuery(name = "Produtos.findByQdMax", query = "SELECT p FROM Produtos p WHERE p.qdMax = :qdMax")
    , @NamedQuery(name = "Produtos.findByPontopedido", query = "SELECT p FROM Produtos p WHERE p.pontopedido = :pontopedido")
    , @NamedQuery(name = "Produtos.findByQdPedido", query = "SELECT p FROM Produtos p WHERE p.qdPedido = :qdPedido")
    , @NamedQuery(name = "Produtos.findByPesobruto", query = "SELECT p FROM Produtos p WHERE p.pesobruto = :pesobruto")
    , @NamedQuery(name = "Produtos.findByPesoliq", query = "SELECT p FROM Produtos p WHERE p.pesoliq = :pesoliq")
    , @NamedQuery(name = "Produtos.findByCustocompra", query = "SELECT p FROM Produtos p WHERE p.custocompra = :custocompra")
    , @NamedQuery(name = "Produtos.findByUltimocus", query = "SELECT p FROM Produtos p WHERE p.ultimocus = :ultimocus")
    , @NamedQuery(name = "Produtos.findByMargem", query = "SELECT p FROM Produtos p WHERE p.margem = :margem")
    , @NamedQuery(name = "Produtos.findByPrecoVist", query = "SELECT p FROM Produtos p WHERE p.precoVist = :precoVist")
    , @NamedQuery(name = "Produtos.findByAcresfin", query = "SELECT p FROM Produtos p WHERE p.acresfin = :acresfin")
    , @NamedQuery(name = "Produtos.findByPrecoPraz", query = "SELECT p FROM Produtos p WHERE p.precoPraz = :precoPraz")
    , @NamedQuery(name = "Produtos.findByDataPreco", query = "SELECT p FROM Produtos p WHERE p.dataPreco = :dataPreco")
    , @NamedQuery(name = "Produtos.findByObs", query = "SELECT p FROM Produtos p WHERE p.obs = :obs")
    , @NamedQuery(name = "Produtos.findByFlaginativo", query = "SELECT p FROM Produtos p WHERE p.flaginativo = :flaginativo")
    , @NamedQuery(name = "Produtos.findByUltvendadta", query = "SELECT p FROM Produtos p WHERE p.ultvendadta = :ultvendadta")
    , @NamedQuery(name = "Produtos.findByUltvendaqtde", query = "SELECT p FROM Produtos p WHERE p.ultvendaqtde = :ultvendaqtde")
    , @NamedQuery(name = "Produtos.findByQtdeetiq", query = "SELECT p FROM Produtos p WHERE p.qtdeetiq = :qtdeetiq")
    , @NamedQuery(name = "Produtos.findByCodgtin", query = "SELECT p FROM Produtos p WHERE p.codgtin = :codgtin")
    , @NamedQuery(name = "Produtos.findByMedida", query = "SELECT p FROM Produtos p WHERE p.medida = :medida")
    , @NamedQuery(name = "Produtos.findByValidade", query = "SELECT p FROM Produtos p WHERE p.validade = :validade")
    , @NamedQuery(name = "Produtos.findByCodncm", query = "SELECT p FROM Produtos p WHERE p.codncm = :codncm")
    , @NamedQuery(name = "Produtos.findByDescricaocompleta", query = "SELECT p FROM Produtos p WHERE p.descricaocompleta = :descricaocompleta")
    , @NamedQuery(name = "Produtos.findByAliqnac", query = "SELECT p FROM Produtos p WHERE p.aliqnac = :aliqnac")
    , @NamedQuery(name = "Produtos.findByAliqimp", query = "SELECT p FROM Produtos p WHERE p.aliqimp = :aliqimp")
    , @NamedQuery(name = "Produtos.findByHoraPreco", query = "SELECT p FROM Produtos p WHERE p.horaPreco = :horaPreco")
    , @NamedQuery(name = "Produtos.findByUsuPreco", query = "SELECT p FROM Produtos p WHERE p.usuPreco = :usuPreco")
    , @NamedQuery(name = "Produtos.findByFlagretorno", query = "SELECT p FROM Produtos p WHERE p.flagretorno = :flagretorno")
    , @NamedQuery(name = "Produtos.findByCodtipo", query = "SELECT p FROM Produtos p WHERE p.codtipo = :codtipo")
    , @NamedQuery(name = "Produtos.findByQdPedcompra", query = "SELECT p FROM Produtos p WHERE p.qdPedcompra = :qdPedcompra")
    , @NamedQuery(name = "Produtos.findByCodcest", query = "SELECT p FROM Produtos p WHERE p.codcest = :codcest")})
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codpro")
    private Integer codpro;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "apresentacao")
    private String apresentacao;
    @Basic(optional = false)
    @Column(name = "unidmed")
    private String unidmed;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qd_est")
    private BigDecimal qdEst;
    @Column(name = "qd_max")
    private BigDecimal qdMax;
    @Column(name = "pontopedido")
    private BigDecimal pontopedido;
    @Column(name = "qd_pedido")
    private BigDecimal qdPedido;
    @Column(name = "pesobruto")
    private BigDecimal pesobruto;
    @Column(name = "pesoliq")
    private BigDecimal pesoliq;
    @Column(name = "custocompra")
    private BigDecimal custocompra;
    @Column(name = "ultimocus")
    private BigDecimal ultimocus;
    @Column(name = "margem")
    private BigDecimal margem;
    @Column(name = "preco_vist")
    private BigDecimal precoVist;
    @Column(name = "acresfin")
    private BigDecimal acresfin;
    @Column(name = "preco_praz")
    private BigDecimal precoPraz;
    @Column(name = "data_preco")
    @Temporal(TemporalType.DATE)
    private Date dataPreco;
    @Column(name = "obs")
    private String obs;
    @Column(name = "flaginativo")
    private String flaginativo;
    @Column(name = "ultvendadta")
    @Temporal(TemporalType.DATE)
    private Date ultvendadta;
    @Column(name = "ultvendaqtde")
    private BigDecimal ultvendaqtde;
    @Column(name = "qtdeetiq")
    private String qtdeetiq;
    @Column(name = "codgtin")
    private String codgtin;
    @Column(name = "medida")
    private String medida;
    @Column(name = "validade")
    private Integer validade;
    @Column(name = "codncm")
    private String codncm;
    @Column(name = "descricaocompleta")
    private String descricaocompleta;
    @Column(name = "aliqnac")
    private BigDecimal aliqnac;
    @Column(name = "aliqimp")
    private BigDecimal aliqimp;
    @Column(name = "hora_preco")
    @Temporal(TemporalType.TIME)
    private Date horaPreco;
    @Column(name = "usu_preco")
    private Integer usuPreco;
    @Column(name = "flagretorno")
    private String flagretorno;
    @Column(name = "codtipo")
    private Integer codtipo;
    @Column(name = "qd_pedcompra")
    private BigDecimal qdPedcompra;
    @Column(name = "codcest")
    private String codcest;

    public Produtos() {
    }

    public Produtos(Integer codpro) {
        this.codpro = codpro;
    }

    public Produtos(Integer codpro, String unidmed) {
        this.codpro = codpro;
        this.unidmed = unidmed;
    }

    public Integer getCodpro() {
        return codpro;
    }

    public void setCodpro(Integer codpro) {
        this.codpro = codpro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }

    public String getUnidmed() {
        return unidmed;
    }

    public void setUnidmed(String unidmed) {
        this.unidmed = unidmed;
    }

    public BigDecimal getQdEst() {
        return qdEst;
    }

    public void setQdEst(BigDecimal qdEst) {
        this.qdEst = qdEst;
    }

    public BigDecimal getQdMax() {
        return qdMax;
    }

    public void setQdMax(BigDecimal qdMax) {
        this.qdMax = qdMax;
    }

    public BigDecimal getPontopedido() {
        return pontopedido;
    }

    public void setPontopedido(BigDecimal pontopedido) {
        this.pontopedido = pontopedido;
    }

    public BigDecimal getQdPedido() {
        return qdPedido;
    }

    public void setQdPedido(BigDecimal qdPedido) {
        this.qdPedido = qdPedido;
    }

    public BigDecimal getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(BigDecimal pesobruto) {
        this.pesobruto = pesobruto;
    }

    public BigDecimal getPesoliq() {
        return pesoliq;
    }

    public void setPesoliq(BigDecimal pesoliq) {
        this.pesoliq = pesoliq;
    }

    public BigDecimal getCustocompra() {
        return custocompra;
    }

    public void setCustocompra(BigDecimal custocompra) {
        this.custocompra = custocompra;
    }

    public BigDecimal getUltimocus() {
        return ultimocus;
    }

    public void setUltimocus(BigDecimal ultimocus) {
        this.ultimocus = ultimocus;
    }

    public BigDecimal getMargem() {
        return margem;
    }

    public void setMargem(BigDecimal margem) {
        this.margem = margem;
    }

    public BigDecimal getPrecoVist() {
        return precoVist;
    }

    public void setPrecoVist(BigDecimal precoVist) {
        this.precoVist = precoVist;
    }

    public BigDecimal getAcresfin() {
        return acresfin;
    }

    public void setAcresfin(BigDecimal acresfin) {
        this.acresfin = acresfin;
    }

    public BigDecimal getPrecoPraz() {
        return precoPraz;
    }

    public void setPrecoPraz(BigDecimal precoPraz) {
        this.precoPraz = precoPraz;
    }

    public Date getDataPreco() {
        return dataPreco;
    }

    public void setDataPreco(Date dataPreco) {
        this.dataPreco = dataPreco;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getFlaginativo() {
        return flaginativo;
    }

    public void setFlaginativo(String flaginativo) {
        this.flaginativo = flaginativo;
    }

    public Date getUltvendadta() {
        return ultvendadta;
    }

    public void setUltvendadta(Date ultvendadta) {
        this.ultvendadta = ultvendadta;
    }

    public BigDecimal getUltvendaqtde() {
        return ultvendaqtde;
    }

    public void setUltvendaqtde(BigDecimal ultvendaqtde) {
        this.ultvendaqtde = ultvendaqtde;
    }

    public String getQtdeetiq() {
        return qtdeetiq;
    }

    public void setQtdeetiq(String qtdeetiq) {
        this.qtdeetiq = qtdeetiq;
    }

    public String getCodgtin() {
        return codgtin;
    }

    public void setCodgtin(String codgtin) {
        this.codgtin = codgtin;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Integer getValidade() {
        return validade;
    }

    public void setValidade(Integer validade) {
        this.validade = validade;
    }

    public String getCodncm() {
        return codncm;
    }

    public void setCodncm(String codncm) {
        this.codncm = codncm;
    }

    public String getDescricaocompleta() {
        return descricaocompleta;
    }

    public void setDescricaocompleta(String descricaocompleta) {
        this.descricaocompleta = descricaocompleta;
    }

    public BigDecimal getAliqnac() {
        return aliqnac;
    }

    public void setAliqnac(BigDecimal aliqnac) {
        this.aliqnac = aliqnac;
    }

    public BigDecimal getAliqimp() {
        return aliqimp;
    }

    public void setAliqimp(BigDecimal aliqimp) {
        this.aliqimp = aliqimp;
    }

    public Date getHoraPreco() {
        return horaPreco;
    }

    public void setHoraPreco(Date horaPreco) {
        this.horaPreco = horaPreco;
    }

    public Integer getUsuPreco() {
        return usuPreco;
    }

    public void setUsuPreco(Integer usuPreco) {
        this.usuPreco = usuPreco;
    }

    public String getFlagretorno() {
        return flagretorno;
    }

    public void setFlagretorno(String flagretorno) {
        this.flagretorno = flagretorno;
    }

    public Integer getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(Integer codtipo) {
        this.codtipo = codtipo;
    }

    public BigDecimal getQdPedcompra() {
        return qdPedcompra;
    }

    public void setQdPedcompra(BigDecimal qdPedcompra) {
        this.qdPedcompra = qdPedcompra;
    }

    public String getCodcest() {
        return codcest;
    }

    public void setCodcest(String codcest) {
        this.codcest = codcest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpro != null ? codpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.codpro == null && other.codpro != null) || (this.codpro != null && !this.codpro.equals(other.codpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.banco.Produtos[ codpro=" + codpro + " ]";
    }
    
}
