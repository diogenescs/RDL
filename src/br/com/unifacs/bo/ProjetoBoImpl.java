package br.com.unifacs.bo;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.ProjetoDao;
import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;

public class ProjetoBoImpl implements ProjetoBo {

	ProjetoDao dao = new ProjetoDao();
	
	public void salvar(Projeto projeto) throws BoException {
		if(projeto.getId() == 0 ){
			inserir(projeto);
		}else{
			atualizar(projeto);
		}

	}
	
	private void inserir(Projeto projeto) throws BoException{
		//VALIDA��ES
		try {
			dao.inserir(projeto);
		}catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}
	
	private void atualizar(Projeto projeto) throws BoException{
		//VALIDA��ES
		try {
			dao.atualizar(projeto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}


	public void excluir(Projeto projeto) throws BoException {
		//VALIDA��O
		try {
			dao.excluir(projeto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}

	}

	public List<Projeto> obterTodos() {
		return dao.obterTodos();
	}

	public Projeto obter(Integer id) {
		return dao.obter(id);
	}

	public List<Projeto> obterTodos(Usuario u) {
		try {
			return dao.query("SELECT p FROM Projeto p WHERE p.owner = ?1",u);
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

}
