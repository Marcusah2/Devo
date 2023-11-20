package org.dkupinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains test cases for the TodoList class.
 */
class TodoListTest {
    /**
     * Instance variable representing a todo list.
     * This variable holds the object reference to a TodoList object, representing a list of tasks to be completed.
     * The TodoList class provides methods to add, remove, and retrieve tasks in the list.
     */
    private TodoList todoList;
    /**
     * An ArrayList of Todo objects representing a list of tasks.
     * <p>
     * This variable is a private instance variable and is used to store and manage the list of Todo tasks.
     * It provides methods to add, remove, and retrieve Todo objects from the list.
     */
    private ArrayList<Todo> todoArrayList;

    /**
     * Sets up the test environment.
     * <p>
     * This method is executed before each test method is run. It initializes the necessary
     * objects and data for the test to run.
     */
    @BeforeEach
    void setUp() {
        Todo todo = new Todo("Sample", "sample text");
        todoArrayList = new ArrayList<>();
        todoArrayList.add(todo);
        todoList = new TodoList(todoArrayList, "Test Todo list");
    }

    /**
     * Tests the {@code getTodos()} method of the {@link TodoList} class.
     * <p>
     * This method verifies that the {@code getTodos()} method of the {@link TodoList} class returns
     * the correct {@link ArrayList<Todo>} containing the {@link Todo} instances.
     */
    @Test
    void testGetTodos() {
        assertEquals(todoArrayList, todoList.getTodos());
    }

    /**
     * Tests the {@code getName()} method of the {@link TodoList} class.
     * <p>
     * This method verifies that the {@code getName()} method of the {@link TodoList} class returns
     * the correct name of the todo list.
     */
    @Test
    void testGetName() {
        assertEquals("Test Todo list", todoList.getName());
    }

    /**
     * Tests the {@code getCreated()} method of the {@link TodoList} class.
     * <p>
     * This method verifies that the {@code getCreated()} method of the {@link TodoList} class returns
     * a non-null value for the created date of the todo list.
     */
    @Test
    void testCreated() {
        assertNotNull(todoList.getCreated());
    }
}