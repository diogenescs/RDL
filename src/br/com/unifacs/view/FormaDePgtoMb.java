package br.com.unifacs.view;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.FormaDePgtoBo;
import br.com.unifacs.bo.FormaDePgtoBoImpl;
import br.com.unifacs.model.FormaDePgto;

@ManagedBean(name="formaDePgtoMb")
@SessionScoped
public class FormaDePgtoMb {
	private FormaDePgto formaDePgto;
	private FormaDePgtoBo bo;
	private List<FormaDePgto> formaDePgtos; 
	
	public FormaDePgtoMb() {
		this.formaDePgto = new FormaDePgto();
		this.bo = new FormaDePgtoBoImpl();
		this.setFormaDePgtos(this.bo.obterTodos()); 
	}
	
	public void atualizar(ActionEvent actionEvent){
		this.setFormaDePgtos(this.bo.obterTodos()); 	
	}
	
	public String novo(){
		this.formaDePgto = new FormaDePgto();
		return "novaFormaDePgto";
	}
	
	public String editar(){ 
		if(this.formaDePgto == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione uma forma de pagamento", null));
			return null;
		}else{
			return "editarFormaDePgto";
		}
	} 
	
	public String excluir(){ 
		if(this.formaDePgto == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione uma forma de pagamento", null));
		}else{
			try {
				this.bo.excluir(formaDePgto);
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
			bo.salvar(formaDePgto);
			FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_WARN, "Operação realizada com sucesso!", "teste"));
			atualizar(null);
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		
		return "listaFormaDePgto";
	}
	
	public String cancelar(){
		atualizar(null);
		return "listaFormaDePgto";
	}
	
	/**
	 * @return the formaDePgto
	 */
	public FormaDePgto getFormaDePgto() {
		return formaDePgto;
	}
	/**
	 * @param formaDePgto the formaDePgto to set
	 */
	public void setFormaDePgto(FormaDePgto formaDePgto) {
		this.formaDePgto = formaDePgto;
	}

	public List<FormaDePgto> getFormaDePgtos() {
		return formaDePgtos;
	}

	public void setFormaDePgtos(List<FormaDePgto> formaDePgtos) {
		this.formaDePgtos = formaDePgtos;
	}
	
	

		
}
