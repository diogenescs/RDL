package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;
import br.com.unifacs.model.UsuarioProjeto;

public interface UsuarioProjetoBo {
	void salvar(UsuarioProjeto usuarioProjeto) throws BoException;
	void excluir(UsuarioProjeto usuarioProjeto) throws BoException;
	UsuarioProjeto obter(Integer id);
	List<UsuarioProjeto> obterTodos();
	UsuarioProjeto obterUsuarioProjeto(Usuario u, Projeto p);
	List<Projeto> obterTodos(Usuario u);
	List<UsuarioProjeto> obterTodosPorUsuario(Usuario u);
}
