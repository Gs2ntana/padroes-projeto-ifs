package com.solutions.ifs.cinetech.subsystem;

public class AudioPlayer {

	private String trackName;
	private int volume;

	//Construtor para inicialização de áudio padrão ao instanciar o objeto
	public AudioPlayer() {
		this.volume = 60; //Volume seguro
		System.out.println("Áudio: Online. " + "Volume Atual: " + this.volume + "%");
	}
	
	public void load(String trackName){
		this.trackName = trackName;
				
		System.out.println("Carregando: " + trackName);
	}
	
	//Inicia o áudio escolhido
	public void play() {
		//Validação de defesa caso o estado seja inválido
		if(this.trackName == null || this.trackName.isEmpty()) {
			System.out.println("Nenhum áudio escolhido.");
			return;
		}
		System.out.println("Iniciando..." + "Volue:" + volume + "%");
	}
	
	//Interrompe com possibilidade de continuação
	public void pause() {
		System.out.println("O áudio será interrompido, mas poderá ser continuado");
	}
	
	//Interrompe e finaliza a reprodução
	public void stop() {
		System.out.println("o vídeo será fechado.");
		this.trackName = null; //Limpa o estado do objeto
	}
	
	//Prática de encapsulamento
	public void setVolume(int level) {
		System.out.println("O volume será ajustado para " + level + "%");
		this.volume = level;
	}
	
}
