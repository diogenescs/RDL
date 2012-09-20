package br.com.unifacs.bo;

import br.com.unifacs.model.Projeto;

public interface ProjetoBo {
	void salvar(Projeto projeto) throws BoException;
	void excluir(Projeto projeto) throws BoException;

}
