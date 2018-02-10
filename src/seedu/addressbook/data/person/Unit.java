package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address unit in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
public class Unit {

    public static final String EXAMPLE = "#55-65";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit number must start with # and be a series of number, optionally delimited by a dash.";
    public static final String UNIT_VALIDATION_REGEX = "#\\d*-?\\d*";

    public final String value;

    /**
     * Validates given unit.
     *
     * @throws IllegalValueException if given unit string is invalid.
     */
    public Unit(String unit) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        if (!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = trimmedUnit;
    }

    /**
     * Returns true if a given string is a valid unit.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
