package org.dkupinic;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<TodoList> todoLists = new ArrayList<>();
        String operation = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Todo-List Manager");
        showInformation();

        while (!operation.equals("exit")) {
            System.out.print("--> ");
            operation = scanner.next();
            if (scanner.hasNextLine()) {
                switch (operation.toLowerCase()) {
                    case "n" -> todoLists.add(createTodo());
                    case "e" -> editTodoList(todoLists);
                    case "d" -> delete(todoLists);
                    case "h" -> showInformation();
                    case "exit" -> System.out.println("Exiting program");
                    case "p" -> printTodos(todoLists);
                    default -> System.out.println("Invalid Information");
                }
                System.out.println("   [h] - show help information");
            }
        }
    }

    public static void showInformation() {
        System.out.println("Enter: \n   [n] - new Todo-List \n" +
                "   [e] - edit existing Todo-List \n" +
                "   [d] - delete exisiting Todo-List \n" +
                "   [exit] - exit program \n" +
                "   [p] - print all Todo-Lists with Todos"
        );
    }

    public static TodoList createTodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n====== Creating Todo ======");
        System.out.print("Enter a Name for your Todo-List: ");

        return new TodoList(new ArrayList<>(), scanner.nextLine());
    }

    public static void delete(ArrayList<TodoList> todoList) {
        System.out.println("\n====== Deleting Todo ======");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: \n   [t] - delete an element of a Todo-List \n" +
                "   [w] - delete whole Todo-List");
        System.out.println("--> ");

        switch (scanner.nextLine().toLowerCase()) {
            case "t" -> deleteTodo(todoList);
            case "w" -> deleteTodoList(todoList);
            default -> System.out.println("Invalid Information");
        }
    }

    public static void deleteTodoList(ArrayList<TodoList> todoList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the Todo-List you would like to delete: ");
        String listName = scanner.next();
        todoList.removeIf(t -> t.getName().equalsIgnoreCase(listName));
        System.out.println("Deleted Todo!");
    }

    public static void deleteTodo(ArrayList<TodoList> todoLists) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the Todo-List you would like to delete from: ");
        String listName = scanner.next();
        System.out.print("Enter the name of the Todo you would like to delete: ");
        String todoName = scanner.next();

        TodoList todoList = getTodoListByName(listName, todoLists);
        Todo todo = getTodoByName(todoName, Objects.requireNonNull(getTodoListByName(listName, todoLists)).getTodos());

        todoList.getTodos().remove(todo);

        System.out.println("Removed Todo!");
    }

    public static void printTodos(ArrayList<TodoList> todoList) {
        System.out.println("\n====== Printing Todos ======");
        for (TodoList t : todoList) {
            System.out.println("Todo-List '" + t.getName() + "' contains: ");
            for (Todo element : t.getTodos()) {
                System.out.println("    -Todo: '" + element.getTitle() + "'");
                System.out.println("With the content: " + element.getContent());
            }
        }
    }

    public static void editTodoList(ArrayList<TodoList> todoLists) {
        System.out.println("\n====== Editing Todo-List ======");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the Todo-List you would like to edit: ");
        String listName = scanner.nextLine();

        System.out.println("What would you like to do?");
        System.out.println("    [a] - add a new Todo\n    [e] - edit an existing Todo");
        System.out.print("--> ");


        switch (scanner.next().toLowerCase()) {
            case "a" -> addTodoToList(Objects.requireNonNull(getTodoListByName(listName, todoLists)));
            case "e" -> editTodo(Objects.requireNonNull(getTodoListByName(listName, todoLists)));
        }
    }

    public static void addTodoToList(TodoList todoList) {
        System.out.println("\n====== Adding Todo ======");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name you would like for your Todo: ");
        String todoName = scanner.next();
        System.out.print("Enter the content for the Todo: ");
        String todoContent = scanner.next();

        todoList.getTodos().add(new Todo(todoName, todoContent));
        System.out.println("Added Todo!");
    }

    public static void editTodo(TodoList todo) {
        System.out.println("\n====== Editing Todo ======");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name for the Todo you would like to change: ");
        String todoName = scanner.next();
        Todo todoToEdit = getTodoByName(todoName, todo.getTodos());

        System.out.println("What would you like to change?");
        System.out.println("    [c] - edit content\n    [t] - edit title");
        System.out.print("--> ");

        if (scanner.next().equalsIgnoreCase("c")) {
            System.out.print("Enter the new content: ");
            String content = scanner.next();
            todoToEdit.setContent(content);
        } else if (scanner.next().equalsIgnoreCase("t")) {
            System.out.print("Enter the new title: ");
            String title = scanner.next();
            todoToEdit.setTitle(title);
        }
    }

    public static TodoList getTodoListByName(String name, ArrayList<TodoList> todoLists) {
        for (TodoList t : todoLists) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    public static Todo getTodoByName(String name, ArrayList<Todo> todos) {
        for (Todo t : todos) {
            if (t.getTitle().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

}


