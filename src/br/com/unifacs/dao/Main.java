package br.com.unifacs.dao;

import br.com.unifacs.bo.UsuarioProjetoBoImpl;
import br.com.unifacs.model.UsuarioProjeto;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UsuarioProjeto e = new UsuarioProjetoBoImpl().obter(2);
		System.out.println(e.getProjeto().getDescricao());
	}

}
