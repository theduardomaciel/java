package edu.meninocoiso.oop.projects.project3.domain;

import java.time.LocalDate;
import java.util.*;

public class Bootcamp {
	private String name;
	private String description;
	
	private Platform platform;
	
	private final LocalDate startDate = LocalDate.now();
	private final LocalDate endDate = startDate.plusDays(45);
	
	private Set<Developer> developersSubscribed = new HashSet<>();
	private Set<Content> contents = new LinkedHashSet<>();
	
	public Bootcamp(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public Set<Developer> getDevelopersSubscribed() {
		return developersSubscribed;
	}
	
	public void addDeveloper(Developer developer) throws RuntimeException {
		// Caso o dev não esteja presente na plataforma, não é possível inscrevê-lo no bootcamp
		Optional<Platform> platform = Optional.ofNullable(developer.getPlatform());
		
		if (platform.isEmpty()) {
			throw new RuntimeException("Não foi possível adicionar " + developer.getName() + " ao Bootcamp." + "O(a) dev não está cadastrado(a) na plataforma!");
		}
		
		boolean success = developersSubscribed.add(developer);
		if (!success) {
			throw new RuntimeException("O(a) dev " + developer.getName() + " já está inscrito no bootcamp!");
		}
	}
	
	public Set<Content> getContents() {
		return contents;
	}
	
	public void addContent(Content content) {
		contents.add(content);
	}
	
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Bootcamp bootcamp)) return false;
		return Objects.equals(getName(), bootcamp.getName()) && Objects.equals(getDescription(), bootcamp.getDescription());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getDescription());
	}
}
