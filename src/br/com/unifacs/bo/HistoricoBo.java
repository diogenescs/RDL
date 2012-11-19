package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.Historico;
import br.com.unifacs.model.Projeto;

public interface HistoricoBo {
		void salvar(Historico historico) throws BoException;
		void excluir(Historico historico) throws BoException;
		List<Historico> obterTodos();
		List<Historico> obterTodos(Projeto p);
		Historico obter(Integer id);
}
