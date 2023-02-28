package com.example.demo.uce.service;

import java.util.List;

import com.example.demo.uce.modelo.Ciudadano;
import com.example.demo.uce.modelo.Estudiante;

public interface ICiudadanoService {
	
	public List<Ciudadano> consultarTodos();
	
	public void convertir(Ciudadano ciudadano);
}
