# 🧩 Maze Solver

*Este projeto é um sistema para resolver labirintos utilizando a técnica de backtracking e exibindo a solução graficamente.*

# 👥 Autores

- Davidson Carvalho dos Santos - [@Davidsonnj](https://github.com/Davidsonnj)
- Thiago Borges Pereira [@BPThiago](https://github.com/BPThiago)

# 🌟 Funcionalidades

- **Carregamento de Labirintos**: Labirintos são carregados a partir de arquivos CSV, onde os números "1" representam caminhos possíveis e "0" representam paredes.
- **Algoritmo de Backtracking**: Utiliza a técnica de backtracking para encontrar a saída do labirinto a partir de um ponto de entrada.
- **Visualização Gráfica**: O labirinto e o percurso de solução são visualizados utilizando Swing, com animação do movimento através de um temporizador (Timer).
- **Movimento Animado**: Cada passo da solução é desenhado em intervalos de 500ms, mostrando o avanço pelo labirinto até a saída.

# 🚀 Tecnologias Utilizadas

- **Java SE**: Linguagem de programação utilizada para implementar a lógica do labirinto e a interface gráfica.
- **Swing**: Biblioteca Java para construção da interface gráfica.
- **AWT (Abstract Window Toolkit)**: Utilizado para componentes gráficos e controle de eventos.

# 📦 Estrutura do Projeto

- **Maze**: Classe responsável por carregar, representar e processar o labirinto. Contém o algoritmo de backtracking para resolver o labirinto.
- **Node**: Classe que representa os nós do labirinto (coordenadas x e y), utilizados durante o percurso.
- **MazePanel**: Classe que desenha o labirinto e anima o percurso da solução.
- **Main**: Classe principal que inicializa a interface gráfica e exibe o labirinto.

### Arquivos CSV

O projeto utiliza arquivos CSV para representar labirintos, onde:

- `1`: Representa os caminhos válidos.
- `0`: Representa as paredes ou barreiras.


# 📂 Estrutura de Arquivos

- **Main.java**: Inicializa a interface gráfica com o labirinto.
- **Maze.java**: Carrega e resolve o labirinto utilizando backtracking.
- **MazePanel.java**: Desenha o labirinto e a solução com animação.
- **Node.java**: Representa um ponto (nó) no labirinto com coordenadas x e y.

# 🎮 Como Executar

1. Clone o repositório:

   ```bash
   https://github.com/BPThiago/labirinto-java.git

2. Compile o código utilizando uma IDE Java ou pelo terminal:

   ```bash
   javac br/ifes/tecprogavancada/labirinto/*.java

3. Execute o programa:

   ```bash
   java br.ifes.tecprogavancada.labirinto.Main

4. Observação: Certifique-se de que o arquivo CSV do labirinto esteja no caminho especificado no código (mazes/6x8.csv) ou ajuste conforme necessário.

# 📝 Personalização

Você pode alterar o labirinto usado na aplicação modificando a linha:

> Maze maze = new Maze("mazes/6x8.csv")

# 🧠 Conceitos Utilizados

- Backtracking: Algoritmo de busca utilizado para encontrar soluções em problemas que requerem exploração de várias alternativas, voltando atrás sempre que necessário (retrocedendo quando uma rota se mostra inviável).
- Estrutura de Dados Stack (Pilha): Utilizada para manter o histórico de posições durante a exploração do labirinto.

   
