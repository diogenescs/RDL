package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.Categoria;

public interface CategoriaBo {

	void salvar(Categoria categoria) throws BoException;
	void excluir(Categoria categoria) throws BoException;
	List<Categoria> obterTodos();
	Categoria obter(Integer id);
}
