package br.com.unifacs.bo;

import java.util.List;

import br.com.unifacs.model.Notificacao;

public interface NotificacaoBo {
	
	void salvar(Notificacao notificacao) throws BoException;
	void excluir(Notificacao notificacao) throws BoException;
	List<Notificacao> obterTodos();
	Notificacao obter(Integer id);

}
