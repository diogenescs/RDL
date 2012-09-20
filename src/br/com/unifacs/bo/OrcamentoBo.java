package br.com.unifacs.bo;

import br.com.unifacs.model.Orcamento;

public interface OrcamentoBo {
	void salvar(Orcamento orcamento) throws BoException;
	void excluir(Orcamento orcamento) throws BoException;
}
