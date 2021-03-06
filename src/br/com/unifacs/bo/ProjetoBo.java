package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;

public interface ProjetoBo {
	
	void salvar(Projeto projeto) throws BoException;
	void excluir(Projeto projeto) throws BoException;
	List<Projeto> obterTodos();
	Projeto obter(Integer id);
	List<Projeto> obterTodos(Usuario u);
}
