package br.com.unifacs.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.unifacs.bo.UsuarioProjetoBoImpl;
import br.com.unifacs.model.Lancamento;
import br.com.unifacs.model.UsuarioProjeto;
import br.com.unifacs.utils.JpaUtil;
import br.com.unifacs.utils.RdlUtils;

public class LancamentoDao extends GenericDaoJpa<Lancamento, Integer>{

	public LancamentoDao() {
		super(Lancamento.class);
		// TODO Auto-generated constructor stub
	}
	
	private UsuarioProjeto getUsuarioProjetoAtual(){
		return new UsuarioProjetoBoImpl().obterUsuarioProjeto(RdlUtils.getUsuarioLogado(),RdlUtils.getProjetoAtual());
	}
	
	public List<Lancamento> obterContasAPagar(Date dataInicial, Date dataFinal) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='N' AND l.ativo = 1 AND Despesa='S' AND dataVcto BETWEEN ?1 AND ?2 AND l.usuarioProjeto = ?3",dataInicial,dataFinal,getUsuarioProjetoAtual());
	}
	
	public List<Lancamento> obterContasAReceber(Date dataInicial, Date dataFinal) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='N' AND l.ativo = 1 AND Despesa='N' AND dataVcto BETWEEN ?1 AND ?2 AND l.usuarioProjeto = ?3",dataInicial,dataFinal,getUsuarioProjetoAtual());
	}
	
	public List<Lancamento> obterContas(Date dataInicial, Date dataFinal, String despesa) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='N' AND l.ativo = 1 AND Despesa=despesa AND dataVcto BETWEEN ?1 AND ?2 AND l.usuarioProjeto = ?3",dataInicial,dataFinal,getUsuarioProjetoAtual());
	}
	
	public List<Lancamento> obterPgtosEfetuados(Date dataInicial, Date dataFinal) throws DaoException{
		return this.query("SELECT l FROM Lancamento l WHERE l.realizado='S' AND l.ativo = 1 AND Despesa='S' AND dataVcto BETWEEN ?1 AND ?2  AND l.usuarioProjeto = ?3",dataInicial,dataFinal,getUsuarioProjetoAtual());
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
