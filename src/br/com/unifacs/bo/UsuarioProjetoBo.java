package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.UsuarioProjeto;

public interface UsuarioProjetoBo {
	void salvar(UsuarioProjeto usuarioProjeto) throws BoException;
	void excluir(UsuarioProjeto usuarioProjeto) throws BoException;
	UsuarioProjeto obter(Integer id);
	List<UsuarioProjeto> obterTodos();
}
