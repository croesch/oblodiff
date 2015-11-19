package org.oblodiff.token.text;

import org.oblodiff.api.Token;

import java.lang.Character;
import java.util.Collection;
import java.util.List;

/**
 * This is a more high level token that is based on a string which can be split at several positions, dividing this
 * token into child tokens and the child token dividers.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class TextualTokenContainerToken extends TextualSplittableToken {

    private final Collection<Character> delimiters;

    public TextualTokenContainerToken(String s, Collection<Character> delimiters) {
        super(s);
        this.delimiters = delimiters;
    }

    @Override
    protected boolean shouldSplitAt(int i, Character character) {
        return delimiters.contains(character);
    }

    @Override
    protected int addDivider(List<Token> children, int begin, Character character) {
        children.add(new org.oblodiff.token.text.Character(character));
        return 1;
    }

    @Override
    protected void endReached(List<Token> children, int begin, Character character) {
        addSubject(children, begin, getContent().length());
    }
}
