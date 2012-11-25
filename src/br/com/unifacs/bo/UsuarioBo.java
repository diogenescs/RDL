package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;

public interface UsuarioBo {
	void salvar(Usuario usuario) throws BoException;
	void excluir(Usuario usuario) throws BoException;
	Usuario obter(Integer id);
	List<Usuario> obterTodos();
	Usuario Logar(String login, String senha) throws BoException;
	Usuario BuscarUsuario(String email) throws BoException;
	Usuario obterUsuaorioNaoPermitido(Projeto p, String email);
}
