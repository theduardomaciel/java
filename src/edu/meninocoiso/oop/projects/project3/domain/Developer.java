package edu.meninocoiso.oop.projects.project3.domain;

import java.util.*;

public class Developer {
	private String name;
	private String id;
	private Set<Content> contentSubscribed = new LinkedHashSet<>();
	private Set<Content> contentConcluded = new LinkedHashSet<>();
	
	public Developer(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public void joinBootcamp(Bootcamp bootcamp) {
		this.contentSubscribed.addAll(bootcamp.getContents());
		bootcamp.getDevelopersSubscribed().add(this);
	}
	
	public void progress() {
		Optional<Content> content = this.contentSubscribed.stream().findFirst();
		if (content.isPresent()) {
			this.contentConcluded.add(content.get());
			this.contentSubscribed.remove(content.get());
			
			System.out.println("Você concluiu o conteúdo: " + content.get().getTitle());
		} else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
	}
	
	public double calculateTotalXp() {
		Iterator<Content> iterator = this.contentConcluded.iterator();
		double soma = 0;
		while (iterator.hasNext()) {
			double next = iterator.next().calculateXp();
			soma += next;
		}
		return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
	}
	
	public String getName() {
		return name;
	}
	
	public Set<Content> getContentSubscribed() {
		return contentSubscribed;
	}
	
	public void setContentSubscribed(Set<Content> contentSubscribed) {
		this.contentSubscribed = contentSubscribed;
	}
	
	
	public Set<Content> getContentConcluded() {
		return contentConcluded;
	}
	
	public void setContentConcluded(Set<Content> contentConcluded) {
		this.contentConcluded = contentConcluded;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Developer developer)) return false;
		return Objects.equals(getName(), developer.getName()) && Objects.equals(id, developer.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), id);
	}
}
