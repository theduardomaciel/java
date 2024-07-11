# Ganhando Produtividade com Stream API e Java

- A `Stream API` traz uma nova opção para a manipulação de coleções (`Collections`) em Java, seguindo os princípios da *
  *programação funcional**.
- Stream, trata-se de uma poderosa solução para processar coleções de **maneira declarativa**, ao invés da tradicional e
  burocrática forma imperativa.

```java
public class ShoppingCart {
	// Atributos
	private List<Item> cartItems;
	
	// Construtor
	public ShoppingCart() {
		this.cartItems = new ArrayList<>();
	}

	// Método para calcular o valor total dos itens (sem utilizar a Stream API)
	public double calculateTotalValue() {
		if (cartItems.isEmpty()) {
			throw new RuntimeException("A lista está vazia!");
		}

		double totalValue = 0d;
		for (Item item : cartItems) {
			double valorItem = item.getPreco() * item.getQuant();
			totalValue += valorItem;
		}
		return totalValue;
	}
}
```

- Na forma imperativa, para realizar uma soma simples, por exemplo, O(a) dev tem que se preocupar não apenas com o que
  deve ser feito em cada elemento, isto é, com as regras associadas ao processamento dos elementos da lista, mas também
  com a maneira de realizar essa iteração.

```java
public class ShoppingCart {
	// Atributos
	private List<Item> cartItems;
	
	// Construtor
	public ShoppingCart() {
		this.cartItems = new ArrayList<>();
	}

	// Método para calcular o valor total dos itens (utilizando o Stream API)
	public double calculateTotalValue() {
		if (cartItems.isEmpty()) {
			throw new RuntimeException("A lista está vazia!");
		}
		
		return cartItems.stream()
				.mapToDouble(item -> item.getPreco() * item.getQuant())
				.sum();
	}
}
```

- Combinada com as **Expressões Lambda** e **Method reference**, a `Stream API` proporciona uma forma diferente de lidar
  com conjuntos de elementos, oferecendo aO(a) dev uma maneira simples e concisa de escrever código que resulta em
  facilidade de manutenção e paralelização sem efeitos indesejados em tempo de execução.

- As operações na Stream API podem ser classificadas em **duas categorias** principais:
  1. **Operações Intermediárias:** são aquelas que _retornam uma nova Stream_ e permitem encadear várias operações,
     formando um pipeline de processamento de dados. São elas:
    - `filter(Predicate<T> predicate)`: Filtra os elementos da _Stream_ com base em um predicado. Retorna uma nova
      _Stream_ contendo apenas os elementos que atendem ao critério do predicado.  
      Exemplo: ` stream.filter(n -> n > 5)`
    - `map(Function<T, R> mapper)`: Transforma cada elemento da _Stream_ usando a função especificada e retorna uma nova
      _Stream_ contendo os elementos resultantes.  
      Exemplo: `stream.map(s -> s.toUpperCase())`
    - `sorted()`: Classifica os elementos da _Stream_ em ordem natural (se os elementos forem comparáveis) ou de acordo
      com um comparador fornecido.  
      Exemplos:
      - `stream.sorted()`
      - `stream.sorted(Comparator.reverseOrder())`
    - `distinct()`: Remove elementos duplicados da _Stream_, considerando a implementação do método equals() para
      comparação.  
      Exemplo: `stream.distinct()`
    - `limit(long maxSize)`: Limita o número de elementos da _Stream_ aos maxSize primeiros elementos.  
      Exemplo: `stream.limit(10)`
    - `skip(long n)`: Pula os primeiros n elementos da _Stream_ e retorna uma nova _Stream_ sem eles.  
      Exemplo: `stream.skip(5)`

  2. **Operações Terminais:** são aquelas que _encerram o pipeline_ e produzem um produto final. São elas:
    - `forEach(Consumer<T> action)`: Executa uma ação para cada elemento da _Stream_.  
      Exemplo: `stream.forEach(System.out::println)`
      > **Obs.:** O método `System.out::println` é um exemplo de **Method Reference**.
    - `toArray()`: Converte a _Stream_ em um array contendo os elementos da _Stream_.  
      Exemplo: `stream.toArray()`
    - `collect(Collector<T, A, R> collector)`: Coleta os elementos da _Stream_ em uma estrutura de dados específica,
      como uma lista ou um mapa.  
      Exemplos:
      - `stream.collect(Collectors.toList())`
      - `stream.collect(Collectors.toSet())`
    - `count()`: Retorna o número de elementos na _Stream_.  
      Exemplo: `stream.count()`
    - `anyMatch(Predicate<T> predicate)`: Verifica se algum elemento da _Stream_ atende ao predicado especificado.  
      Exemplo: `stream.anyMatch(s -> s.startsWith("A"))`
    - `allMatch(Predicate<T> predicate)`: Verifica se todos os elementos da _Stream_ atendem ao predicado
      especificado.  
      Exemplo: `stream.allMatch(n -> n > 0)`
    - `noneMatch(Predicate<T> predicate)`: Verifica se nenhum elemento da _Stream_ atende ao predicado especificado.  
      Exemplo: `stream.noneMatch(s -> s.isEmpty())`
    - `min(Comparator<T> comparator)` e `max(Comparator<T> comparator)`: Encontram o elemento mínimo ou máximo da
      _Stream_, respectivamente, conforme o comparador fornecido.  
      Exemplos:
      - `stream.min(Comparator.naturalOrder())`
      - `stream.max(Comparator.naturalOrder())`
    - `reduce(T identity, BinaryOperator<T> accumulator)`: Combina os elementos da _Stream_ usando o acumulador
      especificado e retorna o resultado final.  
      Exemplo: `stream.reduce(0, (a, b) -> a + b)`

### Lambda

- As expressões Lambda permitem escrever código no estilo funcional, representando as **interfaces funcionais** (
  interfaces com um único método abstrato) de forma mais concisa
- As **interfaces funcionais** desempenham um papel crucial na programação funcional em Java, pois servem de base para o
  uso de expressões Lambda.
- Uma função Lambda é uma função sem declaração, isto é, não é necessário colocar um nome, um tipo de retorno ou um
  modificador de acesso.  
  _A ideia é que o método seja declarado no mesmo lugar em que será usado!_
- As funções Lambda em Java tem a sintaxe definida como:  
  `(argumento) -> (corpo)`.

```java
public class PersonSort {
	//atributo
	private List<Pessoa> personList;

	//construtor
	public PersonSort() {
		this.personList = new ArrayList<>();
	}

	public List<Pessoa> sortByHeight() {
		if (personList.isEmpty()) {
      throw new RuntimeException("A lista está vazia!");
    }

	  List<Pessoa> peopleByHeight = new ArrayList<>(personList);
	  peopleByHeight.sort((p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura()));
	  return peopleByHeight;
	}
}
```

### Method Reference

- Method Reference é um novo recurso do Java 8 que permite referenciar um método ou construtor de uma classe (de forma
  funcional) e assim indicar que ele deve ser utilizado num ponto específico do código, tornando a leitura mais simples
  e concisa.
- Para utilizá-lo, basta informar uma classe ou referência seguida do símbolo “::” e o nome do método sem os parênteses
  no final.

```java
public class PersonSort {
	//atributo
	private List<Pessoa> personList;

	//construtor
	public PersonSort() {
		this.personList = new ArrayList<>();
	}

	public List<Pessoa> sortByHeight() {
		if (!personList.isEmpty()) {
			List<Pessoa> peopleByHeight = new ArrayList<>(personList);
			peopleByHeight.sort(Comparator.comparingDouble(Pessoa::getAltura));
			return peopleByHeight;
		} else {
			throw new RuntimeException("A lista está vazia!");
		}
	}
}
```

---

### Referências

[1] "Java Stream API - Oracle." Oracle Brasil. Disponível
em: https://www.oracle.com/br/technical-resources/articles/java-stream-api.html.

[2] "Java Collections API Examples - cami-la." GitHub. Disponível
em: https://github.com/cami-la/collections-java-api-2023.

[3] "Como usar funções functional_interface em Java - DevMedia." DevMedia. Disponível
em: https://www.devmedia.com.br/como-usar-funcoes-lambda-em-java/32826.

[4] "Ganhando Produtividade com Stream API no Java - cami-la." GitHub. Disponível
em: https://github.com/digitalinnovationone/ganhando_produtividade_com_Stream_API_Java
