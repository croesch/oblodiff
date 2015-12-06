package org.oblodiff.engine;

import static org.assertj.core.api.Assertions.assertThat;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

/**
 * Tests for {@link Pointer}.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class PointerTest {
    @Test
    public void getAddress_shouldReturnValueFromConstructorInitially() {
        assertThat(new Pointer(42, PointerType.ARRAY_EXACT).getAddress()).isEqualTo(42);
        assertThat(new Pointer(4711, PointerType.TABLE).getAddress()).isEqualTo(4711);
    }

    @Test
    public void getType_shouldReturnValueFromConstructorInitially() {
        assertThat(new Pointer(42, PointerType.ARRAY_EXACT).getType()).isEqualTo(PointerType.ARRAY_EXACT);
        assertThat(new Pointer(4711, PointerType.TABLE).getType()).isEqualTo(PointerType.TABLE);
    }
    @Test
    public void equalsAndHashCode() {
        // Null is avoided by validation in constructor.
        EqualsVerifier.forClass(Pointer.class).suppress(Warning.NULL_FIELDS).verify();
    }
}
