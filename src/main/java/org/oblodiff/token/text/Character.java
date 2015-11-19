package org.oblodiff.token.text;

import org.oblodiff.token.api.Token;

import java.util.Collections;
import java.util.List;

/**
 * A character is a textual token that represents a single char.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Character extends TextualToken<java.lang.Character> {

    public Character(java.lang.Character character) {
        super(character);
    }

    @Override
    public List<Token> getChildren() {
        return Collections.emptyList();
    }
}
