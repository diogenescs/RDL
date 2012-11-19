package br.com.unifacs.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.NotificacaoBo;
import br.com.unifacs.bo.NotificacaoBoImpl;
import br.com.unifacs.model.Notificacao;
import br.com.unifacs.model.Usuario;
import br.com.unifacs.utils.RdlUtils;
@ManagedBean(name="notificacaoMb")
@SessionScoped
public class NotificacaoMb {
	
	private NotificacaoBo bo;
	private Notificacao notificacao;
	

	
	public NotificacaoMb() {
		this.notificacao = new Notificacao();
		this.bo = new NotificacaoBoImpl();
		//this.setProjetos(this.bo.obterTodos()); 
	}
	
	
	public String editar(){ 
		if(this.notificacao == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Selecione uma notificacao", null));
			return null;
		}else{
			return "editarNotificacao";
		}
	} 
	
	public String salvar(){
		try {
			bo.salvar(notificacao);
			FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso!", ""));
			//atualizar(null);
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Já existe notificacao com esse nome!", ""));
			return null;
		}
		
		return "visualizarNotificacao";
	}
	
	public String cancelar(){
		//atualizar(null);
		return "visualizarNotificacao";
	}
	
	/**
	 * @return the Notificacao
	 */
	public Notificacao getNotificacao() {
		notificacao = bo.obter(RdlUtils.getUsuarioLogado().getNotificacao().getId());
		return notificacao;
	}
	/**
	 * @param Notificacao the Notificacao to set
	 */
	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

	
	
	

}
