package br.com.unifacs.view;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.HistoricoBo;
import br.com.unifacs.bo.HistoricoBoImpl;
import br.com.unifacs.bo.LancamentoBo;
import br.com.unifacs.bo.LancamentoBoImpl;
import br.com.unifacs.model.Lancamento;

@ManagedBean(name="contaMb")
@SessionScoped
public class ContaMb {
	
	private LancamentoBo bo;
	private List<Lancamento> lancamentos;
	private HistoricoBo historicoBo;
	private Date dataInicial;
	private Date dataFinal;
	public ContaMb() {
		bo = new LancamentoBoImpl();
		historicoBo = new HistoricoBoImpl();
	}
	
	public void contasAPagar(ActionEvent e){
		
		if(this.dataInicial == null || this.dataFinal == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Informe o período.", null));
		} 
		
		try {
			this.lancamentos = bo.obterContasAPagar(this.dataInicial, this.dataFinal);
		} catch (BoException ex) {
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
			ex.printStackTrace();
		}
			
	}
	
	public void realizarLancamento(ActionEvent e){
		if (this.lancamentos == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione uma lançamento", null));
		}else{
			try {
				for(Lancamento l: this.lancamentos)
					bo.salvar(l);
				this.contasAPagar(null);
			} catch (BoException e1) {
				e1.printStackTrace();
				FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR, e1.getMessage(), null));
			}
		}
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

}
