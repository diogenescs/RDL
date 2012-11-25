package br.com.unifacs.view;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.UsuarioBoImpl;
import br.com.unifacs.bo.UsuarioBo;
import br.com.unifacs.model.Contato;
import br.com.unifacs.model.Usuario;
import br.com.unifacs.utils.RdlUtils;

@ManagedBean(name="usuarioMb")
@SessionScoped
public class UsuarioMb {
	
	private Usuario usuario;
	private List<Usuario> usuarios;
	private UsuarioBo bo;
	private String email;
	private String resposta;
	private String senha;
	private Usuario convidado;
	
	public UsuarioMb(){
		this.usuario = new Usuario();
		this.bo = new UsuarioBoImpl();
		this.setUsuarios(this.bo.obterTodos()); 
	}
		
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	} 
	
	
	public String getResposta() {
		return resposta;
	}


	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Usuario getConvidado() {
		return convidado;
	}


	public void setConvidado(Usuario convidado) {
		this.convidado = convidado;
	}


	public void atualizar(ActionEvent actionEvent){
		this.setUsuarios(this.bo.obterTodos()); 	
	}
	
	public String visualizar(){ 
		
		if(this.usuario == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Selecione um usuario", null));
			return null;
		}else{
			return "visualizarUsuario";
		}
	}
	
	public String visualizarSenha(){ 
			usuario = RdlUtils.getUsuarioLogado();
		    senha = usuario.getSenha();
			return "visualizarSenha";
		
	}
	
	
	public String novo(){
		this.usuario = new Usuario();
		return "editarUsuario";
	}
	
	public void insert(ActionEvent actionEvent){
		this.usuario = new Usuario();
	}
	
	public String editar(){ 
		if(this.usuario == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Selecione um Usuario", null));
			return null;
		}else{
			return "editarUsuario";
		}
	} 
	
	public String editarSenha(){ 
		
			return "editarSenhaUsuario";
		
	} 
	
	
	public String excluir(){ 
		if(this.usuario == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Selecione um Usuario", null));
		}else{
			try {
				this.bo.excluir(usuario);
				FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_INFO, "Item excluído com sucesso!", null));
				atualizar(null);
			} catch (BoException e) { 
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro ao excluir registro", e.getMessage()));
			} 
		}
		
		return null;
	} 
	
	public String salvar(){
		try {
			bo.salvar(usuario);
			FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso!", "teste"));
			atualizar(null);
			return "visualizarUsuario";
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		
		return null;
	}
	
	public String salvarNovaSenha(){
		try {
			Usuario usuarioAux = RdlUtils.getUsuarioLogado();
			usuarioAux.setSenha(usuario.getSenha());
			bo.salvar(usuarioAux);
			FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso!", "teste"));
			atualizar(null);
			return "visualizarSenha";
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		
		return null;
	}
	
	public String cancelar(){
		atualizar(null);
		return "novoLogin";
	}
	
	public String cancelarAlteracaoSenha(){
		atualizar(null);
		return "visualizarSenha";
	}
	
	public void buscarUsuario(ActionEvent e){
	    
	    if(this.email == null){
	        FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Informe o email.", null));
	    }else{
		    try {
		        this.convidado = bo.BuscarUsuario(this.email);
		    } catch (BoException ex) {
		        FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
		        ex.printStackTrace();
		    }
	    }  
	       
	}
	
	public void adicionarUsuario(ActionEvent e){
	    
	    if(this.email == null){
	        FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Informe o email.", null));
	    }else{
		    try {
		        this.usuario = bo.BuscarUsuario(this.email);
		    } catch (BoException ex) {
		        FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
		        ex.printStackTrace();
		    }
	    }  
	       
	}
	
	
}
