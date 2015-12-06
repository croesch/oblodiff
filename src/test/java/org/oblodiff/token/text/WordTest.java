package org.oblodiff.token.text;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Word}.
 */
public class WordTest {

    @Test
    public void getChildren_shouldBeEmptyIfWordIsEmpty() {
        assertThat(new Word("").getChildren()).isEmpty();
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneCharacter() {
        assertThat(new Word("a").getChildren()).containsExactly(new Character('a'));
    }

    @Test
    public void getChildren_shouldReturnOneChildForEachCharacterInSameOrder() {
        assertThat(new Word("abc").getChildren()).containsExactly(new Character('a'), new Character('b'), new Character('c'));
    }

    @Test
    public void equalsAndHashCode() {
        // Null is avoided by validation in constructor.
        EqualsVerifier.forClass(Word.class).suppress(Warning.NULL_FIELDS).verify();
    }
}
