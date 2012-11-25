package br.com.unifacs.bo;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.unifacs.dao.DaoException;
import br.com.unifacs.dao.NotificacaoDao;
import br.com.unifacs.dao.UsuarioDao;
import br.com.unifacs.model.Notificacao;
import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;

public class UsuarioBoImpl implements UsuarioBo{
	
	UsuarioDao dao = new UsuarioDao();
	NotificacaoDao notDao = new NotificacaoDao();

	public void salvar(Usuario usuario) throws BoException {
		if(usuario.getId() == 0 ){
			inserir(usuario);
			Notificacao not = new Notificacao();
			not.setNumDiasAntes(1);
			try {
				notDao.inserir(not);
				usuario.setNotificacao(not);
				salvar(usuario);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			atualizar(usuario);
		}
		
	}
	
	private void inserir(Usuario usuario) throws BoException{
		//VALIDAÇÕES
		try {
			dao.inserir(usuario);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BoException(e, "Erro ao inserir registro: #13"+e.getMessage());
		}
	}

	
	private void atualizar(Usuario usuario) throws BoException{
		//VALIDAÇÕES
		try {
			dao.atualizar(usuario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao atualizar registro");
		}
				
	}

	public void excluir(Usuario usuario) throws BoException {
		//VALIDAÇÃO
		try {
			dao.excluir(usuario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BoException(e, "Erro ao excluir registro");
		}
	
		
	}

	public Usuario obter(Integer id) {
		return dao.obter(id);
	}

	public List<Usuario> obterTodos() {
		return dao.obterTodos();
	}
	
	public Usuario Logar(String login, String senha) throws BoException {
		try {
			List<Usuario> usrs = dao.query("SELECT u FROM Usuario u WHERE u.login = ?1 and u.senha = ?2",login,senha);
			if (!usrs.isEmpty()){
				Usuario usr = usrs.get(0);
				return usr;
			}else{
				return null;
			}	
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new BoException(e, "Erro ao Logar");
		}
	}
	
	public Usuario BuscarUsuario(String email) throws BoException {
		try {
			List<Usuario> a = dao.query("SELECT u FROM Usuario u WHERE u.email = ?1",email);
			if(a.size() > 0)
				return a.get(0);
			else
				return null;
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new BoException(e, "Erro ao Logar");
		}
	}

	public Usuario obterUsuaorioNaoPermitido(Projeto p, String email) {
		try {
			List<Usuario> a = dao.query("SELECT up FROM Usuario up WHERE up.email = ?1 AND up NOT IN (SELECT pp.usuario FROM UsuarioProjeto pp WHERE pp.projeto = ?2)", email,p);
			if(a.size() == 0)
				return null;
			else
				return a.get(0);
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}

}
