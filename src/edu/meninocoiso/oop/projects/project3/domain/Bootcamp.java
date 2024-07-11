package edu.meninocoiso.oop.projects.project3.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
	private String name;
	private String description;
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
	
	public Set<Content> getContents() {
		return contents;
	}
	
	public void addContent(Content content) {
		contents.add(content);
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
