package br.com.unifacs.dao;

import br.com.unifacs.model.Projeto;

public class ProjetoDao extends GenericDaoJpa<Projeto, Integer>{

	public ProjetoDao() {
		super(Projeto.class);
	}

}
