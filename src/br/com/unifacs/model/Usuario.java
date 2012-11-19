package br.com.unifacs.model;

import java.io.Serializable;
import javax.persistence.*;


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

	private String pergunta;

	private String resposta;

	private String senha;

	private String telMovel;

	//bi-directional many-to-one association to Notificacao
	@ManyToOne
	@JoinColumn(name="idnotificacao")
	private Notificacao notificacao;

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

	public String getPergunta() {
		return this.pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return this.resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
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

	public Notificacao getNotificacao() {
		return this.notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

}