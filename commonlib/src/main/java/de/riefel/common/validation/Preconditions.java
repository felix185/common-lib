package de.riefel.common.validation;

import de.riefel.common.errorhandling.BaseErrorCode;
import de.riefel.common.errorhandling.exception.BusinessException;
import de.riefel.common.errorhandling.exception.TechnicalException;

/**
 * A simple helper class to check arguments.
 *
 * @author Felix Riess
 * @since 11.09.19
 */
public final class Preconditions {

    /**
     * private constructor to hide implicit public one.
     */
    private Preconditions() {
        throw new TechnicalException(BaseErrorCode.ILLEGAL_ACCESS, "Preconditions is a utility class with static methods and must not be instantiated");
    }

    /**
     * Check if reference is null.
     *
     * @param reference the reference to be not {@code null}.
     * @param errorMessage the error message to use if reference is {@code null}.
     * @param <T> the generic type.
     * @return the reference if everything is fine.
     */
    public static <T> T checkNotNull(final T reference, final String errorMessage) {
        if(reference == null) {
            fail(errorMessage);
        } // else: everything is fine. return reference.
        return reference;
    }

    /**
     * Fail(= throw {@link BusinessException}) with the provided message.
     *
     * @param errorMessage the message to be thrown with the {@link BusinessException}.
     */
    private static void fail(final String errorMessage) {
        throw new BusinessException(BaseErrorCode.INVALID_ARGUMENT, errorMessage);
    }
}
