package edu.meninocoiso.oop.projects.project3.domain;

import java.util.*;

public class Developer {
	private String name;
	private String id;
	private Platform platform;
	
	// Utilizamos o Set pois não é possível que um dev entre no mesmo conteúdo mais de uma vez
	// Além disso, utilizamos o LinkedHashSet para manter a ordem de inserção,
	// pois assim podemos progredir nos conteúdos na ordem em que foram adicionados
	private Set<Content> contentSubscribed = new LinkedHashSet<>();
	private Set<Content> contentConcluded = new LinkedHashSet<>();
	
	public Developer(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public void joinBootcamp(Bootcamp bootcamp) {
		bootcamp.addDeveloper(this);
		
		// Caso o dev seja adicionado com sucesso, adicionamos todos os conteúdos do bootcamp
		this.contentSubscribed.addAll(bootcamp.getContents());
		
		System.out.println("O(a) dev " + name + " se inscreveu no Bootcamp: " + bootcamp.getName());
	}
	
	public void progress() {
		Optional<Content> content = this.contentSubscribed.stream().findFirst();
		
		if (content.isEmpty()) {
			System.err.println("Não foi possível concluir o conteúdo. O(a) dev " + name + " não está matriculado em nenhum conteúdo!");
			return;
		}
		
		System.out.println("O(a) dev " + name + " está progredindo no conteúdo: " + content.get().getTitle());
		
		// Para progredir, caso o conteúdo seja um Curso, é necessário responder a 60% das perguntas corretamente.
		if (content.get().getClass() == Course.class) {
			Course course = (Course) content.get();
			
			if (!course.runTest()) {
				System.err.println("Não foi possível concluir o conteúdo. Ao menos 60% das perguntas devem ser respondidas corretamente!");
				return;
			}
		}
		
		this.contentConcluded.add(content.get());
		this.contentSubscribed.remove(content.get());
		
		System.out.println("O(a) dev " + name + " concluiu o conteúdo: " + content.get().getTitle());
	}
	
	public double calculateTotalXp() {
		// Método utilizando um laço de repetição:
		// Iterator<Content> iterator = this.contentConcluded.iterator();
		// double sum = 0;
		// while (iterator.hasNext()) {
		// 		double next = iterator.next().calculateXp();
		// 		sum += next;
		// }
		// return sum;
		
		return this.contentConcluded
				.stream()
				.mapToDouble(Content::calculateXp)
				.sum();
	}
	
	public String getName() {
		return name;
	}
	
	public Set<Content> getContentSubscribed() {
		return contentSubscribed;
	}
	
	public Set<Content> getContentConcluded() {
		return contentConcluded;
	}
	
	public Platform getPlatform() {
		return platform;
	}
	
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Developer developer)) return false;
		return Objects.equals(id, developer.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
