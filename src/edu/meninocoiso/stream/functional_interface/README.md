# Functional Interface

Qualquer interface com um SAM (Single Abstract Method) é uma interface funcional e sua implementação pode ser tratada
como expressões Lambda.

- `Consumer<T>`: Representa uma operação que aceita um argumento do tipo T e não retorna nenhum resultado.  
  É utilizada principalmente para **realizar ações ou efeitos colaterais** nos elementos do Stream **sem modificar ou
  retornar um valor**.

```java
public class ConsumerExample {
	public static void main(String[] args) {
		// Criamos uma lista de números inteiros
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		// Usamos o Consumer com uma expressão Lambda para imprimir números pares
		Consumer<Integer> printEvenNumber = number -> {
			if (number % 2 == 0) {
				System.out.println(number);
			}
		};
		
		// Usamos o Consumer para imprimir números pares no Stream
		numbers.stream_api().forEach(printEvenNumber);
	}
}
```

```java
public class ConsumerExample {
	public static void main(String[] args) {
		// Criamos uma lista de números inteiros
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		// Usamos o Consumer com uma classe anônima para imprimir números pares
		Consumer<Integer> printEvenNumber = new Consumer<Integer>() {
			@Override
			public void accept(Integer number) {
				if (number % 2 == 0) {
					System.out.println(number);
				}
			}
		};
		
		// Usamos o Consumer para imprimir números pares da lista por meio da classe anônima
		for (Integer number : numbers) {
			printEvenNumber.accept(number);
		}
	}
}
```

- `Supplier<T>`: Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T.  
  É comumente usada para **criar ou fornecer novos objetos** de um determinado tipo.

```java
public class SupplierExample {
	public static void main(String[] args) {
		// Usamos o Supplier com expressão Lambda para fornecer uma saudação personalizada
		Supplier<String> greeting = () -> "Olá, seja bem-vindo(a)!";
		
		// Usamos o Supplier para obter uma lista com 5 saudações
		List<String> greetingsList = Stream.generate(greeting)
				.limit(5)
				.collect(Collectors.toList());
		
		// Imprimimos as saudações geradas
		greetingsList.forEach(System.out::println);
	}
}
```

```java
public class SupplierExample {
	public static void main(String[] args) {
		// Usamos o Supplier com uma classe anônima para fornecer uma saudação personalizada
		Supplier<String> greeting = new Supplier<String>() {
			@Override
			public String get() {
				return "Olá, seja bem-vindo(a)!";
			}
		};
		
		// Usamos o Supplier para obter uma lista com 5 saudações
		List<String> greetingsList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			greetingsList.add(greeting.get());
		}
		
		// Imprimimos as saudações geradas
		for (String generatedGreeting : greetingsList) {
			System.out.println(generatedGreeting);
		}
	}
}
```

- `Function<T, R>`: Representa uma função que aceita um argumento do tipo T e retorna um resultado do tipo R.  
  É utilizada para **transformar ou mapear** os elementos do Stream em outros valores ou tipos.

```java
public class FunctionExample {
	public static void main(String[] args) {
		// Criamos uma lista de números inteiros
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		// Usamos a Function com expressão Lambda para dobrar todos os números
		Function<Integer, Integer> doubleNums = number -> number * 2;
		
		// Usamos a função para dobrar todos os números no Stream e armazená-los em outra lista
		List<Integer> doubledNumbers = numbers.stream_api()
				.map(doubleNums)
				.collect(Collectors.toList());
		
		// Imprimimos a lista de números dobrados
		doubledNumbers.forEach(System.out::println);
	}
}
```

```java
public class FunctionExample {
	public static void main(String[] args) {
		// Criamos uma lista de números inteiros
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		// Usamos a Function com uma classe anônima para dobrar todos os números
		Function<Integer, Integer> doubleNums = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer number) {
				return number * 2;
			}
		};
		
		// Usamos a função para dobrar todos os números e armazená-los em outra lista
		List<Integer> doubledNumbers = new ArrayList<>();
		for (Integer number : numbers) {
			doubledNumbers.add(doubleNums.apply(number));
		}
		
		// Imprimimos a lista de números dobrados
		for (Integer doubledNumber : doubledNumbers) {
			System.out.println(doubledNumber);
		}
	}
}
```

- `Predicate<T>`: Representa uma função que aceita um argumento do tipo T e retorna um valor booleano (verdadeiro ou
  falso).  
  É comumente usada para **filtrar os elementos** do Stream com base em alguma condição.

```java
public class PredicateExample {
	public static void main(String[] args) {
		// Criamos uma lista de números inteiros
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// Usamos o Predicate com expressão Lambda para filtrar números pares
		Predicate<Integer> isEven = number -> number % 2 == 0;
		
		// Usamos o predicado para filtrar números pares no Stream e armazená-los em outra lista
		List<Integer> evenNumbers = numbers.stream_api()
				.filter(isEven)
				.collect(Collectors.toList());
		
		// Imprimimos a lista de números pares
		evenNumbers.forEach(System.out::println);
	}
}
```

```java
public class PredicateExample {
	public static void main(String[] args) {
		// Criamos uma lista de números inteiros
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// Usamos o Predicate com uma classe anônima para filtrar números pares
		Predicate<Integer> isEven = new Predicate<Integer>() {
			@Override
			public boolean test(Integer number) {
				return number % 2 == 0;
			}
		};
		
		// Usamos o predicado para filtrar números pares e armazená-los em outra lista
		List<Integer> evenNumbers = new ArrayList<>();
		for (Integer number : numbers) {
			if (isEven.test(number)) {
				evenNumbers.add(number);
			}
		}
		
		// Imprimimos a lista de números pares
		for (Integer evenNumber : evenNumbers) {
			System.out.println(evenNumber);
		}
	}
}
```

- `BinaryOperator<T>`: Representa uma operação que combina dois argumentos do tipo T e retorna um resultado do mesmo
  tipo T.  
  É usada para realizar operações de **redução em pares de elementos**, como somar números ou combinar objetos.

```java
public class BinaryOperatorExample {
	public static void main(String[] args) {
		// Criamos uma lista de números inteiros
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		// Usamos o BinaryOperator com expressão Lambda para somar dois números inteiros
		BinaryOperator<Integer> sum = (num1, num2) -> num1 + num2;
		
		// Usamos o BinaryOperator para somar todos os números no Stream
		int resultado = numbers.stream_api()
				.reduce(0, sum);
		
		// Imprimimos o resultado da soma
		System.out.println("A soma dos números é: " + resultado);
	}
}
```

> **Obs.:** O método `reduce(T identity, BinaryOperator<T> accumulator)` recebe como argumentos:
> - **identity:** um valor inicial _(por exemplo, 0)_
>- **accumulator:** uma função de acumulação que combina dois elementos do Stream.

```java
public class BinaryOperatorExample {
	public static void main(String[] args) {
		// Criamos uma lista de números inteiros
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		// Usamos o BinaryOperator com classe anônima para somar dois números inteiros
		BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer num1, Integer num2) {
				return num1 + num2;
			}
		};
		
		// Usamos o BinaryOperator para somar todos os números no Stream
		int resultado = numbers.stream_api()
				.reduce(0, sum);
		
		// Imprimimos o resultado da soma
		System.out.println("A soma dos números é: " + resultado);
	}
}
```

> **Classe Anônima**:
> Em Java, são classes que não receberam um nome e **são tanto declaradas, quanto instanciadas em uma única instrução
**.  
> Deve-se considerar o uso de uma _Classe Anônima_ sempre que for necessário criar uma classe que será instanciada
> apenas uma vez.

---

### Referências:

[1] "Java 8 Functional Interfaces." Baeldung. Disponível em: https://www.baeldung.com/java-8-functional-interfaces.

[2] "Como utilizar uma classe anônima em Java." FAQ CartX. Disponível
em: https://faqcartx.info/programa%C3%A7%C3%A3o/40977-como-utilizar-uma-classe-an%C3%B4nima-em-java.html.

[3] "Ganhando Produtividade com Stream API no Java - cami-la." GitHub. Disponível
em: https://github.com/digitalinnovationone/ganhando_produtividade_com_Stream_API_Java
