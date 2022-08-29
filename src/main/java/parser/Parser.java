package parser;

import command.*;

/**
 * Represents a parser to parse commands from
 * the user.
 */
public class Parser {
    protected String fullCommand;

    /**
     * Constructor for this Parser that takes in
     * a command as a string.
     *
     * @param fullCommand Command from the user.
     */
    public Parser(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    /**
     * Returns different types of commands depending on what
     * command the user input.
     *
     * @param fullCommand Command from the user.
     * @return Different types of commands depending on the
     * user input.
     */
    public Command parse(String fullCommand) {
        if (fullCommand.isEmpty() || fullCommand.equals("bye")) {
            return new ByeCommand(fullCommand);
        } else if (fullCommand.equals("list")) {
            return new ListCommand(fullCommand);
        } else if (fullCommand.startsWith("delete")) {
            return new DeleteCommand(fullCommand);
        } else if (fullCommand.startsWith("mark") || fullCommand.startsWith("unmark")) {
            return new EditCommand(fullCommand);
        } else if (fullCommand.startsWith("todo") || fullCommand.startsWith("deadline") ||
                fullCommand.startsWith("event")) {
            return new AddCommand(fullCommand);
        } else if (fullCommand.startsWith("find")) {
            return new FindCommand(fullCommand);
        } else {
            return new FalseCommand(fullCommand);
        }
    }
}
