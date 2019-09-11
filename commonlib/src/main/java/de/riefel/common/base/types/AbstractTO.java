package de.riefel.common.base.types;

import java.io.Serializable;

/**
 * Abstract base transport object.
 *
 * @author Felix Riess
 * @since 11.09.19
 */
public abstract class AbstractTO implements Serializable {

    /**
     * Generated serialVersionUID.
     */
    private static final long serialVersionUID = -234911041126905153L;

    /**
     * The ID of the entity.
     */
    protected long id;

    /**
     * The version field for optimistic locking.
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
