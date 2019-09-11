package de.riefel.common.errorhandling.exception;

import de.riefel.common.errorhandling.IErrorCode;

/**
 * Exception for all technical errors.
 *
 * @author Felix Riess
 * @since 11.09.19
 */
public class TechnicalException extends BaseException {

    /**
     * Generated serialVersionUID.
     */
    private static final long serialVersionUID = 4770075034104672782L;

    /**
     * Generates a new {@link TechnicalException}.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param message the error message of this exception as {@link String}.
     */
    public TechnicalException(final IErrorCode errorCode, final String message) {
        super(errorCode, message);
    }

    /**
     * Generates a new {@link TechnicalException}.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param cause the {@link Throwable} of this exception.
     */
    public TechnicalException(final IErrorCode errorCode, final Throwable cause) {
        super(errorCode, cause);
    }

    /**
     * Generates a new {@link TechnicalException}.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param message the error message of this exception as {@link String}.
     * @param cause the {@link Throwable} of this exception.
     */
    public TechnicalException(final IErrorCode errorCode, final String message, final Throwable cause) {
        super(errorCode, message, cause);
    }
}
