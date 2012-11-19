package br.com.unifacs.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.HistoricoDao;
import br.com.unifacs.dao.LancamentoDao;
import br.com.unifacs.model.Lancamento;
import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;
import br.com.unifacs.model.UsuarioProjeto;

public class LancamentoBoImpl implements LancamentoBo,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7618437877185942892L;
	LancamentoDao dao = new LancamentoDao();
	
	public void salvar(Lancamento lancamento) throws BoException {
		if(lancamento.getId() == 0 ){
			inserir(lancamento);
		}else{
			atualizar(lancamento);
		}

	}
	
	private void inserir(Lancamento lancamento) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(lancamento);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(Lancamento lancamento) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(lancamento);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}


	public void excluir(Lancamento lancamento) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(lancamento);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}

	}
	
	public List<Lancamento> obterTodos() {
		return dao.obterTodos();
	}
	
	public List<Lancamento> obterTodos(Usuario u, Projeto p){
		UsuarioProjeto up = new  UsuarioProjetoBoImpl().obterUsuarioProjeto(u, p);
		try {
			return dao.query("SELECT p FROM Lancamento p WHERE p.usuarioProjeto = ?1", up);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	public Lancamento obter(Integer id) {
		return dao.obter(id);
	}

	public List<Lancamento> obterContasAPagar(Date dataInicial, Date dataFinal) throws BoException {
		try {
			return dao.obterContasAPagar(dataInicial, dataFinal);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro na pesquisa");
		}
	}

	public List<Lancamento> obterContasAReceber(Date dataInicial, Date dataFinal) throws BoException {
		try {
			return dao.obterContasAReceber(dataInicial, dataFinal);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro na pesquisa");
		}
	}
	
	public List<Lancamento> obterPgtosEfetuados(Date dataInicial, Date dataFinal) throws BoException {
		try {
			return dao.obterPgtosEfetuados(dataInicial, dataFinal);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro na pesquisa");
		}
	}

}
