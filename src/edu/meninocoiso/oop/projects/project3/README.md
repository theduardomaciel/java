# Abstraindo um Bootcamp Usando Orientação a Objetos em Java

## Descrição

Este projeto é um exemplo de como abstrair um bootcamp de programação usando orientação a objetos em Java.

## Melhorias

- [x] Adição de uma classe mãe `Platform` para `Bootcamp` e `Dev`
- [x] Verificações de duplicatas ao criar Devs e adicioná-los a um Bootcamp
- [x] Implementação de um sistema de questionários opcionais para conteúdos da classe `Curso`
  - Os questionários são compostos de elementos da classe `Question`
  - A classe `Question` permite que perguntas tenham múltiplas respostas
  - Assim sendo, as perguntas possuem dois tipos (enum) de respostas: `MULTIPLE_CHOICE` e `TRUE_FALSE`
  - Para concluir um `Course` com questionário, o `Dev` deve responder corretamente uma porcentagem variável de
    perguntas (definida no construtor do `Course`). O padrão é 60%.
  - A classe `Questionary` é responsável por gerenciar as respostas do `Dev` ao questionário
  - Possui métodos como: `isAnswerValid`, `getCorrectAnswer`, `printOptions` e `runTest`
  - A classe `Questionary` é instanciada no construtor de `Course` e somente é acessível por um _wrapper_ que verifica a
    existência de um questionário no `Course` para o `Dev` responder.
    - Obs.: A classe está contida no mesmo arquivo de `Course` pois somente `Course` possui questionários.