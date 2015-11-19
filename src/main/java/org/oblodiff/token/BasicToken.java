package org.oblodiff.token;

import org.oblodiff.token.api.Token;

/**
 * The basic implementation of a {@link Token}, contains code that all {@link Token}s share.
 *
 * @param <T> the type of the content this token represents
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class BasicToken<T extends Object> implements Token {

    /**
     * the representation of the value/content of this token.
     */
    private final T content;

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
        if (!(obj instanceof BasicToken)) {
            return false;
        }

        return content.equals(((BasicToken) obj).content);
    }

    protected T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return super.toString() + " >" + content + "<";
    }
}
