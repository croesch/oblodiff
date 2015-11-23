package org.oblodiff.token.text.simple;

import java.util.Collection;
import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualSplittableToken;

import java.util.Stack;

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

    private static final String NON_WHITE_SPACE_REGEX = "\\S";
    private static final String WHITE_SPACE_REGEX = "\\s";
    private static final Character CARRIAGE_RETURN = '\r';
    private static final Character LINE_FEED = '\n';

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
        final boolean isCarriageReturn = isCariageReturn(character);

        return (isCarriageReturn || isLineFeed(character))
            && containsBreakTillNextNonWhitespace(i + 1, isCarriageReturn);
    }

    private boolean containsBreakTillNextNonWhitespace(final int begin, final boolean isCarriageReturn) {
        for (int i = begin; i < getContent().length(); ++i) {
            final Character character = getContent().charAt(i);

            if (isCariageReturn(character)) {
                return true;
            }

            if (isLineFeed(character) && (i > begin || !isCarriageReturn)) {
                return true;
            }

            if (isNonWhiteSpace(character)) {
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

            if (isWhiteSpace(character)) {
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

            if (isWhiteSpace(character)) {
                children.add(new org.oblodiff.token.text.Character(character));
                ++inserted;
            } else {
                break;
            }
        }

        return inserted;
    }

    private boolean isLineFeed(final Character ch) {
        return LINE_FEED.equals(ch);
    }

    private boolean isCariageReturn(final Character ch) {
        return CARRIAGE_RETURN.equals(ch);
    }

    private boolean isWhiteSpace(final Character ch) {
        if (null == ch) {
            return false;
        }

        return String.valueOf(ch.charValue()).matches(WHITE_SPACE_REGEX);
    }

    private boolean isNonWhiteSpace(final Character ch) {
        if (null == ch) {
            return false;
        }

        return String.valueOf(ch.charValue()).matches(NON_WHITE_SPACE_REGEX);
    }
}
