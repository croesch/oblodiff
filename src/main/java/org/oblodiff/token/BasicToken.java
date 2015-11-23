package org.oblodiff.token;

import org.oblodiff.token.api.Token;
import org.oblodiff.util.Validate;

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
     * Dedicated constructor.
     *
     * @param content must not be {@code null}
     * @see #getContent() for further details
     */
    public BasicToken(final T content) {
        super();
        this.content = Validate.notNull(content, "content");
    }

    @Override
    public final int hashCode() {
        return getContent().hashCode();
    }

    @Override
    public final boolean equals(final Object obj) {
        return obj instanceof BasicToken && getContent().equals(((BasicToken) obj).getContent());
    }

    /**
     * Return the content of this token.
     * <p>
     * The content is used for generating the hash of this token.
     * </p>
     *
     * XXX Should this be part of Token interface?
     *
     * @return never {@code null}
     */
    protected final T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "BasicToken{"
            + "content=" + content
            + '}';
    }

}
