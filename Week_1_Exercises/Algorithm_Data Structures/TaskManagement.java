/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week1;

/**
 *
 * @author shuva
 */
import java.util.Scanner;

class Task {
    private int taskId;
    private String taskName;
    private String status;
    Task next; // Pointer to the next task in the linked list

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task [ID=" + taskId + ", Name=" + taskName + ", Status=" + status + "]";
    }
}

class TaskManagement {
    private Task head;

    public TaskManagement() {
        head = null;
    }

    // Add a new task to the linked list
    public void addTask(Task task) {
        if (head == null) {
            head = task;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = task;
        }
        System.out.println("Task added: " + task);
    }

    // Search for a task by ID
    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.getTaskId() == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse the linked list and display all tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // Delete a task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        // If the task to be deleted is the head
        if (head.getTaskId() == taskId) {
            head = head.next;
            System.out.println("Task deleted: ID " + taskId);
            return;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.getTaskId() == taskId) {
                current.next = current.next.next; // Bypass the task to be deleted
                System.out.println("Task deleted: ID " + taskId);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found with ID: " + taskId);
    }

    public static void main(String[] args) {
        TaskManagement taskManagement = new TaskManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Status: ");
                    String status = scanner.nextLine();
                    Task newTask = new Task(id, name, status);
                    taskManagement.addTask(newTask);
                    break;
                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    Task foundTask = taskManagement.searchTask(searchId);
                    System.out.println("Search Result: " + (foundTask != null ? foundTask : "Task not found"));
                    break;
                case 3:
                    taskManagement.traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskManagement.deleteTask(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
