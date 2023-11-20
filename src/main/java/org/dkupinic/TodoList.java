package org.dkupinic;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents a TodoList, which is a collection of todos.
 */
@Setter
@Getter
public class TodoList {
    /**
     * This private variable is an ArrayList of Todo objects containing the list of todos.
     * It is used to store and manage a collection of todos.
     */
    private ArrayList<Todo> todos;
    /**
     * The name of the list.
     */
    private String name;
    /**
     * Represents the date the variable was created.
     * This variable stores the date and time when the variable was created. It is of type Date.
     *
     * @see Date
     */
    private Date created;

    /**
     * Initializes a new TodoList object with the given parameters.
     *
     * @param todos   The list of todo objects associated with this TodoList.
     * @param name    The name of the TodoList.
     */
    public TodoList(ArrayList<Todo> todos, String name) {
        this.todos = todos;
        this.name = name;
        this.created = new Date();
    }
}
