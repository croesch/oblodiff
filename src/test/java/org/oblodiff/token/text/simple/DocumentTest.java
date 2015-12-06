package org.oblodiff.token.text.simple;

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
        assertThat(new Document("super").getChildren()).containsExactly(new Paragraph("super"));
    }

    @Test
    public void getChildren_shouldAddNewLineAsCharacter() {
        assertThat(new Document("super\n").getChildren()).containsExactly(new Paragraph("super"), new Character('\n'));
    }

    @Test
    public void getChildren_shouldAddCarriageReturnAsCharacter() {
        assertThat(new Document("super\r").getChildren()).containsExactly(new Paragraph("super"), new Character('\r'));
    }

    @Test
    public void getChildren_shouldSplitParagraphsAtDoubleCarriageReturn() {
        assertThat(new Document("one\r\ris").getChildren()).containsExactly(new Paragraph("one"), new Character('\r'), new
            Character('\r'), new Paragraph("is"));
    }

    @Test
    public void getChildren_shouldSplitParagraphsAtDoubleLineFeed() {
        assertThat(new Document("one\n\nis").getChildren()).containsExactly(new Paragraph("one"), new Character('\n'), new
            Character('\n'), new Paragraph("is"));
    }

    @Test
    public void equalsAndHashCode() {
        // Null is avoided by validation in constructor.
        EqualsVerifier.forClass(Document.class).suppress(Warning.NULL_FIELDS).verify();
    }
}
