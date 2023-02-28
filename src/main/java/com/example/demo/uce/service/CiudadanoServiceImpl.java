package com.example.demo.uce.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.modelo.Ciudadano;
import com.example.demo.uce.modelo.Estudiante;
import com.example.demo.uce.repo.ICiudadanoRepo;
import com.example.demo.uce.repo.IEstudianteRepo;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {

	@Autowired
	private ICiudadanoRepo ciudadanoRepo;
	
	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public List<Ciudadano> consultarTodos() {
		
		return ciudadanoRepo.selectTodoscriteriaAPIquery();
	}

	@Override
	public void convertir(Ciudadano ciudadano) {
		
		Estudiante estudianteConvertido=new Estudiante();
		
		//Calculo de la edad
		LocalDate nacimiento=ciudadano.getFechaNacimiento().toLocalDate();
		Period periodo=Period.between(nacimiento, LocalDate.now());
		Integer edad=periodo.getYears();
		
		//Calculo del nombre completo
		String nombreCompleto;
		nombreCompleto=ciudadano.getNombre().concat(" "+ciudadano.getApellido());
		
		//Seteo de estudiante
		estudianteConvertido.setEdad(edad);
		//estudianteConvertido.setId(ciudadano.getId());
		estudianteConvertido.setNombreCompleto(nombreCompleto);
		
		//Insertar
		System.out.print(" Hilo: "+Thread.currentThread().getName());
		estudianteRepo.insertar(estudianteConvertido);
		
	}

}
