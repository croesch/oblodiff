package org.oblodiff.token.text;

import org.oblodiff.token.api.Token;

import java.util.Collections;
import java.util.List;

/**
 * A character is a textual token that represents a single char.
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Character extends TextualToken<java.lang.Character> {

    /**
     * @param character the real character this represents.
     */
    public Character(java.lang.Character character) {
        super(character);
    }

    @Override
    public List<Token> getChildren() {
        return Collections.emptyList();
    }
}
