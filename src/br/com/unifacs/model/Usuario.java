package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String login;

	private String nome;

	private String senha;

	private String telMovel;
	
	private String pergunta;
	
	private String resposta;

	//bi-directional many-to-one association to UsuarioProjeto
	@OneToMany(mappedBy="usuario")
	private Set<UsuarioProjeto> usuarioProjetos;

    public Usuario() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelMovel() {
		return this.telMovel;
	}

	public void setTelMovel(String telMovel) {
		this.telMovel = telMovel;
	}

	public Set<UsuarioProjeto> getUsuarioProjetos() {
		return this.usuarioProjetos;
	}

	public void setUsuarioProjetos(Set<UsuarioProjeto> usuarioProjetos) {
		this.usuarioProjetos = usuarioProjetos;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
	
}