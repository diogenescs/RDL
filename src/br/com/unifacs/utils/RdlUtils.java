package br.com.unifacs.utils;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.unifacs.model.Projeto;
import br.com.unifacs.model.Usuario;

public class RdlUtils {
	
	private static Usuario usuarioAtual = null;
	private static Projeto projetoAtual = null;
	private static List<Projeto> listaProjeto = null;
	
	
	public RdlUtils() {
		// TODO Auto-generated constructor stub
	}
	
	private static HttpSession getSession(){
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			return request.getSession(true);
		
	}
	
	public static void login(Usuario u){
		HttpSession session = RdlUtils.getSession(); 
		session.setAttribute("usuarioAtual", u);	
		usuarioAtual = u;
	}
	
	public static void logout(){
		HttpSession session = RdlUtils.getSession(); 
		session.invalidate();	
	}
	
	public static boolean isUsuarioLogado(){
		if (usuarioAtual==null)
			return false;
		return true;
	}
	
	public static Usuario getUsuarioLogado(){
		return usuarioAtual;
	}

	public static Projeto getProjetoAtual() {
		return projetoAtual;
	}

	public static void setProjetoAtual(Projeto projetoAtual) {
		RdlUtils.projetoAtual = projetoAtual;
	}

	public static List<Projeto> getListaProjeto() {
		return listaProjeto;
	}

	public static void setListaProjeto(List<Projeto> listaProjeto) {
		RdlUtils.listaProjeto = listaProjeto;
	}

}
