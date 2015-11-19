package org.oblodiff.token.text.linebased;

import org.oblodiff.api.Token;
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

    private static final Collection<Character> DELIMITERS = new HashSet<>(Arrays.asList(
        new Character('\r'),
        new Character('\n')
    ));

    public Document(String s) {
        super(s, DELIMITERS);
    }

    @Override
    protected Token newSubject(String content) {
        return new Line(content);
    }
}
