package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaConsumer <T,R>{
	public void accept(T arg1,R arg12);
}
