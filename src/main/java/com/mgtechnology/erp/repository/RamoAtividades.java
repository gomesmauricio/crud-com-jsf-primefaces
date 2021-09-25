package com.mgtechnology.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mgtechnology.erp.model.RamoAtividade;

public class RamoAtividades implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public RamoAtividades() {

	}

	public RamoAtividades(EntityManager manager) {
		this.manager = manager;
	}
	
	//Consulta onde persquiso, por uma string que esta sendo parcialmente passada (Usando Criteria)
	public List<RamoAtividade> pesquisar(String descricao) {
		//Classe utilitaria
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		//Equivalente ao JPQL
		CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);		
		Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);			
		criteriaQuery.select(root);				
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));		
		
		TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}

}
