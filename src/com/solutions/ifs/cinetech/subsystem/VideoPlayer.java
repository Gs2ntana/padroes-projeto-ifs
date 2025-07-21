package com.solutions.ifs.cinetech.subsystem;


// Classe responsável pela reprodução de vídeos
public class VideoPlayer {
	
	//Atributo
	private String fileName;
	
	//Método para informar que o filme escolhido está sendo preparado
	public void load(String fileName) {
		this.fileName = fileName; //Atribui o nome ao estado interno
		System.out.println("Carregando: " + fileName);
	}
	
	//Inicia o filme escolhido
	public void play() {
		//Validação de defesa caso o estado seja inválido
		if(this.fileName == null || this.fileName.isEmpty()) {
			System.out.println("Nenhum filme escolhido.");
			return;
		}
		System.out.println("Iniciando... " + fileName);
	}
	
	//Interrompe com possibilidade de continuação de onde parou
	public void pause() {
		System.out.println("O filme será interrompido, mas poderá ser continuado");
	}
	
	//Interrompe e finaliza a reprodução
	public void stop() {
		System.out.println("o vídeo será fechado.");
		this.fileName = null; //Limpa o estado do objeto
	}
}
