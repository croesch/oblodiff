package org.oblodiff.token.text;

import org.oblodiff.token.api.Token;

import java.lang.Character;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a more high level token that is based on a string which can be split at several positions, dividing this
 * token into child tokens and the child token dividers.
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class TextualSplittableToken extends TextualToken<String> {

    /**
     * Dedicated constructor.
     *
     * @param content must not be {@code null}
     */
    public TextualSplittableToken(final String content) {
        super(content);
    }

    @Override
    public final List<Token> getChildren() {
        final List<Token> children = new ArrayList<>();
        int begin = 0;

        for (int i = 0; i < getContent().length(); ++i) {
            final Character character = getContent().charAt(i);

            if (shouldSplitAt(i, character)) {
                addToken(children, begin, i);
                int dividerSize = addDivider(children, i, character);
                begin = i + dividerSize;
                i += dividerSize - 1;
            } else if (i + 1 == getContent().length()) {
                endReached(children, begin, character);
            }
        }

        return children;
    }

    // TODO Add javadoc.
    protected final void addToken(final List<Token> children, final int begin, final int end) {
        if (end > begin) {
            children.add(newToken(getContent().substring(begin, end)));
        }
    }

    // TODO Add javadoc.
    protected abstract boolean shouldSplitAt(int i, Character character);
    // TODO Add javadoc.
    protected abstract Token newToken(String content);
    // TODO Add javadoc.
    protected abstract void endReached(List<Token> children, int begin, Character character);
    // TODO Add javadoc.
    protected abstract int addDivider(List<Token> children, int begin, Character character);
}
