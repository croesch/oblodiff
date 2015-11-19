package org.oblodiff.token.text;

import org.oblodiff.api.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * A word is a textual token that is made up of characters.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Word extends TextualToken<String> {

    public Word(String content) {
        super(content);
    }

    @Override
    public final List<Token> getChildren() {
        final List<Token> children = new ArrayList<>();

        for (java.lang.Character c : getContent().toCharArray()) {
            children.add(new Character(c));
        }

        return children;
    }
}
