package task;

import java.time.LocalDateTime;

public class Event extends Task {

    public Event(String description, LocalDateTime dueDate, boolean done) {
        super(description, dueDate, done);
    }

    public Event(String description, LocalDateTime dueDate) {
        super(description, dueDate);
    }

    public String writeToFile() {
        return "E|" + super.writeToFile() + "|" + super.getDueDate();
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at : " + super.getDateString() + ")";
    }
}
