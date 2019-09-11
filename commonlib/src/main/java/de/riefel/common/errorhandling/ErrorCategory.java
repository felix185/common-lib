package de.riefel.common.errorhandling;

/**
 * Categories for the different {@link IErrorCode}s.
 *
 * @author Felix Riess
 * @since 09.09.19
 */
public enum ErrorCategory {
    /**
     * {@link ErrorCategory} for all technical errors.
     */
    TECHNICAL("Technical Error"),
    /**
     * {@link ErrorCategory} for all business errors.
     */
    BUSINESS("Business Error"),
    /**
     * {@link ErrorCategory} for all undefined errors.
     */
    UNDEFINED("Undefined Error"),
    ;

    /**
     * The description of this specific {@link ErrorCategory}.
     */
    private final String description;

    /**
     * Constructor.
     *
     * @param description the description of this {@link ErrorCategory} as {@link String}.
     */
    ErrorCategory(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
