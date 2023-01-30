public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showMessage("Got it. I've added this task:");
        taskList.addTask(this.task);
        ui.showMessage("Now you have " + taskList.tasks.size() + " tasks in your list");
    }

    public boolean isExit() {
        return false;
    }
}
