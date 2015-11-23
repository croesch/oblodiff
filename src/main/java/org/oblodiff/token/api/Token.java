package org.oblodiff.token.api;

import java.util.List;

/**
 * A token is a part of the diff that can be uniquely identified and that might be split up into smaller tokens.
 *
 * @since 1.0.0
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public interface Token {

    /**
     * Constant for carriage return.
     */
    Character CARRIAGE_RETURN = '\r';
    /**
     * Constant for line feed.
     */
    Character LINE_FEED = '\n';

    /**
     * Returns the child tokens.
     *
     * <p>
     * These children built this token. Returns an empty list if and only if this token cannot be split into smaller
     * tokens.
     * </p>
     *
     * XXX Maybe this method should return an upper bound wildcard?
     *
     * @return might be empty but never {@code null}, unmodifiable
     */
    List<Token> getChildren();
}
