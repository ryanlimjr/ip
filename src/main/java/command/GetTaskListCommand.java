package command;

import duke.Parser;
import duke.Storage;
import duke.TaskList;
import ui.Ui;

/**
 * Command to get the list of task for the user
 *
 * @author Ryan Lim
 */
public class GetTaskListCommand extends Command {

    @Override
    public Result execute(TaskList taskList, Parser parser, Storage aliasStorage, Storage taskStorage, Ui ui) {
        return new Result(ui.displayTaskListMessage(taskList), executedSuccessfully);
    }
}
