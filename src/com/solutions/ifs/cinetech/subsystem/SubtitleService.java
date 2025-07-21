package com.solutions.ifs.cinetech.subsystem;

public class SubtitleService {

	//Atributo
	private String path;
	
	//Ativa as legendas
	public void enableSubtitles() {
		System.out.println("Legendas: Ativas");
	}
	
	//Desativa quaisquer legendas
	public void disableSubtitles() {
		System.out.println("Legendas: Desativadas");
	}
	
	//Carrega legendas do diretório escolhido
	public void loadSubtitles(String path) {
		this.path = path;
		System.out.println("Legendas: Carregada de " + path);
	}
}
