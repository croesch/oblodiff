package org.oblodiff.token.text;

import org.oblodiff.token.api.Token;

import java.util.Collections;
import java.util.List;

/**
 * A character is a textual token that represents a single char.
 *
 * XXX I recommend to rename this class to CharacterToken to avoid name lash with java.lang.Character.
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Character extends TextualToken<java.lang.Character> {

    /**
     * @param character the real character this represents.
     */
    public Character(final java.lang.Character character) {
        super(character);
    }

    @Override
    public List<Token> getChildren() {
        return Collections.emptyList();
    }
}
