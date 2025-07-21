package com.solutions.ifs.cinetech.subsystem;

public class Projector {
	
	private String input;
	private String resolution;
	
	//Métodos principais
	public void turnOn() {
		System.out.println("Projetor: Ligando...");
	}
	
	public void turnOff() {
		System.out.println("Projetor: Desligando...");
	}
	
	//Atributos encapsulados
	public void setInput(String source) {
		this.input = source;
		System.out.println("Projetor: A reproduzir " + source);
	}
	
	public void setResolution(String res) {
		this.resolution = res;
		System.out.println("Projetor: Resolução " + res);
	}
	
}
