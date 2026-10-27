package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;

public class IndexCommandParserConsistencyTest {

    private static final List<String> INVALID_INDICES =
            List.of("0", "-1", "abc", "1.5", "2147483648");

    private static final List<ParserCase> PARSER_CASES = List.of(
            new ParserCase(new DeleteCommandParser(), index -> index),
            new ParserCase(new ViewCommandParser(), index -> index),
            new ParserCase(new EditCommandParser(), index -> index + " n/Alice"),
            new ParserCase(new NoteCommandParser(), index -> index + " Follow up"),
            new ParserCase(new RoleCommandParser(), index -> index + " buyer"));

    @Test
    public void parse_invalidIndex_returnsConsistentMessageAcrossCommands() {
        for (ParserCase parserCase : PARSER_CASES) {
            for (String invalidIndex : INVALID_INDICES) {
                assertParseFailure(parserCase.parser(), parserCase.arguments().apply(invalidIndex),
                        Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            }
        }
    }

    private record ParserCase(Parser<? extends Command> parser, Function<String, String> arguments) {
    }
}
