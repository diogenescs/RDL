package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descricao;

	//bi-directional many-to-one association to Lancamento
	@OneToMany(mappedBy="categoria")
	private Set<Lancamento> lancamentos;

    public Categoria() {
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

	public Set<Lancamento> getLancamentos() {
		return this.lancamentos;
	}

	public void setLancamentos(Set<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
}