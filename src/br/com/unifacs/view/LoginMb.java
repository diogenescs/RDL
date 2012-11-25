package br.com.unifacs.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.UsuarioBo;
import br.com.unifacs.bo.UsuarioBoImpl;
import br.com.unifacs.bo.UsuarioProjetoBoImpl;
import br.com.unifacs.model.Projeto;
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
			   FacesContext.getCurrentInstance().addMessage("Aten��o", new FacesMessage(FacesMessage.SEVERITY_WARN,"Usu�rio ou Senha inv�lido",null));
			   return null;
			}
			else{
			   
			   RdlUtils.login(u);
			   List<Projeto> projetos = new UsuarioProjetoBoImpl().obterTodos(u);
			   RdlUtils.setListaProjeto(projetos);
			   return "workspaceProjetos";
			}
		} catch (BoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioAtual");
		RdlUtils.logout();
		return "novoLogin";
		
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
