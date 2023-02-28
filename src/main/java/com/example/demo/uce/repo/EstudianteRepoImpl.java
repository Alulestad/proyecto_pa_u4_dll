package com.example.demo.uce.repo;

import java.awt.print.Printable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);

	}

	@Override
	public List<Estudiante> selectTodoscriteriaAPIquery() {

		CriteriaBuilder criteriaBuilder=this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Estudiante> criteriaQuery=criteriaBuilder.createQuery(Estudiante.class);
		
		Root<Estudiante> root=criteriaQuery.from(Estudiante.class);
		
		criteriaQuery.select(root);
		
		TypedQuery<Estudiante> typedQuery=this.entityManager.createQuery(criteriaQuery);
		
		
		return typedQuery.getResultList();
	}

}
