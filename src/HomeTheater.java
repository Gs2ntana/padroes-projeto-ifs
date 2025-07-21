
import com.solutions.ifs.cinetech.facade.HomeTheaterFacade;
import java.util.Scanner;

/**
 * Responsabilidade:
 * 1. Atuar como o ponto de entrada da aplicação.
 * 2. Instanciar a Facade, que é seu ÚNICO ponto de contato com o sistema.
 * 3. Fornecer uma interface de usuário simples.
 */
public class HomeTheater {
	public static void main(String[] args) {
        //Instancia a fachada
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        //try-with-resources para garantir que o Scanner seja fechado,
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                printMenu();
                // Usamos um bloco try-catch para o caso do usuário digitar um texto
                try {
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            System.out.print("Digite o nome do filme e sua extensão (ex: IndianaJones.mkv): ");
                            String movie = scanner.nextLine();
                            System.out.print("Digite a faixa de áudio (Português e Inglês disponíveis): ");
                            String audioTrack = scanner.nextLine();
                            homeTheater.watchMovie(movie, audioTrack);
                            break;
                        case 2:
                            homeTheater.endMovie();
                            break;
                        case 3:
                            System.out.print("Digite o nome da música (ex: Queen-BohemianRhapsody.mp3): ");
                            String music = scanner.nextLine();
                            homeTheater.listenToMusic(music);
                            break;
                        case 4:
                            homeTheater.endMusic();
                            break;
                        case 0:
                            running = false;
                            System.out.println("Desligando o sistema. Até logo!");
                            break;
                        default:
                            System.out.println("Opção inválida. Por favor, tente novamente.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Por favor, digite um número válido.");
                }
            }
        }
    }

    //Menu privado, mantém o método main mais limpo.
    private static void printMenu() {
        System.out.println("\n========= CINETECH HOME THEATER =========");
        System.out.println("1. Assistir a um Filme");
        System.out.println("2. Encerrar o Filme");
        System.out.println("3. Ouvir Música");
        System.out.println("4. Encerrar a Música");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
}

