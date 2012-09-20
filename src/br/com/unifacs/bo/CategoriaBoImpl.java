package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.dao.CategoriaDao;
import br.com.unifacs.dao.DaoException;
import br.com.unifacs.model.Categoria;

public class CategoriaBoImpl implements CategoriaBo {

	CategoriaDao dao = new CategoriaDao();
	
	
	public void salvar(Categoria categoria) throws BoException{
		if(categoria.getId() == 0 ){
			inserir(categoria);
		}else{
			atualizar(categoria);
		}
	}
	
	
	private void inserir(Categoria categoria) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(categoria);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(Categoria categoria) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(categoria);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}

	public void excluir(Categoria categoria) throws BoException{
		//VALIDAÇÃO
			try {
				dao.excluir(categoria);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BoException(e, "Erro ao excluir registro");
			}
		
		
	}


	public List<Categoria> obterTodos() {
		return dao.obterTodos();
	}


	public Categoria obter(Integer id) {
		return dao.obter(id);
	}

}
