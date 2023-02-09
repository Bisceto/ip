package duke.task;

import java.util.ArrayList;

import duke.exception.DukeException;

/**
 * Represents the list of tasks in Duke. This task list will be saved into and loaded from a storage text file.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gets the ArrayList of tasks.
     * @return The ArrayList of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    /**
     * Adds a task to the task list.
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the task list.
     * @param index The number of the task to delete.
     * @throws DukeException If the number specified is invalid (> Number of tasks in task list or <= 0).
     */
    public Task deleteTask(int index) throws DukeException {
        try {
            return tasks.remove(index - 1);
        } catch (IndexOutOfBoundsException err) {
            throw new DukeException("That task does not exist!");
        }
    }

    /**
     * Unmarks a task in the task list.
     * @param index The number of the task to unmark.
     * @throws DukeException If the number specified is invalid (> Number of tasks in task list or <= 0).
     */
    public Task unmarkTask(int index) throws DukeException {
        try {
            Task task = tasks.get(index - 1);
            task.markUndone();
            return task;
        } catch (IndexOutOfBoundsException err) {
            throw new DukeException("That task does not exist!");
        }
    }

    /**
     * Marks a task in the task list.
     * @param index The number of the task to mark.
     * @throws DukeException If the number specified is invalid (> Number of tasks in task list or <= 0).
     */
    public Task markTask(int index) throws DukeException {
        try {
            Task cur = tasks.get(index - 1);
            cur.markDone();
            return cur;
        } catch (IndexOutOfBoundsException err) {
            throw new DukeException("That task does not exist!");
        }
    }

    public ArrayList<Task> findTasks(String input) {
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task cur : this.tasks) {
            if (cur.getDescription().contains(input)) {
                foundTasks.add(cur);
            }
        }
        return foundTasks;
    }
    public int getNumTasks() {
        return tasks.size();
    }
}
