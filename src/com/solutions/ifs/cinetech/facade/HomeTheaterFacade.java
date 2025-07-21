package com.solutions.ifs.cinetech.facade;

import com.solutions.ifs.cinetech.subsystem.*;

/**
 * Esta classe é o único ponto de contato para o cliente. Ela encapsula toda a
 * complexidade de interagir e orquestrar os múltiplos componentes do subsistema.
 */

public class HomeTheaterFacade {
	
    //A Facade usa este enum para se autogerenciar de forma robusta. 
    private enum SystemState {
        IDLE,           // Ocioso
        MOVIE_PLAYING,  // Assistindo a um filme
        MUSIC_PLAYING   // Ouvindo música
    }

    // O campo que armazena o estado atual do sistema.
    private SystemState currentState;
	
	// Encapsulamento dos Componentes do Subsistema
    // A Facade "possui" e gerencia o ciclo de vida de todos os componentes.
    // Eles são privados, garantindo que o cliente não possa acessá-los diretamente.
	private final AudioPlayer audioPlayer;
    private final Lights lights;
    private final PopcornMachine popcornMachine;
    private final Projector projector;
    private final SoundSystem soundSystem;
    private final SubtitleService subtitleService;
    private final TheatreScreen theatreScreen;
    private final VideoPlayer videoPlayer;
    
    
    //Injeção de dependências via construtor
    public HomeTheaterFacade() {
        this.audioPlayer = new AudioPlayer();
        this.lights = new Lights();
        this.popcornMachine = new PopcornMachine();
        this.projector = new Projector();
        this.soundSystem = new SoundSystem();
        this.subtitleService = new SubtitleService();
        this.theatreScreen = new TheatreScreen();
        this.videoPlayer = new VideoPlayer();
    }
	
	//Responsável pela sequência de ações ao assistir um filme
	public void watchMovie(String movieName, String audioTrack) {
		System.out.println("\n======================================================");
        System.out.println("### PREPARANDO PARA ASSISTIR AO FILME: " + movieName + " ###");
        System.out.println("### Faixa de Áudio Selecionada: " + audioTrack + " ###");
        System.out.println("======================================================");
        
        //Etapas para iniciar o filme
        //1. Preparar a pipoca
        popcornMachine.turnOn(); //Liga a máquina
        popcornMachine.makePopcorn(); // inicia a produção
        
        //2. Preparar o ambiente
        lights.dim(10); // Escurece as luzes para criar o ambiente.
        theatreScreen.down(); // Abaixa a tela de projeção.
        
        //3. Ajustar o projetor
        projector.turnOn();
        projector.setInput("VideoPlayer");
        projector.setResolution("1080p");
        
        //4. Configurar sistema de som
        soundSystem.turnOn();
        // Para um filme, a fonte de áudio é o VideoPlayer. O AudioPlayer (para música) não é usado.
        soundSystem.setMode("Surround 5.1");
        soundSystem.setVolume(80); // Volume maior para uma experiência imersiva.

        //5. Carregar filme com pré-configuração
        videoPlayer.load(movieName);
        
        //6. Ativar legendas
        subtitleService.loadSubtitles(movieName.replace(".mkv", ".srt"));
        subtitleService.enableSubtitles();

        //7. Enjoy!
        videoPlayer.play();
		
        this.currentState = SystemState.MOVIE_PLAYING;
	}
	
	//Responsável pela sequência de ações para ouvir música
	public void listenToMusic(String musicTrack){
		System.out.println("\n=====================================================");
        System.out.println("### PREPARANDO PARA OUVIR MÚSICA: " + musicTrack + " ###");
        System.out.println("=====================================================");

        lights.dim(50); // Um ambiente mais suave para música.
        soundSystem.turnOn();
        soundSystem.setMode("Stereo"); // Modo estéreo é mais comum para música.
        soundSystem.setVolume(65);
        
        // Aqui, a fonte de áudio é o AudioPlayer.
        audioPlayer.load(musicTrack);
        audioPlayer.play();
        
        this.currentState = SystemState.MUSIC_PLAYING;
	}
	
	//Finaliza o filme e retorna o estado padrão 
    //Executa as ações na ordem inversa para um desligamento limpo.
    public void endMovie() {
    	if (currentState != SystemState.MOVIE_PLAYING) {
            System.out.println("AVISO: Nenhum filme em reprodução para encerrar.");
            return;
        }
    	
        System.out.println("\n=============================================");
        System.out.println("### FINALIZANDO SESSÃO DE FILME ###");
        System.out.println("=============================================");

        videoPlayer.stop(); //Para o sistema áudio visual
        subtitleService.disableSubtitles(); //Desativa legendas
        projector.turnOff(); //Desliga o projetor
        soundSystem.turnOff(); //Desliga o sistema de som
        theatreScreen.up(); //Levanta a tela de projeção
        lights.turnOn(); // Acende as luzes completamente.
        popcornMachine.turnOff(); //Desliga a gostosura amanteigada (Pipoca)
        
        this.currentState = SystemState.IDLE;
    }
	
	//Finaliza a música e retorna o estado padrão
	public void endMusic() {
		if (currentState != SystemState.MUSIC_PLAYING) {
            System.out.println("AVISO: Nenhuma música em reprodução para encerrar.");
            return;
        }
		
		System.out.println("\n============================================");
        System.out.println("### FINALIZANDO SESSÃO DE MÚSICA ###");
        System.out.println("============================================");
        
        audioPlayer.stop();
        soundSystem.turnOff();
        lights.turnOn();
        
        this.currentState = SystemState.IDLE;
	}
}
