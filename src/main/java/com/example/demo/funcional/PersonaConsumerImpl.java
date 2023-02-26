package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaConsumerImpl implements IPersonaConsumer<String,Integer> {

	private static final Logger LOG= LoggerFactory.getLogger(PersonaConsumerImpl.class);
	


	@Override
	public void accept(String arg1, Integer arg12) {
		// TODO Auto-generated method stub
		LOG.info("Mensaje: "+arg1);
		LOG.info("Mensaje 2: "+arg12);
		
		
	}

}
