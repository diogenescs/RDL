package br.com.unifacs.bo;

import br.com.unifacs.model.Contato;

public interface ContatoBo {
	void salvar(Contato contato) throws BoException;
	void excluir(Contato contato) throws BoException;
}
