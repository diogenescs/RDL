package br.com.unifacs.dao;

import br.com.unifacs.bo.UsuarioPojetoBoImpl;
import br.com.unifacs.model.UsuarioProjeto;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UsuarioProjeto e = new UsuarioPojetoBoImpl().obter(2);
		System.out.println(e.getProjeto().getDescricao());
	}

}
