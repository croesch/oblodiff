package org.oblodiff.token.text;

import org.oblodiff.token.api.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A word is a textual token that is made up of characters.
 *
 * XXX Most of the classes in this package end with "Token". Why not this one?
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Word extends TextualToken<String> {

    /**
     * Dedicated constructor.
     *
     * @param content must not be {@code null}
     */
    public Word(final String content) {
        super(content);
    }

    @Override
    public final List<Token> getChildren() {
        final List<Token> children = new ArrayList<>();

        for (final java.lang.Character c : getContent().toCharArray()) {
            children.add(new Character(c));
        }

        return Collections.unmodifiableList(children);
    }
}
