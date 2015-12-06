package org.oblodiff.token.text.simple;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.oblodiff.token.text.Character;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Paragraph}.
 */
public class ParagraphTest {
    @Test
    public void getChildren_shouldBeEmptyIfParagraphIsEmpty() {
        assertThat(new Paragraph("").getChildren()).isEmpty();
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneExclamationMark() {
        assertThat(new Paragraph("!").getChildren()).containsExactly(new Character('!'));
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneQuestionMark() {
        assertThat(new Paragraph("?").getChildren()).containsExactly(new Character('?'));
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOnePeriod() {
        assertThat(new Paragraph(".").getChildren()).containsExactly(new Character('.'));
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneSentence() {
        assertThat(new Paragraph("super").getChildren()).containsExactly(new Sentence("super"));
    }

    @Test
    public void getChildren_shouldAddExclamationMarkAsCharacter() {
        assertThat(new Paragraph("super!").getChildren()).containsExactly(new Sentence("super"), new Character('!'));
    }

    @Test
    public void getChildren_shouldAddQuestionMarkAsCharacter() {
        assertThat(new Paragraph("super?").getChildren()).containsExactly(new Sentence("super"), new Character('?'));
    }

    @Test
    public void getChildren_shouldAddWhitespaceBetweenSentencesAsCharacters() {
        assertThat(new Paragraph("one. is").getChildren()).containsExactly(new Sentence("one"), new Character('.'), new
            Character(' '), new Sentence("is"));
    }

    @Test
    public void equalsAndHashCode() {
        // Null is avoided by validation in constructor.
        EqualsVerifier.forClass(Paragraph.class).suppress(Warning.NULL_FIELDS).verify();
    }
}
