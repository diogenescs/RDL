package br.com.unifacs.dao;

import br.com.unifacs.model.Notificacao;


public class NotificacaoDao extends GenericDaoJpa<Notificacao, Integer>{

	public NotificacaoDao() {
		super(Notificacao.class);
	}

}
