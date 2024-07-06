# Comparable vs Comparator

## Comparable

- `Comparable` fornece uma única sequência de ordenação. Em outras palavras, podemos ordenar a coleção com base em um único elemento, como id, nome e preço.
- `Comparable` afeta a classe original, ou seja, a classe precisa implementar a interface `Comparable` e sobrescrever o método `compareTo()`.
- `Comparable` fornece o método `compareTo()` para ordenar elementos.
- `Comparable` está presente no pacote `java.lang`.
- Podemos ordenar os elementos da lista (list) do tipo `Comparable` usando o método `Collections.sort(List)`.

## Comparator

- O `Comparator` fornece o método `compare()` para ordenar elementos.
- O `Comparator` fornece múltiplas sequências de ordenação. Em outras palavras, podemos ordenar a coleção com base em múltiplos elementos, como id, nome, preço, etc.
- O `Comparator` não afeta a classe original, ou seja, a classe não precisa implementar a interface `Comparator`, no entanto, é necessário criar uma classe separada que implementa a interface `Comparator`.
- Um `Comparator` está presente no pacote `java.util`.
- Podemos ordenar os elementos da lista chamada "list" do tipo `Comparator` usando os métodos `list.sort([classe Comparator])` ou `Collections.sort(List, Comparator)` (mais antigo).

## Collections

- A classe `Collections` é uma classe utilitária do Java para operações comuns em coleções.
- Ela fornece métodos para:
  1. ordenação
  2. busca
  3. manipulação 
  4. e sincronização de coleções.
- O método `sort()` é usado para ordenar uma lista em ordem ascendente.
- O método `sort()` em conjunto com `Collections.reverseOrder()` permite ordenar em ordem descendente.

### Referências:

[1] "Comparable vs Comparator in Java." GeeksforGeeks. Disponível em: https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/.

[2] "Difference between Comparable and Comparator in Java." JavaTpoint. Disponível em: https://www.javatpoint.com/difference-between-comparable-and-comparator.

[3] "Java™ Platform, Standard Edition 17 API Specification - Class Collections." Oracle. Disponível em: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collections.html.

[4] "Collections Java API - Camila Cavalcante" Disponível em: https://github.com/cami-la/collections-java-api-2023