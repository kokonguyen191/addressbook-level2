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

    /**
     * Validates given postal code.
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
        this.block = new Block(splitAddress[0]);
        this.street = new Street(splitAddress[1]);
        this.unit = new Unit(splitAddress[2]);
        this.postalCode = new PostalCode(splitAddress[3]);
    }

    /**
     * Returns true if a given string is a valid address.
     */
    public static boolean isValidAddress(String test) {
        String[] splitAddress = test.split(", ");
        return splitAddress.length == 4
                && isValidBlock(splitAddress[0])
                && isValidStreet(splitAddress[1])
                && isValidUnit(splitAddress[2])
                && isValidPostalCode(splitAddress[3]);
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
