package com.example.demo.uce.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CiudadanoRepoImpl implements ICiudadanoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Ciudadano> selectTodoscriteriaAPIquery() {
		CriteriaBuilder criteriaBuilder= this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Ciudadano> criteriaQuery=criteriaBuilder.createQuery(Ciudadano.class);
		
		Root<Ciudadano> root=criteriaQuery.from(Ciudadano.class);
		criteriaQuery.select(root);
		
		TypedQuery<Ciudadano> typedQuery=this.entityManager.createQuery(criteriaQuery);
		
		return typedQuery.getResultList();
	}

}
