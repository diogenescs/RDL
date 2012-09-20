package br.com.unifacs.utils;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse; 

public class ConexaoHibernateFilter implements Filter {
	private EntityManager em;
	public void init(FilterConfig config) throws ServletException {
		this.em = JpaUtil.getEntityManager();
		
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws ServletException {
		try {
			this.em.getTransaction().begin();
			chain.doFilter(servletRequest, servletResponse);
			this.em.getTransaction().commit();
			
		} catch (Throwable ex) {
			try {
				if (this.em.getTransaction().isActive()) {
					this.em.getTransaction().rollback();
					System.out.println("rollback");
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}finally{
			this.em.close();
		}
	}

}
