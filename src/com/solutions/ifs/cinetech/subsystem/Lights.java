package com.solutions.ifs.cinetech.subsystem;

public class Lights {
	
	private int level;

	//Diminui a intensidade das luzes
	public void dim(int level) {
		this.level = level; //Atribui estado
		System.out.println("Lights: Alterando para " + level);
	}
	
	//Aumenta a intensidade das luzes
	public void brighten() {
		System.out.println("Lights: Ajustando brilho...");
	}
	
	public void turnOn() {
		System.out.println("Lights: Ligando...");
	}
	
	public void turnOff() {
		System.out.println("Lights: Desligando...");
	}
	
}
