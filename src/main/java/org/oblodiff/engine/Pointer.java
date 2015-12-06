package org.oblodiff.engine;

import java.util.Objects;

/**
 * A pointer is used to link tokens in the different stages of the diff algorithm. Its purpose is to link tokens of the
 * two token hierarchies being compared with oblodiff.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 * @since 1.0.0
 */
public class Pointer {
    /**
     * the address in an array or in the table.
     */
    private final int address;
    /**
     * never {@code null}.
     */
    private final PointerType type;

    /**
     * Dedicated constructor.
     *
     * @param address {@see #address}
     * @param type    {@see #type}
     */
    public Pointer(final int address, final PointerType type) {
        this.address = address;
        this.type = type;

    }

    /**
     * @return {@link #address}.
     */
    public final int getAddress() {
        return address;
    }

    /**
     * @return {@link #type}.
     */
    public final PointerType getType() {
        return type;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(address, type);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pointer)) {
            return false;
        }
        final Pointer other = (Pointer) obj;
        return Objects.equals(getAddress(), other.getAddress()) && Objects.equals(getType(), other.getType());
    }
}
