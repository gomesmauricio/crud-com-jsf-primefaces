package com.mgtechnology.erp.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.mgtechnology.erp.model.Empresa;
import com.mgtechnology.erp.model.TipoEmpresa;

import lombok.Getter;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private Empresa empresa = new Empresa();
	
	public void salvar() {
		System.out.println("Razão social: "+ empresa.getRazaoSocial()
		+"\n"+ "Nome fantasia: " + empresa.getNomeFantasia() +"\n"+
				"Tipo: "+ empresa.getTipo());		
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

}
