package org.oblodiff.token.text.simple;

import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualTokenContainerToken;
import org.oblodiff.token.text.Word;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.oblodiff.util.Delimiters;

/**
 * A sentence is a couple of words. It is used to split a text into logical chunks.
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Sentence extends TextualTokenContainerToken {

    /**
     * The characters dividing a {@link Sentence sentence} in {@link Word words}.
     */
    private static final Collection<Character> DELIMITERS
        = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(Delimiters.SPACE,
            Delimiters.CARRIAGE_RETURN,
            Delimiters.LINE_FEED,
            Delimiters.TABULATOR,
            Delimiters.VERTICAL_TABULATOR,
            Delimiters.FORM_FEED,
            Delimiters.PERIOD,
            Delimiters.COMMA,
            Delimiters.QUESTION_MARK,
            Delimiters.EXCLAMATION_MARK,
            Delimiters.DOUBLE_QUOTE,
            Delimiters.SINGLE_QUOTE,
            Delimiters.COLON,
            Delimiters.SEMICOLON
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
