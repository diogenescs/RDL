package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the orcamento database table.
 * 
 */
@Entity
public class Orcamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

    @Temporal( TemporalType.DATE)
	private Date dataFinal;

    @Temporal( TemporalType.DATE)
	private Date dataInicial;

	private String nome;

	private BigDecimal valorDespesa;

	private BigDecimal valorReceita;

	//bi-directional many-to-one association to UsuarioProjeto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Usuario_Projeto")
	private UsuarioProjeto usuarioProjeto;

    public Orcamento() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataFinal() {
		return this.dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataInicial() {
		return this.dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorDespesa() {
		return this.valorDespesa;
	}

	public void setValorDespesa(BigDecimal valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public BigDecimal getValorReceita() {
		return this.valorReceita;
	}

	public void setValorReceita(BigDecimal valorReceita) {
		this.valorReceita = valorReceita;
	}

	public UsuarioProjeto getUsuarioProjeto() {
		return this.usuarioProjeto;
	}

	public void setUsuarioProjeto(UsuarioProjeto usuarioProjeto) {
		this.usuarioProjeto = usuarioProjeto;
	}
	
}