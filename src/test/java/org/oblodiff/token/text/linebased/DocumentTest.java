package org.oblodiff.token.text.linebased;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.oblodiff.token.text.Character;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Document}.
 */
public class DocumentTest {
    @Test
    public void getChildren_shouldBeEmptyIfDocumentIsEmpty() {
        assertThat(new Document("").getChildren()).isEmpty();
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneCarriageReturn() {
        assertThat(new Document("\r").getChildren()).containsExactly(new Character('\r'));
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneLineFeed() {
        assertThat(new Document("\n").getChildren()).containsExactly(new Character('\n'));
    }

    @Test
    public void getChildren_shouldReturnOneChildIfConsistsOfOneLine() {
        assertThat(new Document("super").getChildren()).containsExactly(new Line("super"));
    }

    @Test
    public void getChildren_shouldAddNewLineAsCharacter() {
        assertThat(new Document("super\n").getChildren()).containsExactly(new Line("super"), new Character('\n'));
    }

    @Test
    public void getChildren_shouldAddCarriageReturnAsCharacter() {
        assertThat(new Document("super\r").getChildren()).containsExactly(new Line("super"), new Character('\r'));
    }

    @Test
    public void getChildren_shouldAddCarriageReturnLineFeedAsCharacters() {
        assertThat(new Document("one\r\nis").getChildren()).containsExactly(new Line("one"), new Character('\r'), new
            Character('\n'), new Line("is"));
    }

    @Test
    public void equalsAndHashCode() {
        // Null is avoided by validation in constructor.
        EqualsVerifier.forClass(Document.class).suppress(Warning.NULL_FIELDS).verify();
    }
}
