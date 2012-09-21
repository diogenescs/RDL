package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.FormaDePgtoDao;
import br.com.unifacs.model.FormaDePgto;

public class FormaDePgtoBoImpl implements FormaDePgtoBo {

	FormaDePgtoDao dao = new FormaDePgtoDao();
	
	public void salvar(FormaDePgto formaDePgto) throws BoException {
		if(formaDePgto.getId() == 0 ){
			inserir(formaDePgto);
		}else{
			atualizar(formaDePgto);
		}

	}
	
	private void inserir(FormaDePgto formaDePgto) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(formaDePgto);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(FormaDePgto formaDePgto) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(formaDePgto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}

	public void excluir(FormaDePgto formaDePgto) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(formaDePgto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}

	}

	public List<FormaDePgto> obterTodos() {
		return dao.obterTodos();
	}

	public FormaDePgto obter(Integer id) {
		return dao.obter(id);
	}

}
