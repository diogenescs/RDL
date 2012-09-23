package br.com.unifacs.bo;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.ProjetoDao;
import br.com.unifacs.model.Projeto;

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
		//VALIDAÇÕES
		try {
			dao.inserir(projeto);
		}catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}
	
	private void atualizar(Projeto projeto) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(projeto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}


	public void excluir(Projeto projeto) throws BoException {
		//VALIDAÇÃO
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

}
