package br.com.unifacs.bo;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.NotificacaoDao;
import br.com.unifacs.dao.ProjetoDao;
import br.com.unifacs.model.Notificacao;
import br.com.unifacs.model.Projeto;

public class NotificacaoBoImpl implements NotificacaoBo {

	NotificacaoDao dao = new NotificacaoDao();
	
	public void salvar(Notificacao notificacao) throws BoException {
		if(notificacao.getId() == 0 ){
			inserir(notificacao);
		}else{
			atualizar(notificacao);
		}

	}
	
	private void inserir(Notificacao notificacao) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(notificacao);
		}catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}
	
	private void atualizar(Notificacao notificacao) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(notificacao);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}


	public void excluir(Notificacao notificacao) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(notificacao);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}

	}

	public List<Notificacao> obterTodos() {
		return dao.obterTodos();
	}

	public Notificacao obter(Integer id) {
		return dao.obter(id);
	}

}
