# 🎮 Jogo de Sudoku em Java

Um jogo de Sudoku interativo desenvolvido em Java que roda no terminal, permitindo ao jogador resolver puzzles clássicos de Sudoku com interface de linha de comando.

## 📋 Funcionalidades

### ✅ Funcionalidades Principais
- ✅ Iniciar novo jogo com configuração personalizada
- ✅ Inserir números nas células editáveis
- ✅ Remover números das células
- ✅ Visualizar o tabuleiro atual formatado
- ✅ Verificar status do jogo (não iniciado, incompleto, completo)
- ✅ Detectar erros automaticamente
- ✅ Limpar todo o progresso do jogo
- ✅ Finalizar jogo com verificação automática
- ✅ Interface interativa no terminal

### 🚀 Funcionalidades Avançadas  
- ✅ **Sistema de dicas** - Sugere valores possíveis para cada posição
- ✅ **Desfazer movimento** - Reverte o último movimento realizado
- ✅ **Validação em tempo real** - Impede movimentos inválidos
- ✅ **Histórico de movimentos** - Sistema completo de undo/redo
- ✅ **Detecção de erros** - Identifica conflitos no tabuleiro
- ✅ **Tratamento de exceções** - Gerencia entradas inválidas do usuário

## 🛠️ Tecnologias Utilizadas

- **Java 17+** - Linguagem de programação
- **Scanner** - Para entrada de dados no terminal
- **Collections Framework** - Para estruturas de dados
- **Stream API** - Processamento funcional
- **Enum** - Estados do jogo
- **Stack** - Histórico de movimentos

## 📁 Estrutura do Projeto

```
jogoSudoku/
└── sudoku/
    └── src/
        └── br/
            └── com/
                └── dio/
                    ├── Main.java              # Classe principal com menu
                    ├── model/
                    │   ├── Board.java         # Lógica do tabuleiro
                    │   ├── Space.java         # Representação de cada célula
                    │   ├── GameStatusEnum.java # Status do jogo
                    │   └── MoveHistory.java   # Histórico de movimentos
                    └── util/
                        ├── BoardTemplate.java # Template visual do tabuleiro
                        └── HintSystem.java    # Sistema de dicas
```

## 🚀 Como Executar

### 1. Navegue para o diretório correto:
```bash
cd jogoSudoku/sudoku/src
```

### 2. Compile o projeto:
```bash
javac br/com/dio/*.java br/com/dio/model/*.java br/com/dio/util/*.java
```

### 3. Execute o jogo:
```bash
java br.com.dio.Main "0,0;4,false" "1,0;7,false" "2,0;9,true" "3,0;5,false" "4,0;8,true" "5,0;6,true" "6,0;2,true" "7,0;3,false" "8,0;1,false" "0,1;1,false" "1,1;3,true" "2,1;5,false" "3,1;4,false" "4,1;7,true" "5,1;2,false" "6,1;8,false" "7,1;9,true" "8,1;6,true" "0,2;2,false" "1,2;6,true" "2,2;8,false" "3,2;9,false" "4,2;1,true" "5,2;3,false" "6,2;7,false" "7,2;4,false" "8,2;5,true" "0,3;5,true" "1,3;1,false" "2,3;3,true" "3,3;7,false" "4,3;6,false" "5,3;4,false" "6,3;9,false" "7,3;8,true" "8,3;2,false" "0,4;8,false" "1,4;9,true" "2,4;7,false" "3,4;1,true" "4,4;2,true" "5,4;5,true" "6,4;3,false" "7,4;6,true" "8,4;4,false" "0,5;6,false" "1,5;4,true" "2,5;2,false" "3,5;3,false" "4,5;9,false" "5,5;8,false" "6,5;1,true" "7,5;5,false" "8,5;7,true" "0,6;7,true" "1,6;5,false" "2,6;4,false" "3,6;2,false" "4,6;3,true" "5,6;9,false" "6,6;6,false" "7,6;1,true" "8,6;8,false" "0,7;9,true" "1,7;8,true" "2,7;1,false" "3,7;6,false" "4,7;4,true" "5,7;7,false" "6,7;5,false" "7,7;2,true" "8,7;3,false" "0,8;3,false" "1,8;2,false" "2,8;6,true" "3,8;8,true" "4,8;5,true" "5,8;1,false" "6,8;4,true" "7,8;7,false" "8,8;9,false"
```

## 🎯 Como Jogar

### Menu Principal
```
1 - Iniciar um novo Jogo
2 - Colocar um novo número
3 - Remover um número
4 - Visualizar jogo atual
5 - Verificar status do jogo
6 - Limpar jogo
7 - Finalizar jogo
8 - Sair
9 - Obter dica
10 - Desfazer último movimento
```

### Passos para Jogar
1. **Inicie o programa** e escolha a opção `1`
2. **Insira números** usando a opção `2` (coluna, linha, valor)
3. **Use dicas** com a opção `9` para valores possíveis
4. **Desfaça movimentos** com a opção `10` se necessário
5. **Finalize** com a opção `7` quando completar

### Inserindo Números
1. Escolha a opção **2**
2. Digite a **coluna** (0-8): onde 0 é a primeira coluna à esquerda
3. Digite a **linha** (0-8): onde 0 é a primeira linha no topo
4. Digite o **valor** (1-9): o número que deseja inserir

### Regras do Sudoku
- Complete o tabuleiro 9x9 com números de 1 a 9
- Cada linha deve conter todos os números de 1 a 9
- Cada coluna deve conter todos os números de 1 a 9
- Cada quadrante 3x3 deve conter todos os números de 1 a 9
- Números fixos não podem ser alterados

## ⚙️ Funcionalidades Técnicas

### Sistema de Validação
- Verifica regras do Sudoku (linha, coluna, quadrante 3x3)
- Impede sobrescrita de valores fixos
- Validação em tempo real durante inserção

### Sistema de Dicas
- Calcula valores possíveis para cada posição
- Considera todas as regras do Sudoku
- Interface amigável com emojis

### Sistema de Histórico
- Armazena todos os movimentos do jogador
- Funcionalidade completa de desfazer
- Preserva estado anterior das células

## 🔧 Formato dos Argumentos

Os argumentos seguem o padrão: `"coluna,linha;valor_esperado,é_fixo"`

- **coluna,linha**: Posição no tabuleiro (0-8)
- **valor_esperado**: Número correto para essa posição (1-9)
- **é_fixo**: `true` para números pré-preenchidos, `false` para espaços editáveis

## 📊 Status do Jogo

- **Não iniciado**: Nenhum número foi inserido pelo jogador
- **Incompleto**: Ainda há espaços vazios
- **Completo**: Todos os espaços foram preenchidos

## 🎨 Interface

O jogo utiliza um template ASCII art para exibir o tabuleiro formatado no terminal.

## 🎯 Exemplos de Uso

### Obter Dica
```
Informe a coluna: 0
Informe a linha: 2
💡 Valores possíveis: [1, 4, 6, 8]
```

### Desfazer Movimento
```
✅ Último movimento desfeito!
```

### Movimento Inválido
```
❌ Movimento inválido! Número já existe na linha, coluna ou quadrante.
```

## ⚠️ Tratamento de Erros

- Validação de entrada para números fora do intervalo
- Proteção contra alteração de números fixos
- Detecção automática de erros no tabuleiro
- Verificação de completude do jogo
- Tratamento de entradas inválidas (texto em vez de números)

## 🏆 Exemplo de Vitória

Quando completar corretamente o Sudoku:
```
Parabéns você concluiu o jogo
[Tabuleiro completo será exibido]
```

## 🤝 Contribuição

Este projeto foi desenvolvido como parte de um curso da DIO (Digital Innovation One). Sinta-se à vontade para fazer melhorias e contribuições.

## 📄 Licença

Este projeto é de uso educacional e está disponível para fins de aprendizado.
