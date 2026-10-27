package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given arguments and returns a DeleteCommand.
     *
     * @throws ParseException if the command format or index is invalid.
     */
    public DeleteCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        String[] arguments = trimmedArgs.isEmpty() ? new String[0] : trimmedArgs.split("\\s+");

        if (arguments.length != 1) {
            throw new ParseException(DeleteCommand.MESSAGE_INVALID_FORMAT);
        }

        return new DeleteCommand(ParserUtil.parseDisplayedIndex(arguments[0]));
    }
}
