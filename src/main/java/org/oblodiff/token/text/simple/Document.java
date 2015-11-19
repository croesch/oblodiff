package org.oblodiff.token.text.simple;

import org.oblodiff.api.Token;
import org.oblodiff.token.text.TextualSplittableToken;

import java.util.List;
import java.util.Stack;

/**
 * This is a document is a full text that is simple in terms of just plain text. It consists of paragraphs, sentences,
 * words and characters.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Document extends TextualSplittableToken {

    public static final Character CARRIAGE_RETURN = '\r';
    public static final Character LINE_FEED = '\n';

    public Document(String s) {
        super(s);
    }

    @Override
    protected boolean shouldSplitAt(int i, Character character) {
        boolean isCarriageReturn = character.equals(CARRIAGE_RETURN);
        return (isCarriageReturn || character.equals(LINE_FEED)) && containsBreakTillNextNonWhitespace(i + 1,
            isCarriageReturn);
    }

    private boolean containsBreakTillNextNonWhitespace(int begin, boolean isCarriageReturn) {
        for (int i = begin; i < getContent().length(); ++i) {
            final Character character = getContent().charAt(i);

            if (character.equals(CARRIAGE_RETURN)) {
                return true;
            }

            if (character.equals(LINE_FEED) && (i > begin || !isCarriageReturn)) {
                return true;
            }

            if (String.valueOf(character.charValue()).matches("\\S")) {
                return false;
            }
        }
        return false;
    }

    @Override
    protected Token newSubject(String content) {
        return new Sentence(content);
    }

    @Override
    protected void endReached(List<Token> children, int begin, Character cc) {
        final Stack<Character> whitespaces = new Stack<>();

        for (int i = getContent().length() - 1; i >= begin; --i) {
            Character character = getContent().charAt(i);

            if (String.valueOf(character.charValue()).matches("\\s")) {
                whitespaces.push(character);
            } else {
                break;
            }
        }
        addSubject(children, begin, getContent().length() - whitespaces.size());
        while (!whitespaces.isEmpty()) {
            children.add(new org.oblodiff.token.text.Character(whitespaces.pop()));
        }
    }

    @Override
    protected int addDivider(List<Token> children, int begin, Character cc) {
        int inserted = 0;
        for (int i = begin; i < getContent().length(); ++i) {
            final Character character = getContent().charAt(i);

            if (String.valueOf(character.charValue()).matches("\\s")) {
                children.add(new org.oblodiff.token.text.Character(character));
                ++inserted;
            } else {
                break;
            }
        }

        return inserted;
    }
}
