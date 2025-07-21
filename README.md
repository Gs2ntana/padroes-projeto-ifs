# CineTech Home Theater - Implementação do Padrão Facade
### Aluno: Gustavo Anthony

Este projeto é uma simulação em Java de um sistema de home theater inteligente, desenvolvido como uma aplicação prática do **Padrão de Projeto Facade**. O objetivo é demonstrar como uma fachada (`HomeTheaterFacade`) pode simplificar a interação com um conjunto complexo de subsistemas, oferecendo ao cliente uma interface unificada e de alto nível.

## Como Compilar e Executar o Projeto

Este é um projeto Java padrão e não requer dependências externas. Para compilar e executar a partir da linha de comando, siga os passos abaixo.

### Pré-requisitos
* JDK (Java Development Kit) 11 ou superior instalado e configurado no `PATH`.

### Estrutura de Diretórios
A estrutura de diretórios para este projeto é a seguinte, com a classe cliente no pacote padrão:

```
/padroes-projeto-ifs
|-- src
|   |-- HomeTheater.java
|   `-- com
|       `-- solutions
|           `-- ifs
|               `-- cinetech
|                   |-- facade
|                   |   `-- HomeTheaterFacade.java
|                   `-- subsystem
|                       |-- AudioPlayer.java
|                       |-- etc...
|-- out/
```

### 1. Compilação
Navegue até o diretório raiz do projeto (`padroes-projeto-ifs`). O comando a seguir compila todos os arquivos `.java` dentro do diretório `src` e coloca os arquivos `.class` compilados no diretório `out`, mantendo a estrutura de pacotes.

```bash
javac -d out src/**/*.java
```

### 2. Execução
Execute a aplicação a partir do diretório raiz, especificando o `classpath` para o diretório de saída (`out`). Como `HomeTheater.java` está no pacote padrão, seu nome é invocado diretamente.

```bash
java -cp out HomeTheater
```
Após a execução, um menu interativo será apresentado no console, permitindo que você utilize as funcionalidades do sistema de home theater.

---

## Decisões de Arquitetura

Além da aplicação do padrão Facade, algumas decisões de design foram tomadas para garantir a robustez e a clareza do código.

### 1. Gerenciamento de Estado nos Subsistemas
**Decisão:** Os subsistemas (como `VideoPlayer` e `AudioPlayer`) não utilizam o construtor para receber o nome da mídia (`fileName`, `trackName`). Em vez disso, usam um método `load()`.

**Motivação:** Um subsistema como o `VideoPlayer` foi modelado para ser um **componente reutilizável**, análogo a um aparelho de Blu-ray físico. Você não compra um aparelho novo para cada filme. Você usa o mesmo aparelho e apenas troca o disco. Da mesma forma, a `Facade` instancia o `VideoPlayer` uma única vez e o reutiliza, apenas alterando seu estado interno (o filme carregado) através do método `load()`.

### 2. Gerenciamento de Estado na Fachada
**Decisão:** A `HomeTheaterFacade` utiliza um `enum` privado (`SystemState`) para gerenciar seu estado interno (`IDLE`, `MOVIE_PLAYING`, `MUSIC_PLAYING`).

**Motivação:** Para evitar operações ilógicas (como chamar `endMovie()` quando nenhum filme está tocando), a `Facade` atua como uma Máquina de Estados. Ela só permite transições válidas (ex: não se pode iniciar um filme se o sistema não estiver ocioso). O `enum` é `private` porque este gerenciamento de estado é um **detalhe de implementação encapsulado**, sobre o qual o cliente não precisa saber.

### 3. Diferença entre `SoundSystem` e `AudioPlayer`
**Decisão:** O sistema foi projetado com dois componentes de áudio distintos para refletir uma arquitetura real e o Princípio da Responsabilidade Única.

**Motivação:**
* **`AudioPlayer`**: É um **dispositivo de origem**, responsável por ler e decodificar uma mídia de música específica (ex: um CD player ou um app de streaming).
* **`SoundSystem`**: É um **dispositivo de saída**, responsável por amplificar um sinal de áudio e distribuí-lo no ambiente (ex: um receiver com caixas de som). Ele pode receber o som tanto do `VideoPlayer` (durante um filme) quanto do `AudioPlayer` (durante uma sessão de música). A `Facade` é quem decide qual fonte conectar.
