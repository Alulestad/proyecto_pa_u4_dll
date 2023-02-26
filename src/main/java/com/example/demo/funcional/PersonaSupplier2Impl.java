package com.example.demo.funcional;

public class PersonaSupplier2Impl implements IPersonaSupplier<Persona> {

	@Override
	public Persona getNombre() {
		Persona per= new Persona();
		per.setApellido("Molina1");
		per.setNombre("Daniel1");
		return per;
	}
	
	
}
