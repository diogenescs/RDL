package br.com.unifacs.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.unifacs.model.Lancamento;
import br.com.unifacs.utils.JpaUtil;

public class LancamentoDao extends GenericDaoJpa<Lancamento, Integer>{

	public LancamentoDao() {
		super(Lancamento.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<Lancamento> obterContasAPagar(Date dataInicial, Date dataFinal) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='N' AND l.ativo = 1 AND Despesa='S' AND dataVcto BETWEEN ?1 AND ?2",dataInicial,dataFinal);
	}
	
	public List<Lancamento> obterContasAReceber(Date dataInicial, Date dataFinal) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='N' AND l.ativo = 1 AND Despesa='N' AND dataVcto BETWEEN ?1 AND ?2",dataInicial,dataFinal);
	}
	
	public List<Lancamento> obterContas(Date dataInicial, Date dataFinal, String despesa) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='N' AND l.ativo = 1 AND Despesa=despesa AND dataVcto BETWEEN ?1 AND ?2",dataInicial,dataFinal);
	}
	
	public List<Lancamento> obterPgtosEfetuados(Date dataInicial, Date dataFinal) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='S' AND l.ativo = 1 AND Despesa='S' AND dataVcto BETWEEN ?1 AND ?2",dataInicial,dataFinal);
	}
	
	@Override
	public List<Lancamento> obterTodos() {
		try {
			return this.query("SELECT this FROM Lancamento this WHERE this.ativo = ?1",true);
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void excluir(Lancamento model) throws DaoException{
		try {
			model.setAtivo(false);
			this.atualizar(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException(e);
		}	
   }

}
