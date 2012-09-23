package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.Usuario;

public interface UsuarioBo {
	void salvar(Usuario usuario) throws BoException;
	void excluir(Usuario usuario) throws BoException;
	Usuario obter(Integer id);
	List<Usuario> obterTodos(); 
}
