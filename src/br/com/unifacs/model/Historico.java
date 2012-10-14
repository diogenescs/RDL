package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the historico database table.
 * 
 */
@Entity
public class Historico implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_alteracao")
	private Date dataAlteracao;

	@Column(name="hora_alteracao")
	private Time horaAlteracao;
	
	@Column(name="tipo_operacao")
	private String tipoOperacao;

	//bi-directional many-to-one association to Lancamento
	@ManyToOne
	@JoinColumn(name="id_lancamento")
	private Lancamento lancamento;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Historico() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataAlteracao() {
		return this.dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Time getHoraAlteracao() {
		return this.horaAlteracao;
	}

	public void setHoraAlteracao(Time horaAlteracao) {
		this.horaAlteracao = horaAlteracao;
	}

	public Lancamento getLancamento() {
		return this.lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

}