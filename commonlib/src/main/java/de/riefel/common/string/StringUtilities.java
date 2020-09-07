package de.riefel.common.string;

import de.riefel.common.errorhandling.BaseErrorCode;
import de.riefel.common.errorhandling.exception.TechnicalException;

/**
 * A simple utility class for string operations.
 *
 * @author Felix Riess
 * @since 07.09.20
 */
public final class StringUtilities {

    private StringUtilities() {
        throw new TechnicalException(BaseErrorCode.ILLEGAL_ACCESS, "StringUtilities is a utility class with static methods and must not be instantiated");
    }

    /**
     * Check if provided string is {@code null} or empty.
     *
     * @param str the {@link String} to be checked.
     * @return {@code true} if provided string is {@çode null} or empty, {@code false} otherwise.
     */
    public static boolean isNullOrEmpty(final String str) {
        return (str == null) || (str.isEmpty());
    }
}
