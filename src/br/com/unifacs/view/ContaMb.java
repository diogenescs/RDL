package br.com.unifacs.view;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.HistoricoBo;
import br.com.unifacs.bo.HistoricoBoImpl;
import br.com.unifacs.bo.LancamentoBo;
import br.com.unifacs.bo.LancamentoBoImpl;
import br.com.unifacs.model.Historico;
import br.com.unifacs.model.Lancamento;
import br.com.unifacs.utils.RdlUtils;

@ManagedBean(name="contaMb")
@ViewScoped
public class ContaMb {
   
    private LancamentoBo bo;
    private List<Lancamento> lancamentos;
    private HistoricoBo historicoBo;
    private Date dataInicial;
    private Date dataFinal;
    private String receitaOuDespesa = null;
    public ContaMb() {
        bo = new LancamentoBoImpl();
        historicoBo = new HistoricoBoImpl();
    }
   
   
    public void contasAPagar(ActionEvent e){
       
        if(this.dataInicial == null || this.dataFinal == null){
            FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Informe o período.", null));
        }
       
        try {
            this.lancamentos = bo.obterContasAPagar(this.dataInicial, this.dataFinal);
            receitaOuDespesa = "D";
        } catch (BoException ex) {
            FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
            ex.printStackTrace();
        }
           
    }
   
public void contasAReceber(ActionEvent e){
        if(this.dataInicial == null || this.dataFinal == null){
            FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Informe o período.", null));
        }
       
        try {
            this.lancamentos = bo.obterContasAReceber(this.dataInicial, this.dataFinal);
            receitaOuDespesa = "R";
        } catch (BoException ex) {
            FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
            ex.printStackTrace();
        }
           
    }

	public void pgtosEfetuados(ActionEvent e){
	    
	    if(this.dataInicial == null || this.dataFinal == null){
	        FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Informe o período.", null));
	    }
	   
	    try {
	        this.lancamentos = bo.obterPgtosEfetuados(this.dataInicial, this.dataFinal);
	        receitaOuDespesa = "D";
	    } catch (BoException ex) {
	        FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
	        ex.printStackTrace();
	    }
	       
	}
   
    public void realizarLancamento(ActionEvent e){
        if (this.lancamentos == null || this.lancamentos.size() == 0){
            FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Selecione uma lançamento", null));
        }else{
            try {
                for(Lancamento l: this.lancamentos){
                    bo.salvar(l);
                   
                    Historico historico = new Historico();
                    historico.setDataAlteracao(new Date());
                    historico.setHoraAlteracao(new Time(new Date().getTime()));
                    historico.setLancamento(l);
                    historico.setUsuario(RdlUtils.getUsuarioLogado());
                    historico.setTipoOperacao("Edição");   
                    historicoBo.salvar(historico);
                }
                
                if(receitaOuDespesa.equals("D"))
                	this.contasAPagar(null);
                else
                	this.contasAReceber(null);
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