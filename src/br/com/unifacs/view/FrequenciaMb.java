package br.com.unifacs.view;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.FrequenciaBo;
import br.com.unifacs.bo.FrequenciaBoImpl;
import br.com.unifacs.model.Frequencia;

@ManagedBean(name="frequenciaMb")
@SessionScoped
public class FrequenciaMb {
	
	private FrequenciaBo bo;
	private Frequencia frequencia;
	private List<Frequencia> frequencias; 
	
	public FrequenciaMb() {
		this.bo = new FrequenciaBoImpl();
		this.frequencia = new Frequencia();
		setFrequencias(bo.obterTodos());
	}
	
	public void atualizar(ActionEvent actionEvent){
		this.setFrequencias(this.bo.obterTodos()); 	
	}
	
	public String novo(){
		this.frequencia = new Frequencia();
		return "novaFrequencia";
	}
	
	public String editar(){ 
		if(this.frequencia == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione uma frequência", null));
			return null;
		}else{
			return "editarFrequencia";
		}
	} 
	
	public String excluir(){ 
		if(this.frequencia == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione uma Frequencia", null));
		}else{
			try {
				this.bo.excluir(frequencia);
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
			bo.salvar(frequencia);
			FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_WARN, "Operação realizada com sucesso!", "teste"));
			atualizar(null);
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		
		return "listaFrequencia";
	}
	
	public String cancelar(){
		atualizar(null);
		return "listaFrequencia";
	}
	

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public List<Frequencia> getFrequencias() {
		return this.frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}
}
