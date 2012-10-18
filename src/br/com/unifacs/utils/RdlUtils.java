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

}
