package command;

import duke.Parser;
import duke.Storage;
import duke.TaskList;
import ui.Ui;

/**
 * Represents a single Command with or without parameters.
 *
 * @author  Ryan Lim
 */
public abstract class Command {
    /** Array of strings where each element represents a parameter tagged to the command. */
    protected final String[] parameters;
    /** Constants to be passed when generating results.*/
    protected final boolean executedSuccessfully = true;
    protected final boolean executedUnsuccessfully = false;

    /**
     * Instantiate command without parameters.
     */
    public Command() {
        this.parameters = new String[0];
    }

    /**
     * Instantiate command with parameters.
     * @param parameters Array of parameters represented as strings.
     */
    public Command(String ...parameters) {
        this.parameters = parameters;
    }

    /**
     * To check if Command is a terminating command.
     * @return true if command is a terminating command false otherwise.
     */
    public boolean isEndCommand() {
        return false;
    }

    /**
     * Execute the command.
     * @param taskList The current list of task.
     * @param parser The parser.
     * @param aliasStorage The alias storage.
     * @param taskStorage The task storage.
     * @param ui The Ui to generate messages.
     * @return The result after executing the command.
     */
    public abstract Result execute(TaskList taskList, Parser parser, Storage aliasStorage, Storage taskStorage, Ui ui);


}
