# Monitoramento de Fake News

Projeto simples em Java para identificar e armazenar notícias suspeitas de serem fake news.

## Descrição

Este sistema permite cadastrar notícias manualmente ou carregar uma classificação automática com base em uma análise de texto. O objetivo é simular um fluxo de monitoramento de fake news, classificando notícias como:

- `Confiavel`
- `Duvidosa`
- `Falsa`

## Funcionalidades

- Adicionar notícia manualmente com texto e classificação informados pelo usuário.
- Adicionar notícia automaticamente com classificação calculada por regras de análise.
- Listar todas as notícias cadastradas.
- Validar entrada de texto e classificação.

## Estrutura do projeto

- `Sistema.java`: classe principal que inicia a aplicação.
- `model/Noticia.java`: modelo de dados da notícia.
- `service/AnaliseService.java`: regras de análise para classificar notícias.
- `service/NoticiaService.java`: gerenciamento de notícias (criação, validação e armazenamento).
- `utils/ClassificacaoNoticia.java`: enumeração das classificações possíveis.
- `utils/StringValidator.java`: utilitário de validação de strings.
- `view/Menu.java`: interface de console para interação com o usuário.

## Requisitos

- Java 8 ou superior.

## Como executar

1. Abra um terminal na pasta do projeto.
2. Compile os arquivos Java:

```bash
javac Sistema.java model/Noticia.java service/AnaliseService.java service/NoticiaService.java utils/ClassificacaoNoticia.java utils/StringValidator.java view/Menu.java
```

3. Execute a aplicação:

```bash
java Sistema
```

## Uso

Ao executar o programa, o menu exibirá as opções:

1. adicionar manual
2. adicionar automatico
3. listar
4. sair

- Escolha `1` para inserir texto e classificação manualmente.
- Escolha `2` para inserir texto e deixar a análise automática definir a classificação.
- Escolha `3` para listar todas as notícias salvas.
- Escolha `4` para encerrar o sistema.

## Observações

- A classificação automática é baseada em palavras-chave simples e na extensão do texto.
- A lista de notícias é mantida em memória enquanto a aplicação estiver em execução.

## Melhorias possíveis

- Persistência em arquivo ou banco de dados.
- Interface gráfica ou web.
- Regras de análise mais avançadas baseadas em aprendizado de máquina.
- Validação e normalização de entrada mais robustas.
