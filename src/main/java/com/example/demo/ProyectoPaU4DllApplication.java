package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.funcional.MainInterfacesFuncionales;
import com.example.demo.uce.modelo.Ciudadano;
import com.example.demo.uce.modelo.Estudiante;
import com.example.demo.uce.service.ICiudadanoService;
import com.example.demo.uce.service.IEstudianteService;

@SpringBootApplication
public class ProyectoPaU4DllApplication implements CommandLineRunner{

	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private IEstudianteService estudianteService;
	
	private static final Logger LOG=LoggerFactory.getLogger(ProyectoPaU4DllApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4DllApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Unidad 4");
		
		long tiempoInicial=System.currentTimeMillis();
		procesarEstudiantesParalelo(ciudadanoService);
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurido=(tiempoFinal-tiempoInicial);

		System.out.println("Tiempo transcurido en milisegundos: "+tiempoTranscurido);
		LOG.info("Tiempo transcurido en milisegundos: ".concat(Long.toString(tiempoTranscurido)));
		
	}
	
	private static void procesarEstudiantesParalelo(ICiudadanoService ciudadanoService) {
		List<Ciudadano> listaCiudadanos= ciudadanoService.consultarTodos();
		listaCiudadanos.parallelStream().forEach(ciudadano->ciudadanoService.convertir(ciudadano));
		
	}
	

}
