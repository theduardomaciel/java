package edu.meninocoiso.oop.projects.project3.domain;

public class Course extends Content {
	private int workload;
	
	public Course(String title, String description, int workload) {
		super(title, description);
		this.workload = workload;
	}
	
	@Override
	public double calculateXp() {
		return DEFAULT_XP * workload;
	}
	
	private int getWorkload() {
		return workload;
	}
	
	@Override
	public String toString() {
		return "Curso:\n".concat(super.toString()).concat("\n| Carga horária: " + getWorkload() + " horas");
	}
}
