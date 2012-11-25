package br.com.unifacs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.unifacs.utils.RdlUtils;

public class LoginFilter implements Filter {

	private FilterConfig fc;
	
	
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
	
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;	

		String pageRequest = req.getRequestURL().toString();
		
		 if (RdlUtils.isUsuarioLogado() && pageRequest.contains("login.jsf")){
			resp.sendRedirect("produto_workspace.jsf");
		}
		else{
			chain.doFilter(req, resp);
		}
			
			
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.fc = filterConfig;

	}

}
