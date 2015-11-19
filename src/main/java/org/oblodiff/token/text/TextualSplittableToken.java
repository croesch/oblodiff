package org.oblodiff.token.text;

import org.oblodiff.token.api.Token;

import java.lang.Character;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a more high level token that is based on a string which can be split at several positions, dividing this
 * token into child tokens and the child token dividers.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class TextualSplittableToken extends TextualToken<String> {

    public TextualSplittableToken(String s) {
        super(s);
    }

    @Override
    public final List<Token> getChildren() {
        final List<Token> children = new ArrayList<>();
        int begin = 0;

        for (int i = 0; i < getContent().length(); ++i) {
            final Character character = getContent().charAt(i);

            if (shouldSplitAt(i, character)) {
                addSubject(children, begin, i);
                int dividerSize = addDivider(children, i, character);
                begin = i + dividerSize;
                i += dividerSize - 1;
            } else if (i + 1 == getContent().length()) {
                endReached(children, begin, character);
            }
        }

        return children;
    }

    protected final void addSubject(List<Token> children, int begin, int end) {
        if (end > begin) {
            children.add(newSubject(getContent().substring(begin, end)));
        }
    }

    protected abstract boolean shouldSplitAt(int i, Character character);

    protected abstract Token newSubject(String content);

    protected abstract void endReached(List<Token> children, int begin, Character character);

    protected abstract int addDivider(List<Token> children, int begin, Character character);
}
