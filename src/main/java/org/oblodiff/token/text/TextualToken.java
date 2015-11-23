package org.oblodiff.token.text;

import org.oblodiff.token.BasicToken;

/**
 * A textual token is a token representing a text.
 *
 * XXX For what is this class good? It does not add any behavior/property to BasicToken.
 * @since 1.0.0
 * @param <T> the type of the content this token represents
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class TextualToken<T> extends BasicToken<T> {

    /**
     * Dedicated constructor.
     *
     * @param content must not be {@code null}
     */
    public TextualToken(final T content) {
        super(content);
    }
}
