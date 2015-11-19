package org.oblodiff.token.text.simple;

import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualTokenContainerToken;
import org.oblodiff.token.text.Word;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * A sentence is a couple of words. It is used to split a text into logical chunks.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Sentence extends TextualTokenContainerToken {

    private static final Collection<Character> DELIMITERS = new HashSet<>(Arrays.asList(
        ' ',
        '\r',
        '\n',
        '\t',
        (char) 0x0b,
        '\f',
        '.',
        ',',
        '?',
        '!',
        '"',
        '\'',
        ':',
        ';'
    ));

    public Sentence(String s) {
        super(s, DELIMITERS);
    }

    @Override
    protected Token newToken(String content) {
        return new Word(content);
    }
}
