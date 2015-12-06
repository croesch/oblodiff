package org.oblodiff.token.text.linebased;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.oblodiff.token.text.Character;
import org.oblodiff.token.text.Word;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Line}.
 */
public class LineTest {
    @Test
    public void getChildren_shouldBeEmptyIfLineIsEmpty() {
        assertThat(new Line("").getChildren()).isEmpty();
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneNonWordCharacter() {
        assertThat(new Line(" ").getChildren()).containsExactly(new Character(' '));
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneWord() {
        assertThat(new Line("super").getChildren()).containsExactly(new Word("super"));
    }

    @Test
    public void getChildren_shouldAddWhiteSpacesAsCharacter() {
        assertThat(new Line("one word\tis").getChildren()).containsExactly(new Word("one"), new Character(' '), new Word
            ("word"), new Character('\t'), new Word("is"));
    }

    @Test
    public void getChildren_shouldAddMultipleWhiteSpacesAsCharacters() {
        assertThat(new Line("one  \tis").getChildren()).containsExactly(new Word("one"), new Character(' '), new
            Character(' '), new Character('\t'), new Word("is"));
    }

    @Test
    public void equalsAndHashCode() {
        // Null is avoided by validation in constructor.
        EqualsVerifier.forClass(Line.class).suppress(Warning.NULL_FIELDS).verify();
    }
}
