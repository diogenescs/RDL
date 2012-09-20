package br.com.unifacs.bo;

import br.com.unifacs.model.Frequencia;

public interface FrequenciaBo {
	void salvar(Frequencia frequencia) throws BoException;
	void excluir(Frequencia frequencia) throws BoException;
}
