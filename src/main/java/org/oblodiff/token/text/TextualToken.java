package org.oblodiff.token.text;

import org.oblodiff.token.BasicToken;

/**
 * A textual token is a token representing a text.
 *
 * @param <T> the type of the content this token represents
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class TextualToken<T> extends BasicToken<T> {

    public TextualToken(T ct) {
        super(ct);
    }
}
