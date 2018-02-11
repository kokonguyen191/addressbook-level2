package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import static seedu.addressbook.data.person.Block.isValidBlock;
import static seedu.addressbook.data.person.PostalCode.isValidPostalCode;
import static seedu.addressbook.data.person.Street.isValidStreet;
import static seedu.addressbook.data.person.Unit.isValidUnit;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "666, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in 'BLOCK, STREET, UNIT, POSTAL_CODE' format without quotes. Please see 'help' for more information.";

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTALCODE_INDEX = 3;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] splitAddress = trimmedAddress.split(",");
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        this.value = trimmedAddress;
        block = new Block(splitAddress[BLOCK_INDEX]);
        street = new Street(splitAddress[STREET_INDEX]);
        unit = new Unit(splitAddress[UNIT_INDEX]);
        postalCode = new PostalCode(splitAddress[POSTALCODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid address.
     */
    public static boolean isValidAddress(String test) {
        String[] splitAddress = test.split(", ");
        return splitAddress.length == 4
                && isValidBlock(splitAddress[BLOCK_INDEX])
                && isValidStreet(splitAddress[STREET_INDEX])
                && isValidUnit(splitAddress[UNIT_INDEX])
                && isValidPostalCode(splitAddress[POSTALCODE_INDEX]);
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
