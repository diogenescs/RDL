package br.com.unifacs.view;

import javax.faces.event.ActionEvent;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.CategoriaBo;
import br.com.unifacs.bo.CategoriaBoImpl;
import br.com.unifacs.model.Categoria;

@ManagedBean(name="categoriaMb")
@SessionScoped
public class CategoriaMb {
	
	private CategoriaBo bo;
	private Categoria categoria;
	private List<Categoria> categorias; 
	
	public CategoriaMb() {
		this.categoria = new Categoria();
		this.bo = new CategoriaBoImpl();
		this.setCategorias(this.bo.obterTodos()); 
	}
	
	public void atualizar(ActionEvent actionEvent){
		this.setCategorias(this.bo.obterTodos()); 	
	}
	
	public String novo(){
		this.categoria = new Categoria();
		return "novaCategoria";
	}
	
	public void insert(ActionEvent event){
		this.categoria = new Categoria();
	}
	
	public void post(ActionEvent event){
		try {
			bo.salvar(categoria);
			FacesContext.getCurrentInstance().addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso!", "teste"));
			atualizar(null);
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}	
	
	public String editar(){ 
		if(this.categoria == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione uma categoria", null));
			return null;
		}else{
			return "editarCategoria";
		}
	} 
	
	public String excluir(){ 
		if(this.categoria == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Selecione uma categoria", null));
		}else{
			try {
				this.bo.excluir(categoria);
				FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_INFO, "Item excluído com sucesso!", null));
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
			bo.salvar(categoria);
			FacesContext.getCurrentInstance().addMessage("Atenção",  new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso!", "teste"));
			atualizar(null);
		} catch (BoException e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		
		return "listaCategoria";
	}
	
	public String cancelar(){
		atualizar(null);
		return "listaCategoria";
	}
	
	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	

}
