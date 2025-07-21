package com.solutions.ifs.cinetech.subsystem;

public class PopcornMachine {
	
	public void turnOn() {
		System.out.println("PopcornMachine: Ligando...");
	}
	
	public void turnOff() {
		System.out.println("PopcornMachine: Desligando...");
	}
	
	//Responsável por fazer pipoca
	public void makePopcorn() {
		System.out.println("PopcornMachine: Poc Poc! esquentando a pipoca...");
	}

}
