package org.oblodiff.token.text.linebased;

import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualTokenContainerToken;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * This is a document is a full text that is line based.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Document extends TextualTokenContainerToken {

    /**
     * the characters dividing a {@link Document} in {@link Line}s.
     */
    private static final Collection<Character> DELIMITERS = new HashSet<>(Arrays.asList(
        '\r',
        '\n'
    ));

    /**
     * @param s the content this document represents.
     */
    public Document(String s) {
        super(s, DELIMITERS);
    }

    @Override
    protected Token newToken(String content) {
        return new Line(content);
    }
}
