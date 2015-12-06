package org.oblodiff.token.text;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Character}.
 */
public class CharacterTest {

    @Test
    public void getChildren_shouldBeEmpty() {
        assertThat(new Character('.').getChildren()).isEmpty();
        assertThat(new Character('M').getChildren()).isEmpty();
    }

    @Test
    public void equalsAndHashCode() {
        // Null is avoided by validation in constructor.
        EqualsVerifier.forClass(Character.class).suppress(Warning.NULL_FIELDS).verify();
    }
}
