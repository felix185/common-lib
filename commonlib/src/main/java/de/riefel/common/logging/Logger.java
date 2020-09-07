package de.riefel.common.logging;

/**
 * A log4j-like interface for logging.
 *
 * @author Felix Riess
 * @since 07.09.20
 */
public interface Logger {

    /**
     * Returns a new instance of an {@link Logger}.
     *
     * @param clazz the {@link Class} for which the logger should be instantiated.
     * @return a {@link Logger} for the specified {@link Class}.
     */
    static Logger getLogger(final Class<?> clazz) {
        return new JavaUtilLogger(clazz);
    }

    /**
     * @return {@code true} if trace level is enabled, {@code false} otherwise.
     */
    boolean isTraceEnabled();

    /**
     * @return {@code true} if debug level is enabled, {@code false} otherwise.
     */
    boolean isDebugEnabled();

    /**
     * Logs an event of the specified type and associated arguments.
     *
     * @param event the event type as {@link IEvent}.
     * @param args additional arguments for the log message.
     */
    default void log(final IEvent event, final Object...args) {
        final String format = event.getId() + ": " + event.getFormat();
        switch (event.getLevel()) {
            case TRACE:
                trace(format, args);
                break;
            case DEBUG:
                debug(format, args);
                break;
            case INFO:
                info(format, args);
                break;
            case WARN:
                warn(format, args);
                break;
            case ERROR:
                error(format, args);
                break;
            case FATAL:
                fatal(format, args);
                break;
        }
    }

    /**
     * Logs a message with the provided format and arguments on {@link Level#TRACE}.
     *
     * @param format the format of the message as {@link String}.
     * @param args optional additional arguments for the message.
     */
    void trace(final String format, final Object...args);

    /**
     * Logs a message with the provided format and arguments on {@link Level#DEBUG}.
     *
     * @param format the format of the message as {@link String}.
     * @param args optional additional arguments for the message.
     */
    void debug(final String format, final Object...args);

    /**
     * Logs a message with the provided format and arguments on {@link Level#INFO}.
     *
     * @param format the format of the message as {@link String}.
     * @param args optional additional arguments for the message.
     */
    void info(final String format, final Object...args);

    /**
     * Logs a message with the provided format and arguments on {@link Level#WARN}.
     *
     * @param format the format of the message as {@link String}.
     * @param args optional additional arguments for the message.
     */
    void warn(final String format, final Object...args);

    /**
     * Logs a message with the provided format and arguments on {@link Level#ERROR}.
     *
     * @param format the format of the message as {@link String}.
     * @param args optional additional arguments for the message.
     */
    void error(final String format, final Object...args);

    /**
     * Logs a message with the provided format and arguments on {@link Level#FATAL}.
     *
     * @param format the format of the message as {@link String}.
     * @param args optional additional arguments for the message.
     */
    void fatal(final String format, final Object...args);

    /**
     * Logs the execution time of an operation in milliseconds on {@link Level#INFO}.
     *
     * @param operationName the name of the operation which was executed.
     * @param executionTimeInMillis the execution time in milliseconds.
     */
    default void logExecutionTime(final String operationName, final long executionTimeInMillis) {
        info("Execution of '{}' took {} ms", operationName, executionTimeInMillis);
    }

    /**
     * Formats the provided {@link String} (with '{}' as placeholders) with its arguments to a {@link String}.
     *
     * @param format the format of the message with placeholders.
     * @param args optional arguments with which the placeholders should be filled.
     * @return a formatted {@link String} with placeholders replaced by actual arguments.
     */
    default String format(final String format, final Object...args) {
        if(args.length == 0) {
            return format;
        }
        final StringBuilder logBuilder = new StringBuilder();
        int position = 0;
        for(int i = 0; i < args.length; i++) {
            int index = format.indexOf("{}", position);
            if(index < 0) {
                break;
            }
            logBuilder.append(format.substring(position, index));
            logBuilder.append(args[i] == null ? "null" : args[i].toString());
            position = index + 2;
        }
        if(format.length() > position) {
            logBuilder.append(format.substring(position));
        }
        return logBuilder.toString();
    }

    /**
     * Formats the provided {@link IEvent} with its arguments to a {@link String}.
     *
     * @param event the {@link IEvent} for the message.
     * @param args the arguments with which placeholders should be filled.
     * @return the formatted {@link String} with the placeholders replaced by actual arguments.
     */
    default String format(final IEvent event, final Object...args) {
        return format(event.getFormat(), args);
    }
}
