package br.com.unifacs.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.unifacs.bo.LancamentoBo;
import br.com.unifacs.bo.LancamentoBoImpl;
import br.com.unifacs.model.Lancamento;

@ManagedBean(name="graficoMb")
@SessionScoped
public class GraficoDespesaReceitaMb implements Serializable {

	private CartesianChartModel categoryModel;
	private LancamentoBo bo;
	private String ano;
	
	public GraficoDespesaReceitaMb() {
		bo = new LancamentoBoImpl();
		criarGrafico();
	}
	
	private void criarGrafico(){
		
		categoryModel = new CartesianChartModel();
		
		ChartSeries receita = new ChartSeries();
		receita.setLabel("Receitas");
		ChartSeries despesa = new ChartSeries();
		despesa.setLabel("Despesas");
		
		/*List<Lancamento> lancamentos = bo.obterTodos();*/
		receita.set("jan", 500);
		receita.set("fev", 1000);
		receita.set("mar", 5000);
		receita.set("abr", 600);
		receita.set("mai", 700);
		receita.set("jun", 2000);
		receita.set("jul", 3000);
		receita.set("ago", 3000);
		receita.set("set", 4000);
		receita.set("out", 2500);
		receita.set("nov", 15000);
		receita.set("dez", 600);
		
		despesa.set("jan", 5000);
		despesa.set("fev", 100);
		despesa.set("mar", 500);
		despesa.set("abr", 650);
		despesa.set("mai", 500);
		despesa.set("jun", 200);
		despesa.set("jul", 300);
		despesa.set("ago", 300);
		despesa.set("set", 2000);
		despesa.set("out", 2200);
		despesa.set("nov", 1500);
		despesa.set("dez", 1000);
		/*for(Lancamento l:lancamentos){
			if(l.getDespesa().equals("S")){
				despesa.set(l.getDataPgto().getMonth(), l.getValorPgto());
			} else {
				receita.set(l.getDataPgto().getMonth(), l.getValorPgto());
			}
		}*/
		
		categoryModel.addSeries(receita);
		categoryModel.addSeries(despesa);	
			
	}
	
	public CartesianChartModel getCategoryModel() {
		return categoryModel;
	}
	public void setCategoryModel(CartesianChartModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	
	

}
