package command;

import duke.Parser;
import duke.Storage;
import duke.TaskList;
import ui.Ui;

/**
 * Command to represent an invalid command
 *
 * @author Ryan Lim
 */
public class InvalidCommand extends Command {
    @Override
    public Result execute(TaskList taskList, Parser parser, Storage aliasStorage, Storage taskStorage, Ui ui) {
        return new Result(ui.invalidCommandMessage(), executedUnsuccessfully);
    }
}
