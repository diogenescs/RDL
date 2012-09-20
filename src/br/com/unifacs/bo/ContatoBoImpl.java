package br.com.unifacs.bo;

import br.com.unifacs.dao.ContatoDao;
import br.com.unifacs.dao.DaoException;
import br.com.unifacs.model.Contato;

public class ContatoBoImpl implements ContatoBo {

	ContatoDao dao = new ContatoDao();
	
	public void salvar(Contato contato) throws BoException {
		if(contato.getId() == 0 ){
			inserir(contato);
		}else{
			atualizar(contato);
		}

	}
	
	private void inserir(Contato contato) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(contato);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(Contato contato) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(contato);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}

	public void excluir(Contato contato) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(contato);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}
	}

}
