package br.com.unifacs.view;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.ContatoBo;
import br.com.unifacs.bo.ContatoBoImpl;
import br.com.unifacs.model.Contato;

@ManagedBean(name="contatoMb")
@SessionScoped
public class ContatoMb {
	
	private ContatoBo bo;
	private Contato contato;
	private List<Contato> contatos; 
	
	public ContatoMb() {
		this.contato = new Contato();
		this.bo = new ContatoBoImpl();
		this.setContatos(this.bo.obterTodos()); 
	}
	
	public void atualizar(ActionEvent actionEvent){
		this.setContatos(this.bo.obterTodos()); 	
	}
	
	public String novo(){
		this.contato = new Contato();
		return "novoContato";
	}
	
	public String editar(){ 
		if(this.contato == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione um contato", null));
			return null;
		}else{
			return "editarContato";
		}
	} 
	
	public String visualizar(){ 
		if(this.contato == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione um contato", null));
			return null;
		}else{
			return "visualizarContato";
		}
	} 
	
	public String excluir(){ 
		if(this.contato == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione um contato", null));
		}else{
			try {
				this.bo.excluir(contato);
				FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_WARN, "Item excluído com sucesso!", null));
				atualizar(null);
			} catch (BoException e) { 
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage("Erro ao excluir registro", e.getMessage()));
			} 
		}
		
		return null;
	} 
	
	public String salvar(){
		try {
			bo.salvar(contato);
			FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_WARN, "Operação realizada com sucesso!", "teste"));
			atualizar(null);
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		
		return "listaContato";
	}
	
	public String cancelar(){
		atualizar(null);
		return "listaContato";
	}
	
	/**
	 * @return the contato
	 */
	public Contato getContato() {
		return contato;
	}
	/**
	 * @param contato the contato to set
	 */
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	
	

}
