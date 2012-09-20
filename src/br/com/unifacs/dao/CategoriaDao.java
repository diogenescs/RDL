package br.com.unifacs.dao;

import br.com.unifacs.model.Categoria;

public class CategoriaDao extends GenericDaoJpa<Categoria, Integer> {

	public CategoriaDao() {
		super(Categoria.class);
	}	
	
}
