package br.com.unifacs.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.unifacs.bo.UsuarioProjetoBoImpl;
import br.com.unifacs.utils.JpaUtil;
import br.com.unifacs.utils.RdlUtils;

public class CustomQueryDao {
	
	public static Object[] getTotalDespesaAnual(int ano) throws DaoException{
		try {
			
			String linha = null;
			String q = "";
			URL url = new CustomQueryDao().getClass().getResource("grafico.txt");
			FileReader reader = new FileReader(url.getPath());  
	        BufferedReader leitor = new BufferedReader(reader); 
			
	        while ((linha = leitor.readLine()) != null) {  
                 q+=linha;  
          
	        }  
	        
	        System.out.println(q);
	        
			EntityManager entitymanager = JpaUtil.getEntityManager();
			Query query = entitymanager.createQuery(q);
			query.setParameter(1,ano);
			query.setParameter(2,"S");
			query.setParameter(3,new UsuarioProjetoBoImpl().obterUsuarioProjeto(RdlUtils.getUsuarioLogado(),RdlUtils.getProjetoAtual()));	
			Object[] i = (Object[]) query.getSingleResult();
			entitymanager.close();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
	public static Object[] getTotalReceitaAnual(int ano) throws DaoException{
		try {
			String linha = null;
			String q = "";
			URL url = new CustomQueryDao().getClass().getResource("grafico.txt");
			FileReader reader = new FileReader(url.getPath()); 
	        BufferedReader leitor = new BufferedReader(reader); 
			
	        while ((linha = leitor.readLine()) != null) {  
                 q+=linha;  
          
	        }  
	        
	        System.out.println(q);
	        
			EntityManager entitymanager = JpaUtil.getEntityManager();
			Query query = entitymanager.createQuery(q);
			query.setParameter(1,ano);
			query.setParameter(2,"N");
			query.setParameter(3,new UsuarioProjetoBoImpl().obterUsuarioProjeto(RdlUtils.getUsuarioLogado(),RdlUtils.getProjetoAtual()));			
			Object[] i = (Object[]) query.getSingleResult();
			entitymanager.close();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException(e);
		}
	}		
}	



