package org.oblodiff.token.text.simple;

import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualTokenContainerToken;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * A paragraph is a bunch of sentences. Multiple paragraphs are usually separated by more than one line feed.
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Paragraph extends TextualTokenContainerToken {

    // XXX Usualy paragraphs are delimitted by (\r)\n(\r)\n.
    private static final Collection<Character> DELIMITERS
        = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            '.',
            '?',
            '!'
        )));

    /**
     * Dedicated constructor.
     *
     * @param content must not be {@code null}
     */
    public Paragraph(String content) {
        super(content, DELIMITERS);
    }

    @Override
    protected Token newToken(final String content) {
        return new Sentence(content);
    }

    @Override
    protected int addDivider(final Collection<Token> children, final int begin, Character cc) {
        int inserted = 0;
        for (int i = begin; i < getContent().length(); ++i) {
            final Character character = getContent().charAt(i);

            if (String.valueOf(character.charValue()).matches("\\s") || DELIMITERS.contains(character)) {
                children.add(new org.oblodiff.token.text.Character(character));
                ++inserted;
            } else {
                break;
            }
        }

        return inserted;
    }
}
