package command;

import storage.Storage;
import task.TaskList;
import ui.Ui;
import exception.DukeException;
import task.Task;

/**
 * Represents an EditCommand that inherits from
 * the abstract class Command.
 */
public class EditCommand extends Command {
    protected String commandLine;

    /**
     * Constructor for this EditCommand that takes in a
     * commandLine as a String.
     *
     * @param commandLine Command from the user.
     */
    public EditCommand(String commandLine) {
        this.commandLine = commandLine;
    }

    /**
     * Returns a boolean false to show that this
     * is not the last command.
     *
     * @return false.
     */
    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * Executes the command depending on which action the user
     * wants to do and prints a string if it is executed successfully.
     *
     * @param taskList The ArrayList that contains all the tasks.
     * @param ui The Ui that interacts with the next command from the user.
     * @param storage The Storage used to store the tasks.
     * @throws DukeException If there is no such task.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        String response = "";
        if (commandLine.startsWith("mark")) {
            int index = Integer.parseInt(commandLine.substring(5)) - 1;
            try {
                if (index > taskList.size() - 1 || index < 0) {
                    throw new DukeException("You have no such tasks.");
                } else {
                    assert index < taskList.size();
                    assert index >= 0;
                    Task task = taskList.get(index);
                    task.isMark(true);
                    storage.updateData(taskList);
                    response = "Nice! I've marked this task as done:\n"
                            + " " + task + "\n";
                    System.out.println(response);
                    return response;
                }
            } catch (DukeException e) {
                System.out.println(e.toString());
                return e.toString();
            }
        } else {
            int index = Integer.parseInt(commandLine.substring(7)) - 1;
            try {
                if (index > taskList.size() - 1 || index < 0) {
                    throw new DukeException("You have no such tasks.");
                } else {
                    assert index < taskList.size();
                    assert index >= 0;
                    Task task = taskList.get(index);
                    task.isMark(false);
                    storage.updateData(taskList);
                    response = "OK, I've marked this task as not done yet:\n"
                            + " " + task + "\n";
                    System.out.println(response);
                    return response;
                }
            } catch (DukeException e) {
                System.out.println(e.toString());
                return e.toString();
            }
        }
    }
}
