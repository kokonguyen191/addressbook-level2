package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's postal code in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */
public class PostalCode {

    public static final String EXAMPLE = "231534";
    public static final String MESSAGE_POSTALCODE_CONSTRAINTS = "Postal code must be a 6-digit integer.";
    public static final String POSTALCODE_VALIDATION_REGEX = "\\d{6}";

    public final String value;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code string is invalid.
     */
    public PostalCode(String postalCode) throws IllegalValueException {
        String trimmedPostalCode = postalCode.trim();
        if (!isValidPostalCode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_POSTALCODE_CONSTRAINTS);
        }
        this.value = trimmedPostalCode;
    }

    /**
     * Returns true if a given string is a valid postal code.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTALCODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
