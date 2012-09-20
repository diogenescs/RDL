package br.com.unifacs.dao;

import br.com.unifacs.model.Contato;

public class ContatoDao extends GenericDaoJpa<Contato, Integer>{
	public ContatoDao() {
		super(Contato.class);
	}

}
