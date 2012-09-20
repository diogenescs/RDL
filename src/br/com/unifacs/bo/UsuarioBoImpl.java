package br.com.unifacs.bo;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.UsuarioDao;
import br.com.unifacs.model.Usuario;

public class UsuarioBoImpl implements UsuarioBo{
	
	UsuarioDao dao = new UsuarioDao();

	public void salvar(Usuario usuario) throws BoException {
		if(usuario.getId() == 0 ){
			inserir(usuario);
		}else{
			atualizar(usuario);
		}
		
	}
	
	private void inserir(Usuario usuario) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(usuario);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(Usuario usuario) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(usuario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}

	public void excluir(Usuario usuario) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(usuario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}
	
		
	}

}
