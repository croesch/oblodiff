package org.oblodiff.token.text.simple;

import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualTokenContainerToken;
import org.oblodiff.token.text.Word;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * A sentence is a couple of words. It is used to split a text into logical chunks.
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Sentence extends TextualTokenContainerToken {

    private static final Collection<Character> DELIMITERS
        = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            ' ',
            '\r',
            '\n',
            '\t',
            (char) 0x0b,
            '\f',
            '.',
            ',',
            '?',
            '!',
            '"',
            '\'',
            ':',
            ';'
        )));

    /**
     * Dedicated constructor.
     *
     * @param content must not be {@code null}
     */
    public Sentence(final String content) {
        super(content, DELIMITERS);
    }

    @Override
    protected Token newToken(final String content) {
        return new Word(content);
    }
}
