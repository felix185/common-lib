package de.riefel.common.errorhandling;

/**
 * Some basic error codes.
 *
 * @author Felix Riess
 * @since 11.09.19
 */
public enum BaseErrorCode implements IErrorCode {
    /**
     * Technical errors.
     */
    INTERNAL(ErrorCategory.TECHNICAL, "Internal Error"),
    UNEXPECTED(ErrorCategory.TECHNICAL, "Unexpected Error"),
    ILLEGAL_ACCESS(ErrorCategory.TECHNICAL, "Illegal Access Error"),
    /**
     * Business errors.
     */
    INVALID_ARGUMENT(ErrorCategory.BUSINESS, "Invalid Argument Error"),
    NOT_FOUND(ErrorCategory.BUSINESS, "Not Found Error"),
    ALREADY_EXISTING(ErrorCategory.BUSINESS, "Already Existing Error"),
    /**
     * Undefined errors.
     */
    UNDEFINED(ErrorCategory.UNDEFINED, "Undefined Error"),
    ;

    /**
     * The {@link ErrorCategory} of this {@link BaseErrorCode}.
     */
    private final ErrorCategory category;
    /**
     * The description of this {@link BaseErrorCode}.
     */
    private final String description;

    /**
     * Constructor.
     *
     * @param category the {@link ErrorCategory} of this {@link BaseErrorCode}.
     * @param description the description as {@link String} of this {@link BaseErrorCode}.
     */
    BaseErrorCode(final ErrorCategory category, final String description) {
        this.category = category;
        this.description = description;
    }

    @Override
    public ErrorCategory getErrorCategory() {
        return this.category;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
