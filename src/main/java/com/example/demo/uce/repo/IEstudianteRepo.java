package com.example.demo.uce.repo;

import java.util.List;

import com.example.demo.uce.modelo.Ciudadano;
import com.example.demo.uce.modelo.Estudiante;

public interface IEstudianteRepo {
	
	public void insertar(Estudiante estudiante);
	
	public List<Estudiante> selectTodoscriteriaAPIquery();
}
