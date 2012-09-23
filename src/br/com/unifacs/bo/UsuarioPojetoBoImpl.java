package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.UsuarioPojetoDao;
import br.com.unifacs.model.UsuarioProjeto;

public class UsuarioPojetoBoImpl implements UsuarioProjetoBo {

	UsuarioPojetoDao dao = new UsuarioPojetoDao();
	
	public void salvar(UsuarioProjeto usuarioProjeto) throws BoException {
		if(usuarioProjeto.getId() == 0 ){
			inserir(usuarioProjeto);
		}else{
			atualizar(usuarioProjeto);
		}

	}
	
	private void inserir(UsuarioProjeto usuarioProjeto) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(usuarioProjeto);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(UsuarioProjeto usuarioProjeto) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(usuarioProjeto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}

	public void excluir(UsuarioProjeto usuarioProjeto) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(usuarioProjeto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}
	

	}

	public UsuarioProjeto obter(Integer id) {
		return dao.obter(id);
	}

	public List<UsuarioProjeto> obterTodos() {
		// TODO Auto-generated method stub
		return dao.obterTodos();
	}

}
