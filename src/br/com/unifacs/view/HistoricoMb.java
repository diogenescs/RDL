package br.com.unifacs.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.unifacs.bo.HistoricoBo;
import br.com.unifacs.bo.HistoricoBoImpl;
import br.com.unifacs.model.Historico;
import br.com.unifacs.utils.RdlUtils;

@ManagedBean(name="historicoMb")
@ViewScoped
public class HistoricoMb {

	private HistoricoBo bo;
	private Historico historico;
	private List<Historico> historicos; 
	
	public HistoricoMb() {
		this.historico = new Historico();
		this.bo = new HistoricoBoImpl();
		this.setHistoricos(this.bo.obterTodos(RdlUtils.getProjetoAtual())); 
	}

	
	public String visualizar(){ 
		if(this.historico == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Selecione um historico", null));
			return null;
		}else{
			return "visualizarHistorico";
		}
	} 
	

	/**
	 * @return the historico
	 */
	public Historico getHistorico() {
		return historico;
	}
	/**
	 * @param historico the historico to set
	 */
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

}
