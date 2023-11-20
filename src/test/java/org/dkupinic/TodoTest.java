package org.dkupinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The TodoTest class is used to test the functionality of the Todo class.
 * It contains test cases to verify the creation and behavior of a Todo object.
 */
public class TodoTest {
    /**
     * This variable stores a reference to a Todo object.
     * The Todo object represents a task or an item that needs to be completed.
     * It contains information such as the task description, due date,
     * and completion status.
     */
    private Todo todo;

    /**
     * Set up method to initialize the required objects before each test case execution.
     * It creates a "Todo" object with the given title and description.
     */
    @BeforeEach
    public void setUp() {
        todo = new Todo("Sample", "This is a sample todo.");
    }

    /**
     * Method to test the creation of a Todo object.
     * It asserts that the created Todo object is not null, has the correct title and description,
     * and is not marked as finished.
     */
    @Test
    public void testTodoCreation() {
        assertNotNull(todo);
        assertEquals("Sample", todo.getTitle());
        assertEquals("This is a sample todo.", todo.getContent());
        assertFalse(todo.isFinished());
    }

    /**
     * Method to test the setting of the "finished" status for a Todo object.
     * It sets the "finished" status of the Todo object to true and asserts that the status has been
     * successfully updated.
     */
    @Test
    public void testSetFinished() {
        todo.setFinished(true);
        assertTrue(todo.isFinished());
    }
}