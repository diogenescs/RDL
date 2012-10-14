package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.Historico;

public interface HistoricoBo {
		void salvar(Historico historico) throws BoException;
		void excluir(Historico historico) throws BoException;
		List<Historico> obterTodos();
		Historico obter(Integer id);
}
