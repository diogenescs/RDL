package br.com.unifacs.bo;

import br.com.unifacs.model.Usuario;

public interface UsuarioBo {
	void salvar(Usuario usuario) throws BoException;
	void excluir(Usuario usuario) throws BoException;
}
