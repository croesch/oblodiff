package org.oblodiff.token;

import java.util.List;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;
import static org.junit.Assert.*;
import org.oblodiff.token.api.Token;

/**
 * Tests for {@link BasicToken}.
 */
public class BasicTokenTest {



    @Test(expected = NullPointerException.class)
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void constructorDoesNotAllowNull() {
        new BasicTokenStub(null);
    }

    @Test
    public void equalsAndHashCode() {
        // Null is avoided by validation in constructor.
        EqualsVerifier.forClass(BasicToken.class).suppress(Warning.NULL_FIELDS).verify();
    }

    private static final class BasicTokenStub extends BasicToken<Void> {

        public BasicTokenStub(final Void content) {
            super(content);
        }

        @Override
        public List<Token> getChildren() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}
