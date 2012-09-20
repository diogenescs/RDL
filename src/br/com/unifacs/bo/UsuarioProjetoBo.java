package br.com.unifacs.bo;

import br.com.unifacs.model.UsuarioProjeto;

public interface UsuarioProjetoBo {
	void salvar(UsuarioProjeto usuarioProjeto) throws BoException;
	void excluir(UsuarioProjeto usuarioProjeto) throws BoException;
}
