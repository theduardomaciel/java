# Generics Type

- Um tipo genérico é uma **classe** genérica ou uma **interface**, a qual é parametrizada em relação a tipos.
- A classe `Box` a seguir será modificada para demonstrar o conceito:

```java
public class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```

-  O símbolo `<>` é chamado de "diamond" ou "diamond operator" e foi um recurso introduzido no Java 7, usado em tipos genéricos no Java para que seja possível inferir automaticamente o tipo com base no contexto.
- Para atualizar a classe `Box` para usar **Generics**, é necessário criar uma declaração de tipo genérico alterando o código de `public class Box` para `public class Box<T>`.
- Essa mudança introduz a variável de tipo `T`, que pode ser usada em qualquer lugar dentro da classe, como no exemplo a seguir:

```java
/**
Versão genérica da classe Box.
@param <T> o tipo do valor sendo utilizado na caixa
*/
public class Box<T> {
	// T representa "Type" (tipo)
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
```

- Como é possível visualizar, todas as ocorrências de `Object` foram substituídas por `T`.
- Uma variável de tipo pode assumir qualquer tipo não primitivo especificado: classes, interfaces, arrays ou até mesmo outra variável de tipo.
- Essa mesma técnica pode ser aplicada para criar interfaces genéricas.
- Os nomes de parâmetros de tipo mais comumente usados são:
    - E - Elemento (usado extensivamente pelo Java Collections Framework)
    - K - Chave
    - N - Número
    - T - Tipo
    - V - Valor
    - S, U, V, etc. - 2º, 3º, 4º tipos

### Vantagens simples de usar generics nas interfaces Collection em Java:

1. **Segurança do tipo de dados**: O uso de **Generics** garante que _apenas objetos de um tipo específico possam ser adicionados à coleção_, evitando erros de tipo e garantindo que os dados lidados estejam corretos.
2. **Código mais legível**: Ao usar os Generics, é possível especificar o tipo de dados esperado ou retornado pela Collection, o que torna o código mais fácil de entender e ler.
3. **Detecção de erros mais cedo**: O compilador verifica se os tipos corretos estão sendo utilizados durante a compilação, identificando, assim, erros de tipo antes mesmo de executar o programa.
4. **Reutilização de código**: Com os Generics, é possível criar _classes_ e _métodos_ genéricos que funcionam com diferentes tipos de Collections, evitando a necessidade de duplicar código para cada tipo específico.
5. **Melhor desempenho**: O uso de generics pode melhorar o desempenho, pois evita a necessidade de conversões de tipo desnecessárias e permite que o compilador otimize o código com base no tipo especificado.

---

### Referências:

[1] "Java Tutorials - Generics - Generic Types." Oracle. Disponível em: https://docs.oracle.com/javase/tutorial/java/generics/types.html.

[2] "Collections Java API" Camila Cavalcante. Disponível em: https://github.com/cami-la/collections-java-api-2023

---