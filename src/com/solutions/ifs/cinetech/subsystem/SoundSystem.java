package com.solutions.ifs.cinetech.subsystem;

public class SoundSystem {
	
	private int volume;
	private String mode;
	
	// Um padrão inicial seguro para som
	public SoundSystem() {
        this.volume = 60; 
    }
	
	//Métodos principais
	public void turnOn() {
		System.out.println("SoundSystem: Ligando...");
	}
	
	public void turnOff() {
		System.out.println("SoundSystem: Desligando...");
	}

	// O volume principal do ambiente
	public void setVolume(int level) {
		this.volume = level;
		System.out.println("SoundSystem: volume ajustado " + level);
	}
	
	
	//Difine se será stereo, surround...
	public void setMode(String mode) {
		this.mode = mode;
		System.out.println("SoundSystem: modo alterado para " + mode);
	}
}
