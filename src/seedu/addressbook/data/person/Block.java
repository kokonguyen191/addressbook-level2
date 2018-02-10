package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address block in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Block {

    public static final String EXAMPLE = "666";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block must be an integer smaller than 1000";
    public static final String BLOCK_VALIDATION_REGEX = "\\d{0,3}";

    public final String value;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address block is invalid.
     */
    public Block(String block) throws IllegalValueException {
        String trimmedBlock = block.trim();
        if (!isValidBlock(trimmedBlock)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.value = trimmedBlock;
    }

    /**
     * Returns true if a given string is a valid block number.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
