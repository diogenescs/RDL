package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the forma_de_pgto database table.
 * 
 */
@Entity
@Table(name="forma_de_pgto")
public class FormaDePgto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descricao;

	private String sigla;

	//bi-directional many-to-one association to Lancamento
	@OneToMany(mappedBy="formaDePgto")
	private Set<Lancamento> lancamentos;

    public FormaDePgto() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Set<Lancamento> getLancamentos() {
		return this.lancamentos;
	}

	public void setLancamentos(Set<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
}