package br.com.unifacs.dao;

import java.util.Date;
import java.util.List;

import br.com.unifacs.model.Lancamento;

public class LancamentoDao extends GenericDaoJpa<Lancamento, Integer>{

	public LancamentoDao() {
		super(Lancamento.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Lancamento> obterContasAPagar(Date dataInicial, Date dataFinal) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='N' AND Despesa='S' AND dataVcto BETWEEN ?1 AND ?2",dataInicial,dataFinal);
	}
	
	public List<Lancamento> obterContasAReceber(Date dataInicial, Date dataFinal) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='N' AND Despesa='N' AND dataVcto BETWEEN ?1 AND ?2",dataInicial,dataFinal);
	}
	
	public List<Lancamento> obterContas(Date dataInicial, Date dataFinal, String despesa) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='N' AND Despesa=despesa AND dataVcto BETWEEN ?1 AND ?2",dataInicial,dataFinal);
	}

}
