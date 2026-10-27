package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new {@code ViewCommand}.
 */
public class ViewCommandParser implements Parser<ViewCommand> {

    /**
     * Parses the given arguments and returns a {@code ViewCommand}.
     *
     * @throws ParseException If the command format or index is invalid.
     */
    @Override
    public ViewCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        String[] arguments = trimmedArgs.isEmpty() ? new String[0] : trimmedArgs.split("\\s+");

        if (arguments.length != 1) {
            throw new ParseException(ViewCommand.MESSAGE_INVALID_FORMAT);
        }

        return new ViewCommand(ParserUtil.parseDisplayedIndex(arguments[0]));
    }
}
