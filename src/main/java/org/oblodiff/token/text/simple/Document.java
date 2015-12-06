package org.oblodiff.token.text.simple;

import java.util.Collection;

import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualSplittableToken;

import java.util.Stack;

import org.oblodiff.util.CharacterMatcher;

/**
 * This is a document which is a full text that is simple in terms of just plain text. <p> It consists of paragraphs,
 * sentences, words and characters. </p>
 * <p/>
 * XXX I think it is not a good idea to have two Document classes (line based). This makes it impossible for API clients
 * to use both of them, unless they reference it full qualified.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 * @since 1.0.0
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

    /**
     * Used to determine whether an offset in the content is a position of a divider. Since this document is divided
     * into paragraphs that by double line breaks this method checks whether a second line break follows while the first
     * line break has been found.
     *
     * @param begin            the offset where to start the search
     * @param isCarriageReturn {@code true}, if the first line break (preceding character) is a carriage return
     * @return {@code true}, if from the given offset a line break is found before the first non whitespace character.
     */
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
    protected void endReached(final Collection<Token> children, final int begin, final Character cc) {
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
    protected int addDivider(final Collection<Token> children, final int begin, final Character cc) {
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
