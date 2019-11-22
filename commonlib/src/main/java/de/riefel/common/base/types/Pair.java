package de.riefel.common.base.types;

/**
 * Simple interface to transport two objects.
 * Useful to return more than one object without creating a {@link java.util.Map}.
 *
 * @author Felix Riess
 * @since 22.11.19
 */
public interface Pair<L, R> {
    /**
     * first object in this {@link Pair}.
     *
     * @return the first object.
     */
    L getL();

    /**
     * second object in this {@link Pair}.
     *
     * @return the second object.
     */
    R getR();

    /**
     * Factory method to create a new {@link Pair} instance.
     *
     * @param l first object of the {@link Pair}.
     * @param r second object of the {@link Pair}.
     * @param <L> type of the first object
     * @param <R> type of the second object
     * @return a new {@link Pair} instance holding the first and second object.
     */
    static <L, R> Pair<L, R> makePair(final L l, final R r) {
        return new Pair<L, R>() {
            @Override
            public L getL() {
                return l;
            }

            @Override
            public R getR() {
                return r;
            }
        };
    }
}
