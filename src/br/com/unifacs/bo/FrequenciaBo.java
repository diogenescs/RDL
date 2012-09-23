package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.Frequencia;

public interface FrequenciaBo {
	void salvar(Frequencia frequencia) throws BoException;
	void excluir(Frequencia frequencia) throws BoException;
	List<Frequencia> obterTodos();
	Frequencia obter(Integer pk);
}
