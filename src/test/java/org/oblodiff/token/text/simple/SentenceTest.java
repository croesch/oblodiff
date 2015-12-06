package org.oblodiff.token.text.simple;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.oblodiff.token.text.Character;
import org.oblodiff.token.text.Word;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Sentence}.
 */
public class SentenceTest {
    @Test
    public void getChildren_shouldBeEmptyIfSentenceIsEmpty() {
        assertThat(new Sentence("").getChildren()).isEmpty();
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneNonWordCharacter() {
        assertThat(new Sentence(" ").getChildren()).containsExactly(new Character(' '));
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneWord() {
        assertThat(new Sentence("super").getChildren()).containsExactly(new Word("super"));
    }

    @Test
    public void getChildren_shouldAddNewSentenceAsCharacter() {
        assertThat(new Sentence("super\n").getChildren()).containsExactly(new Word("super"), new Character('\n'));
    }

    @Test
    public void getChildren_shouldAddWhiteSpacesAsCharacter() {
        assertThat(new Sentence("one word\tis").getChildren()).containsExactly(new Word("one"), new Character(' '), new Word
            ("word"), new Character('\t'), new Word("is"));
    }

    @Test
    public void getChildren_shouldAddMultipleWhiteSpacesAsCharacters() {
        assertThat(new Sentence("one  \tis").getChildren()).containsExactly(new Word("one"), new Character(' '), new
            Character(' '), new Character('\t'), new Word("is"));
    }

    @Test
    public void equalsAndHashCode() {
        // Null is avoided by validation in constructor.
        EqualsVerifier.forClass(Sentence.class).suppress(Warning.NULL_FIELDS).verify();
    }
}
