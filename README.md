# Calculadora Binária em GALS

Este projeto consiste em uma calculadora que opera com números binários, implementada no Gerador de Analisadores Lexicos e Sintáticos - GALS. O código foi compilado do GALS para Java e modificado conforme necessidades e requisitos, sendo estes definidos na Disciplina de Linguagens Formais e Automatos, do curso de Ciência da Computação, da Universidade do Vale do Itajaí - UNIVALI. 

## Estrutura do Projeto

O projeto está organizado da seguinte maneira:

- **/calculadora_v2**: Contém o código fonte da calculadora, incluindo a implementação das operações matemáticas e a lógica semântica.
  - **/main/java/com/mycompany/calculadora_v2**: Código principal da calculadora.
    - `Calculadora_v2.java`: Classe principal que executa a lógica da calculadora.
  - **/main/java/lib_calculadora**: Biblioteca que contém as classes e métodos necessários para as operações (Exportados via GALS e adaptados conforme necessidade)
    - `AnalysisError.java`
    - `Constants.java`
    - `LexicalError.java`
    - `Lexico.java`
    - `ParserConstants.java`
    - `ScannerConstants.java`
    - `SemanticError.java`
    - `Semantico.java`
    - `Sintatico.java`
    - `SyntacticError.java`
    - `Token.java`
- **/target**: Pasta gerada pelo Maven que contém os arquivos compilados.
- **/test/java**: Testes do código da calculadora.
- **/GALS**: Inclui os arquivos relacionados ao GALS:
  - `calculadora_pronta.gals`: O código implementado na linguagem GALS.
  - `casos_teste_gals.txt`: Um arquivo de texto contendo os casos de teste utilizados para verificar a funcionalidade dentro do programa GALS, no simulador.
  - `codigo_gals.txt`: Um arquivo de texto que detalha a linguagem GALS, incluindo suas regras e definições.

## Requisitos

- Java JDK 22
- NetBeans IDE (versão 22 ou superior)
- Maven (para gerenciar dependências e construir o projeto)

## Como Executar

1. Clone este repositório para a sua máquina local:
   ```bash
   git clone https://github.com/diisilva/calculadora-binaria-GALS_JAVA.git

2. Abra a pasta do projeto no NetBeans IDE e faça os testes
3. Temos video no Youtube, disponivel em <https://youtu.be/aOGgdh7VBlg>.
