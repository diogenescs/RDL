package br.com.unifacs.view;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.unifacs.bo.FormaDePgtoBo;
import br.com.unifacs.bo.FormaDePgtoBoImpl;
import br.com.unifacs.model.Categoria;
import br.com.unifacs.model.FormaDePgto;

@ManagedBean(name="formaDePgtoMb")
@SessionScoped
public class FormaDePgtoMb {
	private FormaDePgto formaDePgtoMb;
	private FormaDePgtoBo bo;
	private List<FormaDePgto> formaDePgtos;
	
	public FormaDePgtoMb() {
		bo = new FormaDePgtoBoImpl();
		formaDePgtoMb = new FormaDePgto();
	}
	

		
}
