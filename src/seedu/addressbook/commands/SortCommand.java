package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.Collections;
import java.util.List;


/**
 * Displays sorted list of persons to the user.
 */

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE  = COMMAND_WORD + ": Displays all persons in the address book sorted in "
            + "alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    public SortCommand() {}

    @Override
    public CommandResult execute() {
        UniquePersonList allPersons = addressBook.getAllPersons();
        allPersons.sort();
        List<ReadOnlyPerson> sortedList = allPersons.immutableListView();

        return new CommandResult(getMessageForPersonListShownSummary(sortedList), sortedList);
    }
}
