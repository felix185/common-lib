package de.riefel.common.logging;

import java.util.logging.Level;

/**
 * Uses {@link java.util.logging.Logger} as base implementation for {@link Logger}.
 *
 * @author Felix Riess
 * @since 07.09.20
 */
public final class JavaUtilLogger implements Logger {

    private final java.util.logging.Logger logger;

    /**
     * {@link Level} has no built-in representation of FATAL log level, so we have to extend the existing.
     */
    private static class JavaUtilLoggerLevel extends Level {
        /**
         * generated serialVersionUID.
         */
        private static final long serialVersionUID = -6843919309015150754L;

        private static final Level FATAL = new JavaUtilLoggerLevel("FATAL", Level.SEVERE.intValue() + 100);

        private JavaUtilLoggerLevel(final String name, final int value) {
            super(name, value);
        }
    }

    JavaUtilLogger(final Class<?> clazz) {
        this.logger = java.util.logging.Logger.getLogger(clazz.getName());
    }

    private boolean isEnabled(final Level level) {
        return this.logger.isLoggable(level);
    }

    @Override
    public boolean isTraceEnabled() {
        return isEnabled(Level.FINEST);
    }

    @Override
    public boolean isDebugEnabled() {
        return isEnabled(Level.FINE);
    }

    @Override
    public void trace(String format, Object... args) {
        if(isTraceEnabled()) {
            this.logger.finest(format(format, args));
        }
    }

    @Override
    public void debug(String format, Object... args) {
        if(isDebugEnabled()) {
            this.logger.fine(format(format, args));
        }
    }

    @Override
    public void info(String format, Object... args) {
        if(isEnabled(Level.INFO)) {
            this.logger.info(format(format, args));
        }
    }

    @Override
    public void warn(String format, Object... args) {
        if(isEnabled(Level.WARNING)) {
            this.logger.warning(format(format, args));
        }
    }

    @Override
    public void error(String format, Object... args) {
        if(isEnabled(Level.SEVERE)) {
            this.logger.severe(format(format, args));
        }
    }

    @Override
    public void fatal(String format, Object... args) {
        if(isEnabled(JavaUtilLoggerLevel.FATAL)) {
            this.logger.log(JavaUtilLoggerLevel.FATAL, format(format, args));
        }
    }
}
