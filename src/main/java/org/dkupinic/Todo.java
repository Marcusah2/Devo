package org.dkupinic;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a todo item.
 */
@Setter
@Getter
public class Todo {
    private String title;
    private String content;
    private boolean isFinished;

    /**
     * Constructs a new Todo object with the given title, content, and finished status.
     *
     * @param title the title of the todo
     * @param content the content of the todo
     */
    public Todo(String title, String content) {
        this.title = title;
        this.content = content;
        this.isFinished = false;
    }
}
