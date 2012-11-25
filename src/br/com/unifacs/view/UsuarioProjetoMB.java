package br.com.unifacs.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.ProjetoBoImpl;
import br.com.unifacs.bo.UsuarioBoImpl;
import br.com.unifacs.bo.UsuarioProjetoBoImpl;
import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;
import br.com.unifacs.model.UsuarioProjeto;
import br.com.unifacs.utils.RdlUtils;

@SessionScoped
@ManagedBean(name="usuarioProjeto")

public class UsuarioProjetoMB {
	
	private Projeto projetoSelecionado;
	
	private int projetoSelecionadoId;

	private boolean bloqueado;
	private List<UsuarioProjeto> usuariosProjetos;
	private UsuarioProjetoBoImpl bo;
	private String emailPesquisa;
	private Usuario usuarioConvidado;
	private boolean enabledButton = false;
	
	public boolean isEnabledButton() {
		return enabledButton;
	}

	public void setEnabledButton(boolean enabledButton) {
		this.enabledButton = enabledButton;
	}

	public void buscarUsuario(ActionEvent e){
		this.usuarioConvidado = new UsuarioBoImpl().obterUsuaorioNaoPermitido(this.projetoSelecionado, this.emailPesquisa);
		atualizar(null);
		if(this.usuarioConvidado == null)
			FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Usuario não encontrado"));
	}
	
	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}


	
	public UsuarioProjetoMB() {
		bo = new UsuarioProjetoBoImpl();
		atualizar(null);
	}
	

	public List<Projeto> getProjetos() {
		return new ProjetoBoImpl().obterTodos(RdlUtils.getUsuarioLogado());
	}

	public void setProjetos(List<Projeto> projetos) {

	}
	
	public void salvar(ActionEvent e){
		UsuarioProjeto u = new UsuarioProjeto();
		String b;
		if(this.bloqueado)
			b = "S";
		else
			b = "N";
		u.setBlock(b);
		u.setUsuario(this.usuarioConvidado);
		u.setProjeto(this.projetoSelecionado);
		try {
			bo.salvar(u);
			FacesContext.getCurrentInstance().addMessage("Ok", new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario adicionado.", null));
			this.usuarioConvidado = null;
			atualizar(null);
		} catch (BoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public String getEmailPesquisa() {
		return emailPesquisa;
	}

	public void setEmailPesquisa(String emailPesquisa) {
		this.emailPesquisa = emailPesquisa;
	}

	public List<UsuarioProjeto> getUsuariosProjetos() {
		return usuariosProjetos;
	}

	public void setUsuariosProjetos(List<UsuarioProjeto> usuariosProjetos) {
		this.usuariosProjetos = usuariosProjetos;
	}
	
	public void atualizar(ActionEvent e){
		this.usuariosProjetos = bo.obterTodosPorProjeto(this.projetoSelecionado);
	}

	
	public Usuario getUsuarioConvidado() {
		return usuarioConvidado;
	}

	public void setUsuarioConvidado(Usuario usuarioConvidado) {
		this.usuarioConvidado = usuarioConvidado;
	}

	public int getProjetoSelecionadoId() {
		return projetoSelecionadoId;
	}

	public void setProjetoSelecionadoId(int projetoSelecionadoId) {
		this.projetoSelecionadoId = projetoSelecionadoId;
		this.projetoSelecionado = new ProjetoBoImpl().obter(projetoSelecionadoId);
	}

	public void change(ValueChangeEvent e){
		atualizar(null);
	}

}
