package seedu.addressbook.ui;

import seedu.addressbook.commands.CommandResult;

import java.io.PrintStream;
import java.util.List;

import static seedu.addressbook.common.Messages.MESSAGE_ENTER_COMMAND;
import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

/**
 * Text formatter of the application.
 */
public class Formatter {

    /**
     * A decorative prefix added to the beginning of lines printed by AddressBook
     */
    private static final String LINE_PREFIX = "|| ";

    /**
     * A platform independent line separator.
     */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /**
     * Format of indexed list item
     */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /**
     * Offset required to convert between 1-indexing and 0-indexing.
     */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    private final PrintStream out;

    public Formatter(PrintStream out) {
        this.out = out;
    }

    public static String formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return formatMessages(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }

    public static String formatEnterCommandMessage() {
        return LINE_PREFIX + MESSAGE_ENTER_COMMAND;
    }

    public static String formatGoodbyeMessage() {
        return formatMessages(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    public static String formatInitFailedMessage() {
        return formatMessages(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /**
     * Return a showable string from message(s)
     */
    public static String formatMessages(String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String m : messages) {
            sb.append(LINE_PREFIX);
            sb.append(m.replace("\n", LS + LINE_PREFIX));
            sb.append(LS);
        }
        return sb.toString();
    }

    public static String formatFeedbackToUser(CommandResult result) {
        return formatMessages(result.feedbackToUser, DIVIDER);
    }

    public static String formatEchoUserCommandMessage(String fullInputLine) {
        return formatMessages("[Command entered:" + fullInputLine + "]");
    }

    /**
     * Formats a list of strings as a viewable indexed list.
     */
    public static String formatIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(formatIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatMessages(formatted.toString());
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String formatIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
