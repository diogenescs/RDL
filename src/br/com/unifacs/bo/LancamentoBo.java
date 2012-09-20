package br.com.unifacs.bo;

import br.com.unifacs.model.Lancamento;

public interface LancamentoBo {
	void salvar(Lancamento lancamento) throws BoException;
	void excluir(Lancamento lancamento) throws BoException;
}
