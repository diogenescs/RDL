package br.com.unifacs.view;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.CategoriaBoImpl;
import br.com.unifacs.bo.ContatoBoImpl;
import br.com.unifacs.bo.FormaDePgtoBoImpl;
import br.com.unifacs.bo.FrequenciaBoImpl;
import br.com.unifacs.bo.LancamentoBo;
import br.com.unifacs.bo.LancamentoBoImpl;
import br.com.unifacs.bo.UsuarioBoImpl;
import br.com.unifacs.bo.UsuarioPojetoBoImpl;
import br.com.unifacs.model.Categoria;
import br.com.unifacs.model.Contato;
import br.com.unifacs.model.Lancamento;
import br.com.unifacs.model.UsuarioProjeto;

@ManagedBean(name="lancamentoMb")
@SessionScoped
public class LancamentoMb {
	
	private LancamentoBo bo;
	private Lancamento lancamento;
	private List<Lancamento> lancamentos;
	
	public LancamentoMb(){
		bo = new LancamentoBoImpl();
		setLancamento(new Lancamento());
		this.setLancamentos(this.bo.obterTodos());
	}
	
	public void atualizar(ActionEvent actionEvent){
		this.setLancamentos(this.bo.obterTodos()); 	
	}	

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Lancamento getLancamento() {
		return this.lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	public String novo(){
		this.lancamento = new Lancamento();
		atualizar(null);
		return "novoLancamento";
	}
	
	public String editar(){
		
		if(this.lancamento.getCategoria() == null)
			this.lancamento.setCategoria(new Categoria());
		
		if(this.lancamento.getContato() == null)
			this.lancamento.setContato(new Contato());		
		
		if(this.lancamento == null){
			FacesContext.getCurrentInstance().addMessage("Aten��o", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione uma lan�amento", null));
			return null;
		}else{
			return "editarLancamento";
		}		
	}
	
	public String excluir(){ 
		if(this.lancamento == null){
			FacesContext.getCurrentInstance().addMessage("Aten��o", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione um lan�amento", null));
		}else{
			try {
				this.bo.excluir(lancamento);
				FacesContext.getCurrentInstance().addMessage("Aten��o",  new FacesMessage(FacesMessage.SEVERITY_WARN, "Item exclu�do com sucesso!", null));
				atualizar(null);
			} catch (BoException e) { 
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage("Aten��o", new FacesMessage("Erro ao excluir registro", e.getMessage()));
			} 
		}
		
		return null;
	} 
	
	public String salvar(){
		try {
			UsuarioProjeto e = new UsuarioPojetoBoImpl().obter(2);
			this.lancamento.setUsuarioProjeto(e);
			this.lancamento.setContato(new ContatoBoImpl().obter(this.lancamento.getContato().getId()));
			this.lancamento.setCategoria(new CategoriaBoImpl().obter(this.lancamento.getCategoria().getId()));
			this.lancamento.setFormaDePgto(new FormaDePgtoBoImpl().obter(this.lancamento.getFormaDePgto().getId()));
			this.lancamento.setFrequencia(new FrequenciaBoImpl().obter(this.lancamento.getFrequencia().getId()));			
			bo.salvar(this.lancamento);
			FacesContext.getCurrentInstance().addMessage("Aten��o",  new FacesMessage(FacesMessage.SEVERITY_WARN, "Opera��o realizada com sucesso!", "teste"));
			atualizar(null);
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("Aten��o", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		
		return "listaLancamento";
	}	
	
	public String cancelar(){
		atualizar(null);
		return "listaLancamento";
	}
	
		
}
