package de.riefel.common.logging;

/**
 * Enum representing different log levels.
 *
 * @author Felix Riess
 * @since 07.09.20
 */
public enum Level {
    /**
     * e.g. payload of interface calls, should not be used very often and always be checked with isEnabled.
     */
    TRACE,
    /**
     * detailed application logs. useful for developers to debug application. usually not visible in production.
     */
    DEBUG,
    /**
     * application logs to see main processing steps of the application.
     */
    INFO,
    /**
     * handled error which does <b>not</b> have an impact on further execution of the application. Most of the times business errors.
     */
    WARN,
    /**
     * error which has an impact on further execution of the application. Most of the times technical errors.
     */
    ERROR,
    /**
     * serious error which should usually not come from the application itself.
     */
    FATAL,
    ;
}
