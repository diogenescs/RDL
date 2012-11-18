package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the projeto database table.
 * 
 */
@Entity
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descricao;

	//bi-directional many-to-one association to UsuarioProjeto
	@OneToMany(mappedBy="projeto")
	private Set<UsuarioProjeto> usuarioProjetos;
	
	//bi-directional many-to-one association to UsuarioProjeto
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="id_Usuario")
		private Usuario owner;

    public Projeto() {
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

	public Set<UsuarioProjeto> getUsuarioProjetos() {
		return this.usuarioProjetos;
	}

	public void setUsuarioProjetos(Set<UsuarioProjeto> usuarioProjetos) {
		this.usuarioProjetos = usuarioProjetos;
	}

	public Usuario getOwner() {
		return owner;
	}

	public void setOwner(Usuario owner) {
		this.owner = owner;
	}
	
	
	
}