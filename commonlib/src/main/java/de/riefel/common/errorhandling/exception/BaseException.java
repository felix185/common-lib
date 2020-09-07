package de.riefel.common.errorhandling.exception;

import de.riefel.common.errorhandling.IErrorCode;
import de.riefel.common.errorhandling.ReferenceCodeGenerator;
import de.riefel.common.logging.Logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;

/**
 * Base exception.
 * All exception classes should extend this one.
 *
 * @author Felix Riess
 * @since 09.09.19
 */
abstract class BaseException extends RuntimeException implements Serializable {
    /**
     * Generated serialVersionUID.
     */
    private static final long serialVersionUID = -4056617798934096073L;

    /**
     * The {@link Logger}
     */
    private static final Logger LOG = Logger.getLogger(BaseException.class);

    /**
     * A message if no stacktrace is available (should usually not happen!!!)
     */
    private static final String NO_STACKTRACE_AVAILABLE = "[NO STACKTRACE AVAILABLE]";

    /**
     * The {@link IErrorCode} of this exception.
     */
    private final IErrorCode errorCode;

    /**
     * The generated reference code of this exception.
     */
    private final String referenceCode;

    /**
     * Constructor.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param message the error message of this exception as {@link String}.
     */
    BaseException(final IErrorCode errorCode, final String message) {
        super(getFormattedErrorCode(errorCode) + ": " + message);
        this.errorCode = errorCode;
        this.referenceCode = ReferenceCodeGenerator.generateReferenceCode();
        LOG.error("{}: {}", getFormattedErrorCode(errorCode), message);
        LOG.info("Generated reference code for exception with error code '{}' is: '{}'", getFormattedErrorCode(errorCode), this.referenceCode);
    }

    /**
     * Constructor.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param cause the {@link Throwable} of this exception.
     */
    BaseException(final IErrorCode errorCode, final Throwable cause) {
        this(errorCode, convertStacktraceToString(cause));
    }

    /**
     * Constructor.
     *
     * @param errorCode the {@link IErrorCode} of this exception.
     * @param message the error message of this exception as {@link String}.
     * @param cause the {@link Throwable} of this exception.
     */
    BaseException(final IErrorCode errorCode, final String message, final Throwable cause) {
        this(errorCode, message + System.lineSeparator() + convertStacktraceToString(cause));
    }

    /**
     * Get the {@link IErrorCode} of this exception.
     *
     * @return the {@link IErrorCode} of this exception.
     */
    public IErrorCode getErrorCode() {
        return this.errorCode;
    }

    /**
     * Get the reference code of this exception.
     *
     * @return the reference code.
     */
    public String getReferenceCode() {
        return this.referenceCode;
    }

    /**
     * Formats the given {@link IErrorCode} to a human readable {@link String}.
     *
     * @param errorCode the {@link IErrorCode} to format.
     * @return the formatted {@link String}.
     */
    private static String getFormattedErrorCode(final IErrorCode errorCode) {
        return "[" + errorCode.getErrorCategory() + "] " + errorCode.getDescription();
    }

    /**
     * Converts the stacktrace of the provided {@link Throwable} to a {@link String}.
     *
     * @param ex the stacktrace of this {@link Throwable} will be converted.
     * @return the stacktrace as {@link String} or {@link #NO_STACKTRACE_AVAILABLE} if provided {@link Throwable} is {@code null}.
     */
    private static String convertStacktraceToString(final Throwable ex) {
        if(ex != null) {
            final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ex.printStackTrace(new PrintStream(stream));
            return new String(stream.toByteArray());
        } else {
            return NO_STACKTRACE_AVAILABLE;
        }
    }
}
