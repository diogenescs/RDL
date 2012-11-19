package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the notificacao database table.
 * 
 */
@Entity
public class Notificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="num_dias_antes")
	private int numDiasAntes;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="notificacao")
	private List<Usuario> usuarios;

	public Notificacao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumDiasAntes() {
		return this.numDiasAntes;
	}

	public void setNumDiasAntes(int numDiasAntes) {
		this.numDiasAntes = numDiasAntes;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}