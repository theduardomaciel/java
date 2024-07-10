package edu.meninocoiso.oop.collection.list.basic.exercise1;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
	private List<Task> tasks;
	
	public TaskList() {
		tasks = new ArrayList<>();
	}
	
	public void addTask(String title) {
		tasks.add(new Task(title));
	}
	
	public void removeTask(String title) {
		if (tasks.isEmpty()) {
			System.out.println("A lista se encontra vazia!");
			return;
		}
		
		tasks.removeIf(task -> task.getTitle().equalsIgnoreCase(title));
		/* ou:
		for (Task task : tasks) {
			if (task.getTitle().equals(title)) {
				tasks.remove(task);
			}
		}*/
	}
	
	public int getTasksLength() {
		return tasks.size();
	}
	
	public String[] getTasksTitles() {
		String[] titles = new String[tasks.size()];
		for (int i = 0; i < tasks.size(); i++) {
			titles[i] = tasks.get(i).getTitle();
		}
		return titles;
	}
	
	@Override
	public String toString() {
		return "TasksList{" +
				"tasks=" + tasks +
				'}';
	}
	
	public static void main(String[] args) {
		TaskList tasksList = new TaskList();
		System.out.println(tasksList.toString());
		
		tasksList.addTask("Task 1");
		tasksList.addTask("Task 2");
		tasksList.addTask("Task 2");
		tasksList.addTask("Task 3");
		
		System.out.println("A lista de tarefas possui " + tasksList.getTasksLength() + " tarefas.");
		
		System.out.println("Títulos das tarefas:");
		for (String title : tasksList.getTasksTitles()) {
			System.out.println(title);
		}
		
		tasksList.removeTask("Task 2");
		
		System.out.println("A lista de tarefas possui " + tasksList.getTasksLength() + " tarefas.");
	}
}
