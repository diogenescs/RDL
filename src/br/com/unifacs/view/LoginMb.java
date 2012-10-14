package br.com.unifacs.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.UsuarioBo;
import br.com.unifacs.bo.UsuarioBoImpl;
import br.com.unifacs.model.Usuario;
import br.com.unifacs.utils.RdlUtils;

@ManagedBean(name="loginMb")
@SessionScoped
public class LoginMb {

	private UsuarioBo usuarioBo;
	private String senha;
	private String login;
	
	public LoginMb() {
		usuarioBo = new UsuarioBoImpl();
	}
	
	
	public String login(){
		try {
			Usuario u = usuarioBo.Logar(this.login, this.senha);
			if (u == null){
			   FacesContext.getCurrentInstance().addMessage("Aten��o", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usu�rio ou Senha inv�lido",null));
			   return null;
			}
			else{
			   RdlUtils.login(u);
				return "novoLancamento";
			}
		} catch (BoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}