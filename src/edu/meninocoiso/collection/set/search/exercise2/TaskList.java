package edu.meninocoiso.collection.set.search.exercise2;

import java.util.HashSet;
import java.util.Set;

public class TaskList {
	private Set<Task> tasks;

	public TaskList() {
		this.tasks = new HashSet<>();
	}

	public void addTask(String description) {
		tasks.add(new Task(description));
	}

	public void removeTask(String description) {
		if (tasks.isEmpty()) {
			System.out.println("Nenhuma tarefa presente na lista.");
			return;
		}

		for (Task task : tasks) {
			if (task.getDescription().equalsIgnoreCase(description)) {
				tasks.remove(task);
				System.out.println("Tarefa '" + description + "' removida.");
				return;
			}
		}

		System.out.println("Tarefa não encontrada.");
	}

	public void showTasks() {
		System.out.println("Lista de tarefas:");
		for (Task task : tasks) {
			System.out.println(task);
		}
	}

	public void countTasks() {
		System.out.println("Número de tarefas: " + tasks.size());
	}

	public Set<Task> getDoneTasks() {
		Set<Task> doneTasks = new HashSet<>();

		for (Task task: tasks) {
			if (task.isDone()) {
				doneTasks.add(task);
			}
		}

		return doneTasks;
	}

	public Set<Task> getPendingTasks() {
		Set<Task> pendingTasks = new HashSet<>();

		for (Task task: tasks) {
			if (!task.isDone()) {
				pendingTasks.add(task);
			}
		}

		return pendingTasks;
	}

	public void markTaskAsDone(String description) {
		for (Task task : tasks) {
			if (task.getDescription().equalsIgnoreCase(description)) {
				task.setDone(true);
				return;
			}
		}

		System.out.println("Tarefa '" + description + "' não encontrada.");
	}

	public void markTaskAsPending(String description) {
		for (Task task : tasks) {
			if (task.getDescription().equalsIgnoreCase(description)) {
				task.setDone(false);
				return;
			}
		}

		System.out.println("Tarefa '" + description + "' não encontrada.");
	}

	public void cleanTasks() {
		tasks.clear();
	}

	public static void main(String[] args) {
		TaskList taskList = new TaskList();

		taskList.addTask("Estudar Java");
		taskList.addTask("Fazer exercícios de Java");
		taskList.addTask("Estudar Python");
		taskList.addTask("Fazer exercícios de Python");
		taskList.addTask("Estudar JavaScript");
		taskList.addTask("Fazer exercícios de JavaScript");

		taskList.markTaskAsDone("Estudar Java");
		taskList.markTaskAsDone("Estudar JavaScript");
		taskList.markTaskAsDone("Estudar C#"); // Tarefa inexistente

		taskList.showTasks();

		System.out.println("Tarefas concluídas:");
		for (Task task : taskList.getDoneTasks()) {
			System.out.println(task);
		}

		System.out.println("Tarefas pendentes:");
		for (Task task : taskList.getPendingTasks()) {
			System.out.println(task);
		}

		taskList.countTasks();

		taskList.markTaskAsPending("Estudar Java");
		taskList.removeTask("Estudar Python");

		taskList.showTasks();
		taskList.countTasks();

		taskList.cleanTasks();
		System.out.println("Lista de tarefas limpa.");
		taskList.showTasks();
	}
}
