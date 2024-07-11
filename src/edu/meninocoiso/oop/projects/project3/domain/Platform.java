package edu.meninocoiso.oop.projects.project3.domain;

import java.util.HashSet;
import java.util.Set;

public class Platform {
	private final Set<Bootcamp> bootcamps = new HashSet<>();
	private final Set<Developer> developers = new HashSet<>();
	
	public void addBootcamp(Bootcamp bootcamp) {
		bootcamps.add(bootcamp);
		bootcamp.setPlatform(this);
	}
	
	public Set<Bootcamp> getBootcamps() {
		return bootcamps;
	}
	
	public Bootcamp getBootcamp(String name) {
		return bootcamps.stream()
				.filter(bootcamp -> bootcamp.getName().equals(name))
				.findFirst()
				.orElse(null);
	}
	
	public void removeBootcamp(String name) {
		Bootcamp bootcamp = getBootcamp(name);
		if (bootcamp != null) {
			bootcamps.remove(bootcamp);
		}
	}
	
	public void listBootcamps() {
		bootcamps.forEach(System.out::println);
	}
	
	public void addDeveloper(Developer developer) throws RuntimeException {
		boolean success = developers.add(developer);
		
		if (!success) {
			throw new RuntimeException("Não foi possível adicionar o desenvolver à plataforma. Um desenvolvedor com mesmo ID já foi cadastrado.");
		}
		
		developer.setPlatform(this);
	}
	
	public Set<Developer> getDevelopers() {
		return developers;
	}
}
