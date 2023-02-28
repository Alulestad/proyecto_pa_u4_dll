package com.example.demo.paralelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainSecuencialStream {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> idEstudiantes=new ArrayList<>();
		for(int i=1;i<=10;i++) {
			idEstudiantes.add(i);
			
		}
		
		idEstudiantes.forEach(numero->System.out.println("Estudiante: "+numero));
		//procesar cada estudiante
		long tiempoInicial=System.currentTimeMillis();
		List<String> listaFinal=idEstudiantes.stream().map(id->procesarIdEstudiante(id)).collect(Collectors.toList());
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurido=(tiempoFinal-tiempoInicial)/1000;
		listaFinal.forEach(cadena->System.out.println(cadena));
		
		System.out.println("Tiempo transcurido en segundos: "+tiempoTranscurido);
		
		
		
	}
	
	public static String procesarIdEstudiante(Integer idEstudiante) {
		//Convertir String
		String idConvertido="E"+idEstudiante.toString();
		
		//Insertar en la base
		System.out.println("Insertando Estudiante: "+idConvertido+" Hilo: "+Thread.currentThread().getName());
		
		
		try {
			//1 segundo
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  idConvertido;
	}
}
