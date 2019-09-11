package de.riefel.common.base.types;

import java.io.Serializable;

/**
 * Abstract base entity type.
 *
 * @author Felix Riess
 * @since 11.09.19
 */
public abstract class AbstractET implements Serializable {
    /**
     * Generated serialVersionUID.
     */
    private static final long serialVersionUID = 1758257439385030783L;

    /**
     * The ID of this entity.
     */
    protected long id;

    /**
     * The version of this entity for optimistic locking.
     */
    protected long version;

    /**
     * Get the id.
     * @return the id.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Get the version.
     * @return the version.
     */
    public long getVersion() {
        return this.version;
    }
}
