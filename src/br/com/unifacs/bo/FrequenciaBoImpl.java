package br.com.unifacs.bo;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.FrequenciaDao;
import br.com.unifacs.model.Frequencia;

public class FrequenciaBoImpl implements FrequenciaBo {

	FrequenciaDao dao = new FrequenciaDao();
	
	public void salvar(Frequencia frequencia) throws BoException {
		if(frequencia.getId() == 0 ){
			inserir(frequencia);
		}else{
			atualizar(frequencia);
		}

	}
	
	private void inserir(Frequencia frequencia) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(frequencia);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(Frequencia frequencia) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(frequencia);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}

	public void excluir(Frequencia frequencia) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(frequencia);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}
	

	}

}
