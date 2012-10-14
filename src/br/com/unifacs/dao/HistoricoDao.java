package br.com.unifacs.dao;

import br.com.unifacs.model.Historico;
import br.com.unifacs.model.Orcamento;

public class HistoricoDao extends GenericDaoJpa<Historico, Integer> {
	
	public HistoricoDao() {
		super(Historico.class);
	}
}
