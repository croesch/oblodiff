package org.oblodiff.token.text.linebased;

import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualTokenContainerToken;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * This is a document is a full text that is line based.
 *
 * XXX Should this class be named DocumentToken?
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Document extends TextualTokenContainerToken {

    /**
     * The characters dividing a {@link Document document} in {@link Line lines}.
     */
    private static final Collection<Character> DELIMITERS
        = Collections.unmodifiableCollection(new HashSet<>(Arrays.asList(
            CARRIAGE_RETURN,
            LINE_FEED
        )));

    /**
     * Dedicated constructor.
     *
     * @param content must not be {@code null}
     */
    public Document(final String content) {
        super(content, DELIMITERS);
    }

    @Override
    protected Token newToken(final String content) {
        return new Line(content);
    }
}
