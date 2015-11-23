package org.oblodiff.token.text.linebased;

import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualTokenContainerToken;
import org.oblodiff.token.text.Word;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * A line is a line as in line feed or line break. It is used to split a text into chunks as most other diff algorithms
 * do.
 *
 * XXX Should this class be named LineToken?
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Line extends TextualTokenContainerToken {

    /**
     * The characters dividing a text in {@link Word words}.
     */
    private static final Collection<Character> DELIMITERS
        = Collections.unmodifiableCollection(new HashSet<>(Arrays.asList(
            ' ',
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
    public Line(final String content) {
        super(content, DELIMITERS);
    }

    @Override
    protected Token newToken(String content) {
        return new Word(content);
    }
}
