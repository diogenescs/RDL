package br.com.unifacs.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.unifacs.bo.BoException;
import br.com.unifacs.bo.CategoriaBo;
import br.com.unifacs.bo.CategoriaBoImpl;
import br.com.unifacs.bo.ContatoBo;
import br.com.unifacs.bo.ContatoBoImpl;
import br.com.unifacs.bo.UsuarioProjetoBoImpl;
import br.com.unifacs.model.Categoria;
import br.com.unifacs.model.Contato;
import br.com.unifacs.model.Lancamento;
import br.com.unifacs.model.UsuarioProjeto;

public class Teste {

	/**
	 * @param args
	 */
	@Test
	public  void testar() {
		// TODO Auto-generated method stub
//		CategoriaBo bo = new CategoriaBoImpl();
//		Categoria ct = new Categoria();
//		ct.setDescricao("teste");
//		
//		try {
//			bo.salvar(ct);
//		} catch (BoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		LancamentoDao d = new LancamentoDao();
		List<Lancamento> l = null;
		
		try {
			l = d.obterContasAPagar(new Date(2012, 10, 01), new Date(2012, 11, 30));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertNotNull(l);
		
		System.out.println("TESTE");
	}
	
	public static void main(String args[]){
		LancamentoDao d = new LancamentoDao();
		List<Lancamento> l = null;
		
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
//			try {
//				l = d.obterContasAPagar(sdf.parse("2012-10-01"),sdf.parse("2012-11-30"));
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(l);
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		LancamentoDao dao = new LancamentoDao();
//		List<Lancamento> w = dao.obterTodos();
//		System.out.println(w);
//		for (Lancamento a: w)
//			System.out.println(a.getCategoria().getDescricao());	
		
		try {
			Object[] o = CustomQueryDao.getTotalDespesaAnual(2012);
			for(int i=0; i<o.length; i++)
				System.out.println(o[i]);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
