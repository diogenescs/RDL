package br.com.unifacs.view;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext; 
import javax.faces.el.ValueBinding;

import org.hibernate.exception.ConstraintViolationException;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.CategoriaBo;
import br.com.unifacs.bo.CategoriaBoImpl;
import br.com.unifacs.bo.ProjetoBo;
import br.com.unifacs.bo.ProjetoBoImpl;
import br.com.unifacs.bo.UsuarioProjetoBoImpl;
import br.com.unifacs.model.Categoria;
import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;
import br.com.unifacs.model.UsuarioProjeto;
import br.com.unifacs.utils.RdlUtils;
@ManagedBean(name="projetoMb")
@SessionScoped
public class ProjetoMb {
	
	private ProjetoBo bo;
	private Projeto projeto;
	private List<Projeto> projetos;
	private int idProjetoAtual;
	
	public ProjetoMb() {
		this.projeto = new Projeto();
		this.bo = new ProjetoBoImpl();
		this.setProjetos(RdlUtils.getListaProjeto()); 
	}
	
	public void atualizar(ActionEvent actionEvent){
		List<Projeto> projetos = new UsuarioProjetoBoImpl().obterTodos(RdlUtils.getUsuarioLogado());
		RdlUtils.setListaProjeto(projetos);		
		this.setProjetos(RdlUtils.getListaProjeto()); 	
	}
	
	public String novo(){
		this.projeto = new Projeto();
		return "novoProjeto";
	}
	
	public String editar(){ 
		if(this.projeto == null){
			FacesContext.getCurrentInstance().addMessage("Aten��o", new FacesMessage(FacesMessage.SEVERITY_WARN,"Selecione um projeto", null));
			return null;
		}else{
			return "editarProjeto";
		}
	} 
	
	public String excluir(){ 
		if(this.projeto == null){
			FacesContext.getCurrentInstance().addMessage("Aten��o", new FacesMessage(FacesMessage.SEVERITY_WARN,"Selecione um projeto", null));
		}else{
			try {
				this.bo.excluir(projeto);
				FacesContext.getCurrentInstance().addMessage("Aten��o",  new FacesMessage(FacesMessage.SEVERITY_INFO, "Item exclu�do com sucesso!", null));
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
			
			boolean novo = true;
			if(projeto.getId() != 0){
				novo = false;
				if(projeto.getOwner().getId() != RdlUtils.getUsuarioLogado().getId()){
					FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Voc� n�o tem permiss�o para alterar esse projeto.", ""));
					return null;
				}
			}
			
			projeto.setOwner(RdlUtils.getUsuarioLogado());
			
			bo.salvar(projeto);
			if(novo){
				UsuarioProjeto u = new UsuarioProjeto();
				u.setBlock("N");
				u.setProjeto(projeto);
				u.setUsuario(RdlUtils.getUsuarioLogado());
				new UsuarioProjetoBoImpl().salvar(u);
			}
			FacesContext.getCurrentInstance().addMessage("Aten��o",  new FacesMessage(FacesMessage.SEVERITY_INFO, "Opera��o realizada com sucesso!", ""));
			atualizar(null);
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("Erro", new FacesMessage(FacesMessage.SEVERITY_ERROR,"J� existe projeto com esse nome!", ""));
			return null;
		}
		
		return "listaProjeto";
	}
	
	public String cancelar(){
		atualizar(null);
		return "listaProjeto";
	}
	
	/**
	 * @return the projeto
	 */
	public Projeto getProjeto() {
		return projeto;
	}
	/**
	 * @param projeto the projeto to set
	 */
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Projeto> getProjetos() {
		return projetos; 
}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Projeto> getProjetosUsuarioAtual() {
		return RdlUtils.getListaProjeto();
	}

	public void setProjetosUsuarioAtual(List<Projeto> projetosUsuarioAtual) {
		
	}

	public Projeto getProjetoAtual() {
		return RdlUtils.getProjetoAtual();
	}

	public void setProjetoAtual(Projeto projetoAtual) {
		RdlUtils.setProjetoAtual(projetoAtual);
	}

	public int getIdProjetoAtual() {
		return idProjetoAtual;
	}

	public void setIdProjetoAtual(int idProjetoAtual) {
		this.idProjetoAtual = idProjetoAtual;
		this.setProjetoAtual(new ProjetoBoImpl().obter(idProjetoAtual));
		FacesContext ctx = FacesContext.getCurrentInstance();
		Application app = ctx.getApplication();
		ValueBinding bind = app.createValueBinding("#{lancamentoMb}");
		LancamentoMb bean = (LancamentoMb) bind.getValue(ctx);
		bean.atualizar(null);		
	}
	
	public String escolherProjeto(){
		return "grafico";
	}
	
	

}
