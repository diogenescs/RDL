package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the frequencia database table.
 * 
 */
@Entity
public class Frequencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descricao;

	//bi-directional many-to-one association to Lancamento
	@OneToMany(mappedBy="frequencia")
	private Set<Lancamento> lancamentos;

    public Frequencia() {
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