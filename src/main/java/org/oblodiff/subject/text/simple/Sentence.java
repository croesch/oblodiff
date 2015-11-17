package org.oblodiff.subject.text.simple;

import org.oblodiff.api.Subject;
import org.oblodiff.subject.text.TextualSubjectContainerSubject;
import org.oblodiff.subject.text.Word;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * A sentence is a couple of words. It is used to split a text into logical chunks.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Sentence extends TextualSubjectContainerSubject {

    private static final Collection<Character> DELIMITERS = new HashSet<>(Arrays.asList(
        new Character(' '),
        new Character('\r'),
        new Character('\n'),
        new Character('\t'),
        new Character((char) 0x0b),
        new Character('\f'),
        new Character('.'),
        new Character(','),
        new Character('?'),
        new Character('!'),
        new Character('"'),
        new Character('\''),
        new Character(':'),
        new Character(';')
    ));

    public Sentence(String s) {
        super(s, DELIMITERS);
    }

    @Override
    protected Subject newSubject(String content) {
        return new Word(content);
    }
}
