package de.riefel.common.logging;

/**
 * Base interface for all log events.
 * The {@link #getFormat()} method specifies the format string of the event, which contains placeholders "{}" for substitution with actual arguments.
 *
 * @author Felix Riess
 * @since 07.09.20
 */
public interface IEvent {
    /**
     * @return the {@link Level} of the message.
     */
    Level getLevel();

    /**
     * @return the format of the message.
     */
    String getFormat();

    /**
     * @return the id of the message.
     */
    String getId();
}
