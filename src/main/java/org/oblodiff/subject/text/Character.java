package org.oblodiff.subject.text;

import org.oblodiff.api.Subject;

import java.util.Collections;
import java.util.List;

/**
 * A character is a textual subject that represents a single char.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Character extends TextualSubject<java.lang.Character> {

    public Character(java.lang.Character character) {
        super(character);
    }

    @Override
    public List<Subject> getChildren() {
        return Collections.emptyList();
    }
}
