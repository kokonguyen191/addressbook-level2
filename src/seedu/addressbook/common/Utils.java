package seedu.addressbook.common;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Utility methods
 */
public class Utils {

    /**
     * Returns true if any of the given items are null.
     */
    public static boolean isAnyNull(Object... items) {
        for (Object item : items) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if every element the given collection are unique by {@link Object#equals(Object)}.
     */
    public static boolean elementsAreUnique(Collection<?> items) {
        final Set<Object> testSet = new HashSet<>();
        for (Object item : items) {
            final boolean itemAlreadyExists = !testSet.add(item); // see Set documentation
            if (itemAlreadyExists) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return true if two set of strings are not disjoint, regardless of capitalization.
     */
    public static boolean isCaseInsensitiveMatched(Set<String> firstSet, Set<String> secondSet) {
        List<String> firstSetInLowerCase = firstSet.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> secondSetInLowerCase = secondSet.stream().map(String::toLowerCase).collect(Collectors.toList());
        return Collections.disjoint(firstSetInLowerCase, secondSetInLowerCase);
    }
}
