package edu.meninocoiso.oop.collection.set.search.exercise2;

public class Task {
	private String description;
	private boolean done;
	
	public Task(String description) {
		this.description = description;
		this.done = false;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	@Override
	public String toString() {
		return "Task [description=" + description + ", done=" + done + "]";
	}
}
