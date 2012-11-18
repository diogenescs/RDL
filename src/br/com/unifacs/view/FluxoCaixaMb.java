package br.com.unifacs.view;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.unifacs.dao.CustomQueryDao;
import br.com.unifacs.dao.DaoException;
import br.com.unifacs.model.FluxoCaixa;

@SessionScoped
@ManagedBean(name="fluxoCaixa")
public class FluxoCaixaMb implements Serializable{

	private FluxoCaixa fluxoCaixa;
	private int ano;
	public FluxoCaixaMb() {
		criarTabela();
	}
	
	private void criarTabela(){
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
		
		
		this.fluxoCaixa = new FluxoCaixa();
		
		this.fluxoCaixa.setReceitaJan((Number)despesas[0]);
		this.fluxoCaixa.setDespesaJan((Number)despesas[0]);
		
		this.fluxoCaixa.setReceitaFev((Number)despesas[1]);
		this.fluxoCaixa.setDespesaFev((Number)despesas[1]);
		
		this.fluxoCaixa.setReceitaMar((Number)despesas[2]);
		this.fluxoCaixa.setDespesaMar((Number)despesas[2]);
		
		this.fluxoCaixa.setReceitaAbr((Number)despesas[3]);
		this.fluxoCaixa.setDespesaAbr((Number)despesas[3]);
		
		this.fluxoCaixa.setReceitaMai((Number)despesas[4]);
		this.fluxoCaixa.setDespesaMai((Number)despesas[4]);			
		
		this.fluxoCaixa.setReceitaJun((Number)despesas[5]);
		this.fluxoCaixa.setDespesaJun((Number)despesas[5]);
		
		this.fluxoCaixa.setReceitaJul((Number)despesas[6]);
		this.fluxoCaixa.setDespesaJul((Number)despesas[6]);		
		
		this.fluxoCaixa.setReceitaAgo((Number)despesas[7]);
		this.fluxoCaixa.setDespesaAgo((Number)despesas[7]);
		
		this.fluxoCaixa.setReceitaSet((Number)despesas[8]);
		this.fluxoCaixa.setDespesaSet((Number)despesas[8]);
		
		this.fluxoCaixa.setReceitaOut((Number)despesas[9]);
		this.fluxoCaixa.setDespesaOut((Number)despesas[9]);
		
		this.fluxoCaixa.setReceitaNov((Number)despesas[10]);
		this.fluxoCaixa.setDespesaNov((Number)despesas[10]);
		
		this.fluxoCaixa.setReceitaDez((Number)despesas[11]);
		this.fluxoCaixa.setDespesaDez((Number)despesas[11]);
				
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public FluxoCaixa getFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(FluxoCaixa fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}
}
