package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.FormaDePgto;

public interface FormaDePgtoBo {
	void salvar(FormaDePgto formaDePgto) throws BoException;
	void excluir(FormaDePgto formaDePgto) throws BoException;
	List<FormaDePgto> obterTodos();
	FormaDePgto obter(Integer id);

}
