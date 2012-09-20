package br.com.unifacs.bo;

import br.com.unifacs.model.FormaDePgto;

public interface FormaDePgtoBo {
	void salvar(FormaDePgto formaDePgto) throws BoException;
	void excluir(FormaDePgto formaDePgto) throws BoException;

}
