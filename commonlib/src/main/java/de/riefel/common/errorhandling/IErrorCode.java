package de.riefel.common.errorhandling;

/**
 * An interface to be implemented by all error codes.
 *
 * @author Felix Riess
 * @since 09.09.19
 */
public interface IErrorCode {
    /**
     * Get the {@link ErrorCategory} of this specific error.
     *
     * @return the {@link ErrorCategory}.
     */
    ErrorCategory getErrorCategory();

    /**
     * Get a human readable description of this specific error.
     *
     * @return the description as {@link String}.
     */
    String getDescription();
}
