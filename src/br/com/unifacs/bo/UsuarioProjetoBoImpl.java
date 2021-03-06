package br.com.unifacs.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.UsuarioPojetoDao;
import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;
import br.com.unifacs.model.UsuarioProjeto;

public class UsuarioProjetoBoImpl implements UsuarioProjetoBo {

	UsuarioPojetoDao dao = new UsuarioPojetoDao();
	
	public void salvar(UsuarioProjeto usuarioProjeto) throws BoException {
		if(usuarioProjeto.getId() == 0 ){
			inserir(usuarioProjeto);
		}else{
			atualizar(usuarioProjeto);
		}

	}
	
	private void inserir(UsuarioProjeto usuarioProjeto) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(usuarioProjeto);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(UsuarioProjeto usuarioProjeto) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(usuarioProjeto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}

	public void excluir(UsuarioProjeto usuarioProjeto) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(usuarioProjeto);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}
	

	}

	public UsuarioProjeto obter(Integer id) {
		return dao.obter(id);
	}

	public List<UsuarioProjeto> obterTodos() {
		// TODO Auto-generated method stub
		return dao.obterTodos();
	}
	
	public UsuarioProjeto obterUsuarioProjeto(Usuario u, Projeto p) {
		if(u==null || p == null)
			return null;
		UsuarioProjeto a = null;
		try {
			List<UsuarioProjeto> l = dao.query("SELECT up FROM UsuarioProjeto up WHERE up.usuario = ?1 AND up.projeto = ?2", u,p);
			if(l!=null)
				a = l.get(0);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	public List<UsuarioProjeto> obterUsuarioProjetoPorProjeto(Projeto p) {
		List<UsuarioProjeto> l = new ArrayList<UsuarioProjeto>();
		if(p == null)
			return null;
		UsuarioProjeto a = null;
		try {
			l = dao.query("SELECT up FROM UsuarioProjeto up WHERE up.projeto = ?1",p);
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	public List<Projeto> obterTodos(Usuario u) {
		try {
			List<UsuarioProjeto> a = dao.query("SELECT up FROM UsuarioProjeto up WHERE up.usuario = ?1", u);
			List<Projeto> p = new ArrayList<Projeto>();
			for(UsuarioProjeto up : a){
		       p.add(up.getProjeto());
			}
			return p;
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<UsuarioProjeto> obterTodosPorUsuario(Usuario u) {
		try {
			List<UsuarioProjeto> a = dao.query("SELECT up FROM UsuarioProjeto up WHERE up.projeto.owner = ?1", u);
			return a;
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<UsuarioProjeto> obterTodosPorProjeto(Projeto u) {
		try {
			List<UsuarioProjeto> a = dao.query("SELECT up FROM UsuarioProjeto up WHERE up.projeto = ?1", u);
			return a;
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

}
