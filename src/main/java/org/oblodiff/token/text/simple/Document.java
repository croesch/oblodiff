package org.oblodiff.token.text.simple;

import java.util.Collection;
import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualSplittableToken;

import java.util.Stack;
import org.oblodiff.util.CharacterMatcher;

/**
 * This is a document which is a full text that is simple in terms of just plain text.
 * <p>
 * It consists of paragraphs, sentences, words and characters.
 * </p>
 *
 * XXX I think it is not a good idea to have two Document classes (line based). This makes it impossible for API clients
 * to use both of them, unless they reference it full qualified.
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Document extends TextualSplittableToken {

    /**
     * Dedicated constructor.
     *
     * @param content must not be {@code null}
     */
    public Document(final String content) {
        super(content);
    }

    @Override
    protected boolean shouldSplitAt(final int i, final Character character) {
        final boolean isCarriageReturn = CharacterMatcher.isCariageReturn(character);

        return (isCarriageReturn || CharacterMatcher.isLineFeed(character))
            && containsBreakTillNextNonWhitespace(i + 1, isCarriageReturn);
    }

    private boolean containsBreakTillNextNonWhitespace(final int begin, final boolean isCarriageReturn) {
        for (int i = begin; i < getContent().length(); ++i) {
            final Character character = getContent().charAt(i);

            if (CharacterMatcher.isCariageReturn(character)) {
                return true;
            }

            if (CharacterMatcher.isLineFeed(character) && (i > begin || !isCarriageReturn)) {
                return true;
            }

            if (CharacterMatcher.isNonWhiteSpace(character)) {
                return false;
            }
        }

        return false;
    }

    @Override
    protected Token newToken(final String content) {
        return new Sentence(content);
    }

    @Override
    protected void endReached(final Collection<Token> children, final int begin, Character cc) {
        final Stack<Character> whitespaces = new Stack<>();

        for (int i = getContent().length() - 1; i >= begin; --i) {
            final Character character = getContent().charAt(i);

            if (CharacterMatcher.isWhiteSpace(character)) {
                whitespaces.push(character);
            } else {
                break;
            }
        }

        addToken(children, begin, getContent().length() - whitespaces.size());

        while (!whitespaces.isEmpty()) {
            children.add(new org.oblodiff.token.text.Character(whitespaces.pop()));
        }
    }

    @Override
    protected int addDivider(final Collection<Token> children, final int begin, Character cc) {
        int inserted = 0;

        for (int i = begin; i < getContent().length(); ++i) {
            final Character character = getContent().charAt(i);

            if (CharacterMatcher.isWhiteSpace(character)) {
                children.add(new org.oblodiff.token.text.Character(character));
                ++inserted;
            } else {
                break;
            }
        }

        return inserted;
    }

}
