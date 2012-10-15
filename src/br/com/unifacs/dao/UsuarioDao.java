package br.com.unifacs.dao;

import br.com.unifacs.model.Usuario;

public class UsuarioDao extends GenericDaoJpa<Usuario, Integer>{

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	

}
