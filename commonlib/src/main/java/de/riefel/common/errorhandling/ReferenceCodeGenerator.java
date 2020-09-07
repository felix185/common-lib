package de.riefel.common.errorhandling;

import de.riefel.common.errorhandling.exception.TechnicalException;
import de.riefel.common.validation.Preconditions;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Utility class to generate reference codes for exceptions/errors.
 *
 * @author Felix Riess
 * @since 07.09.20
 */
public final class ReferenceCodeGenerator {

    private ReferenceCodeGenerator() {
        throw new TechnicalException(BaseErrorCode.ILLEGAL_ACCESS, "ReferenceCodeGenerator is a utility class with static methods and must not be instantiated");
    }

    /**
     * Generates a random 6 digit reference code.
     *
     * @return the generated reference code.
     */
    public static String generateReferenceCode() {
        return generateReferenceCode(6);
    }

    /**
     * Generates a random reference code with the provided length.
     *
     * @param length the length of the code to be generated.
     * @return
     */
    public static String generateReferenceCode(final int length) {

        final long generated = ThreadLocalRandom.current().nextLong((long)Math.pow(10, length - 1), (long)(Math.pow(10, length) - 1));
        return String.valueOf(generated);
    }
}
