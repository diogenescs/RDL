package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the lancamento database table.
 * 
 */
@Entity
public class Lancamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String automatico;

    @Temporal( TemporalType.DATE)
	private Date dataPgto;

    @Temporal( TemporalType.DATE)
	private Date dataVcto;

	private String despesa;

	private String nome;

	private String notificacao;

	private int numParcelas;

	private String realizado;

	private BigDecimal valorPgto;

	private BigDecimal valorVcto;
	
	

	//bi-directional many-to-one association to UsuarioProjeto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Usuario_Projeto")
	private UsuarioProjeto usuarioProjeto;

	//bi-directional many-to-one association to Frequencia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Frequencia")
	private Frequencia frequencia;

	//bi-directional many-to-one association to Categoria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to FormaDePgto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Forma_de_Pgto")
	private FormaDePgto formaDePgto;

	//bi-directional many-to-one association to Contato
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Contato")
	private Contato contato;

    public Lancamento() {
    	this.categoria = new Categoria();
    	this.frequencia = new Frequencia();
    	this.contato = new Contato();
    	this.formaDePgto = new FormaDePgto();
    	setDespesa("S");
    	setAutomatico("S");
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutomatico() {
		return this.automatico;
	}

	public void setAutomatico(String automatico) {
		this.automatico = automatico;
	}

	public Date getDataPgto() {
		return this.dataPgto;
	}

	public void setDataPgto(Date dataPgto) {
		this.dataPgto = dataPgto;
	}

	public Date getDataVcto() {
		return this.dataVcto;
	}

	public void setDataVcto(Date dataVcto) {
		this.dataVcto = dataVcto;
	}

	public String getDespesa() {
		return this.despesa;
	}

	public void setDespesa(String despesa) {
		this.despesa = despesa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNotificacao() {
		return this.notificacao;
	}

	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}

	public int getNumParcelas() {
		return this.numParcelas;
	}

	public void setNumParcelas(int numParcelas) {
		this.numParcelas = numParcelas;
	}

	public String getRealizado() {
		return this.realizado;
	}

	public void setRealizado(String realizado) {
		this.realizado = realizado;
	}

	public BigDecimal getValorPgto() {
		return this.valorPgto;
	}

	public void setValorPgto(BigDecimal valorPgto) {
		this.valorPgto = valorPgto;
	}

	public BigDecimal getValorVcto() {
		return this.valorVcto;
	}

	public void setValorVcto(BigDecimal valorVcto) {
		this.valorVcto = valorVcto;
	}

	public UsuarioProjeto getUsuarioProjeto() {
		return this.usuarioProjeto;
	}

	public void setUsuarioProjeto(UsuarioProjeto usuarioProjeto) {
		this.usuarioProjeto = usuarioProjeto;
	}
	
	public Frequencia getFrequencia() {
		return this.frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public FormaDePgto getFormaDePgto() {
		return this.formaDePgto;
	}

	public void setFormaDePgto(FormaDePgto formaDePgto) {
		this.formaDePgto = formaDePgto;
	}
	
	public Contato getContato() {
		return this.contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public void setRealizadoAsBoolean(boolean realizado){
		this.realizado = (realizado)?"S":"N";
	}
	public boolean getRealizadoAsBoolean(){
		return (this.realizado.equals("S"))?true:false;
	}
	
}