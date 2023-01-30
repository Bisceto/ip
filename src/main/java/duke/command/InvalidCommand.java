package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.task.TaskList;
import duke.Ui;

public class InvalidCommand extends Command {


    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
//        throw new duke.DukeException("Invalid command, please try again");
        System.out.println("Invalid command, please try again!");
    }

    public boolean isExit() {
        return false;
    }
}
