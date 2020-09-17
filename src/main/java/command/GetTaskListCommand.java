package command;

import duke.Parser;
import duke.TaskList;

public class GetTaskListCommand extends Command {

    @Override
    public Result execute(TaskList taskList, Parser parser) {
        return new Result(taskList.toString(), executedSuccessfully);
    }
}
