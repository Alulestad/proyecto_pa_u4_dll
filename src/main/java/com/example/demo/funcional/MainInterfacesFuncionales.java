package com.example.demo.funcional;

import org.hibernate.type.descriptor.java.IntegerJavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {
	
	private static final Logger LOG=LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	//Es una interface que permite imprimir detalladamente (nos ayuda a agregar categorias, hora, etc)
	public static void main(String[] args) {
		System.out.println("MainInterfacesFuncionales");
		//1.- SUPPLIER 
		LOG.info("1.- SUPPLIER ");
		//Clases
		IPersonaSupplier<String> personaSupplier1=new PersonaSupplierImpl();
		LOG.error("Supplier Clase: "+personaSupplier1.getNombre());
		
		//Lambdas 
		IPersonaSupplier<String> personaSupplier2=()-> "Daniel 2";
		LOG.info("Supplier Lambda: "+personaSupplier2.getNombre());
		
		IPersonaSupplier<Integer> personaSupplier3=()-> Integer.valueOf(5);
		LOG.info("Supplier Lambda: "+personaSupplier3.getNombre());
		
		IPersonaSupplier<Persona> personaSupplier4=()-> {
			Persona per= new Persona();
			per.setApellido("Molina");
			per.setNombre("Daniel");
			return per;
		};
		LOG.info("Supplier Lambda: "+personaSupplier4.getNombre());
		
		IPersonaSupplier<Persona> personaSupplier5=new PersonaSupplier2Impl();
		LOG.info("Supplier Clase2: "+personaSupplier5.getNombre());
		
		//2.- CONSUMER 
		LOG.info("2.- CONSUMER ");
		
		//Clases
		IPersonaConsumer<String,Integer> consumer1=new PersonaConsumerImpl();
		consumer1.accept("procesa este dato",Integer.valueOf(10));
		
		//Lambdas 
		IPersonaConsumer<String,Integer> consumer2=(cadena,numero)->{
			LOG.info("Mensaje a: "+cadena);
			LOG.info("Mensaje b: "+cadena);
			LOG.info("Mensaje c: "+numero);
		};
		consumer2.accept("procesa este dato 2",15);
		
		IPersonaConsumer<Integer,Integer> consumer3=(valor1,valor2)->{
			Integer valor3=valor1.intValue()+valor2.intValue();
			LOG.info("Valor 3="+valor3);
		};
		consumer3.accept(Integer.valueOf(5),Integer.valueOf(10));
		
		//3.- PREDICATE 
		LOG.info("3.- PREDICATE ");
		//Lambdas 
		IPersonaPredicate<String> predicate1=cadena->cadena.contains("Z");
		LOG.info("Predicate: "+predicate1.evaluar("DanielZ"));
		
		IPersonaPredicate<Integer> predicate2=numero->{
			if (numero.intValue()>10) {
				return true;
			}else {
				return false;
			}
			
		};
		LOG.info("Predicate 2: "+predicate2.evaluar(Integer.valueOf(11)));
		
		//4.- FUNCTION 
		LOG.info("4.- FUNCTION ");
		IPersonaFunction<String,Integer> function1=numero->"Valor: "+ numero.toString();
		LOG.info(function1.aplicar(Integer.valueOf(10)));
		
		IPersonaFunction<Ciudadano,Persona> function2= per->{
			Ciudadano ciu=new Ciudadano();
			ciu.setNombreCompleto(per.getNombre()+" "+per.getApellido());
			ciu.setCiudad("Sangolquí");
			return ciu;
		};
		
		Persona per1=new Persona();
		per1.setApellido("Molina");
		per1.setNombre("Daniel");
		
		Ciudadano ciudadanoConvertido=function2.aplicar(per1);
		LOG.info("Ciudadano convertido: "+ciudadanoConvertido);
		
		//5.- UnaryOperator
		LOG.info("5.- UNARY OPERATOR ");
		IPersonaUnaryOperator<String> unaryOperator=cadena->{
			String cadenaFinal=cadena.concat("-sufijo");
			return cadenaFinal;
			
		};
		
		LOG.info("UnaryOperator: "+unaryOperator.aplicar("Daniel"));
		
	}
}
