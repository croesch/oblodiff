package org.oblodiff.engine;

/**
 * A {@link Pointer} can have different meanings in the diff algorithm and to avoid instanceof-checks this enumeration
 * specifies the types of {@link Pointer} that are available.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public enum PointerType {
    /**
     * A pointer to the table containing unmatched objects. TODO insert link to documentation of the table meant here.
     */
    TABLE,
    /**
     * A pointer to the other array of pointers linking an exact match of tokens.
     */
    ARRAY_EXACT,
    /**
     * A pointer to the other array of pointers linking two different tokens that are considered to be similar enough.
     */
    ARRAY_SIMILAR
}
