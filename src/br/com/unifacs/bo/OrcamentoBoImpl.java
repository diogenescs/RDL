package br.com.unifacs.bo;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.OrcamentoDao;
import br.com.unifacs.model.Orcamento;

public class OrcamentoBoImpl implements OrcamentoBo {

	OrcamentoDao dao = new OrcamentoDao();
	
	public void salvar(Orcamento orcamento) throws BoException {
		if(orcamento.getId() == 0 ){
			inserir(orcamento);
		}else{
			atualizar(orcamento);
		}

	}
	
	private void inserir(Orcamento orcamento) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(orcamento);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(Orcamento orcamento) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(orcamento);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}

	public void excluir(Orcamento orcamento) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(orcamento);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}

	}

}
