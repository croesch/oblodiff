package org.oblodiff.token;

import org.oblodiff.token.api.Token;

/**
 * The basic implementation of a {@link Token}, contains code that all {@link Token}s share.
 *
 * @since 1.0.0
 * @param <T> the type of the content this token represents
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class BasicToken<T> implements Token {

    /**
     * the representation of the value/content of this token.
     */
    private final T content;

    /**
     * @param ct the content this token represents.
     * @see #getContent() for further details
     */
    public BasicToken(final T ct) {
        super();
        content = ct;
    }

    @Override
    public final int hashCode() {
        return content.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        return obj instanceof BasicToken && content.equals(((BasicToken) obj).content);
    }

    /**
     * @return the content of this token. The content is used for generating the hash of this token.
     */
    protected T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return super.toString() + " >" + content + "<";
    }
}
