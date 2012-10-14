package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.HistoricoDao;
import br.com.unifacs.model.Historico;

public class HistoricoBoImpl implements HistoricoBo {
	
	HistoricoDao dao = new HistoricoDao();
	
	public HistoricoBoImpl() {

	}
	
	private void inserir(Historico historico) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(historico);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}	
	
	private void atualizar(Historico historico) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(historico);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}	

	public void salvar(Historico historico) throws BoException {
		if(historico.getId() == 0 ){
			inserir(historico);
		}else{
			atualizar(historico);
		}
		
	}

	public void excluir(Historico historico) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(historico);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}
		
	}

	public List<Historico> obterTodos() {
		return dao.obterTodos();
	}

	public Historico obter(Integer id) {
		return dao.obter(id);
	}

}
