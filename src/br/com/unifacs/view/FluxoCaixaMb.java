package br.com.unifacs.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.unifacs.dao.CustomQueryDao;
import br.com.unifacs.dao.DaoException;
import br.com.unifacs.utils.RdlUtils;

@SessionScoped
@ManagedBean(name="fluxoCaixa")
public class FluxoCaixaMb implements Serializable{

	private int ano;
	private Object[] tabela;
	public FluxoCaixaMb() {
		this.ano = Calendar.getInstance().get(Calendar.YEAR);
		criarTabela(null);
	}
	
	public void criarTabela(ActionEvent event){
		
		if(RdlUtils.getProjetoAtual() == null){
			FacesContext.getCurrentInstance().addMessage("Atenção", new FacesMessage(FacesMessage.SEVERITY_WARN,"Selecione um projeto", null));
			return;
		}			
		
		Object[] receitas = null;
		Object[] despesas = null;
		
		try {
			receitas = CustomQueryDao.getTotalReceitaAnual(this.ano);
		} catch (DaoException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			despesas = CustomQueryDao.getTotalDespesaAnual(this.ano);
		} catch (DaoException e) {
			e.printStackTrace();
			return;
		}	
		
		
		tabela = new Object[3];
		
		Object[] total = new Object[12];
		
		for(int i = 0; i < 12;i++)
			total[i] = (Number)(((Number)receitas[i]).longValue() - ((Number)despesas[i]).longValue());	
		
		
		List<Object> l = Arrays.asList(receitas);
		ArrayList<Object> l1 = new ArrayList<Object>(l);
		l1.add("Receitas");
		receitas = l1.toArray();	
		
		l = Arrays.asList(despesas);
		l1 = new ArrayList<Object>(l);
		l1.add("Despesas");
		despesas = l1.toArray();		
		
		l = Arrays.asList(total);
		l1 = new ArrayList<Object>(l);
		l1.add("Total");
		total = l1.toArray();	
		
		tabela[0] = receitas;
		tabela[1] = despesas;
		tabela[2] = total;				
				
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}


	public Object[] getTabela() {
		return tabela;
	}

	public void setTabela(Object[] tabela) {
		this.tabela = tabela;
	}
}
