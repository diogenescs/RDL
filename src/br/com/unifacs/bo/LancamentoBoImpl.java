package br.com.unifacs.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.LancamentoDao;
import br.com.unifacs.model.Categoria;
import br.com.unifacs.model.Lancamento;

public class LancamentoBoImpl implements LancamentoBo,Serializable {
	
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

	

}
