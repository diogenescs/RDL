package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the contato database table.
 * 
 */
@Entity
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String cidade;

	private String email;

	private String endereco;

	private String estado;

	private String infoAdicionais;

	private String nome;

	private String numDoc;

	private String telFixo;

	private String telMovel;


	//bi-directional many-to-one association to Lancamento
	@OneToMany(mappedBy="contato")
	private Set<Lancamento> lancamentos;

    public Contato() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInfoAdicionais() {
		return this.infoAdicionais;
	}

	public void setInfoAdicionais(String infoAdicionais) {
		this.infoAdicionais = infoAdicionais;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumDoc() {
		return this.numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getTelFixo() {
		return this.telFixo;
	}

	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}

	public String getTelMovel() {
		return this.telMovel;
	}

	public void setTelMovel(String telMovel) {
		this.telMovel = telMovel;
	}


	public Set<Lancamento> getLancamentos() {
		return this.lancamentos;
	}

	public void setLancamentos(Set<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	
}