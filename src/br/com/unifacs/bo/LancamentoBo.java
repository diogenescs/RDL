package br.com.unifacs.bo;

import java.util.Date;
import java.util.List;


import br.com.unifacs.model.Lancamento;
import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;
import br.com.unifacs.model.UsuarioProjeto;

public interface LancamentoBo {
	void salvar(Lancamento lancamento) throws BoException;
	void excluir(Lancamento lancamento) throws BoException;
	List<Lancamento> obterTodos();
	List<Lancamento> obterTodos(Usuario u, Projeto p);
	List<Lancamento> obterContasAPagar(Date dataInicial, Date dataFinal) throws BoException;
	List<Lancamento> obterContasAReceber(Date dataInicial, Date dataFinal) throws BoException;
	Lancamento obter(Integer id);
	List<Lancamento> obterPgtosEfetuados(Date dataInicial, Date dataFinal) throws BoException;
}
