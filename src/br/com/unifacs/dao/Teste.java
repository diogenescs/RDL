package br.com.unifacs.dao;

import org.junit.Assert;
import org.junit.Test;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.CategoriaBo;
import br.com.unifacs.bo.CategoriaBoImpl;
import br.com.unifacs.model.Categoria;

public class Teste {

	/**
	 * @param args
	 */
	@Test
	public  void testar() {
		// TODO Auto-generated method stub
		CategoriaBo bo = new CategoriaBoImpl();
		Categoria ct = new Categoria();
		ct.setDescricao("teste");
		
		try {
			bo.salvar(ct);
		} catch (BoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertNotNull(ct.getId());
		
	}

}
