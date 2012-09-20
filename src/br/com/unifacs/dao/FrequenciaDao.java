package br.com.unifacs.dao;

import br.com.unifacs.model.Frequencia;

public class FrequenciaDao extends GenericDaoJpa<Frequencia, Integer>{

	public FrequenciaDao(){
		super(Frequencia.class);
	}
	
}
