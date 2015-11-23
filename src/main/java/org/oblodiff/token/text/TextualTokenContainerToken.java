package org.oblodiff.token.text;

import org.oblodiff.token.api.Token;

import java.lang.Character;
import java.util.Collection;
import java.util.List;
import org.oblodiff.util.Validate;

/**
 * This is a more high level token that is based on a string which can be split at several positions, dividing this
 * token into child tokens and the child token dividers.
 *
 * XXX Why is the "token" two times in the class name?
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class TextualTokenContainerToken extends TextualSplittableToken {

    private final Collection<Character> delimiters;

    /**
     * Dedicated constructor.
     *
     * @param content must not be {@code null}
     * @param delimiters must not be {@code null}
     */
    public TextualTokenContainerToken(final String content, final Collection<Character> delimiters) {
        super(content);
        this.delimiters = Validate.notNull(delimiters, "delimiters");
    }

    @Override
    protected boolean shouldSplitAt(final int i, final Character character) {
        return delimiters.contains(character);
    }

    @Override
    protected int addDivider(final Collection<Token> children, final int begin, Character character) {
        children.add(new org.oblodiff.token.text.Character(character));
        return 1; // XXX What does 1 mean?
    }

    @Override
    protected void endReached(final Collection<Token> children, final int begin, Character character) {
        addToken(children, begin, getContent().length());
    }
}
