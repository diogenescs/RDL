package br.com.unifacs.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.unifacs.model.Usuario;

public class RdlUtils {
	
	private static Usuario usuarioAtual = null;
	
	public RdlUtils() {
		// TODO Auto-generated constructor stub
	}
	
	private static HttpSession getSession(){
		FacesContext facesContext = FacesContext.getCurrentInstance(); 

		HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest(); 

		return request.getSession(); 
		
	}
	
	public static void login(Usuario u){
		HttpSession session = RdlUtils.getSession(); 
		session.setAttribute(u.getLogin(), u);	
		usuarioAtual = u;
	}
	
	public static void logout(){
		HttpSession session = RdlUtils.getSession(); 
		session.invalidate();	
	}
	
	public static boolean isUsuarioLogado(){
		if (usuarioAtual==null)
			return false;
		HttpSession session = RdlUtils.getSession(); 
		return session.getAttribute(usuarioAtual.getLogin()) != null? true : false;
	}
	
	public static Usuario getUsuarioLogado(){
		HttpSession session = RdlUtils.getSession();
		return (Usuario) session.getAttribute(usuarioAtual.getLogin());
	}

}
