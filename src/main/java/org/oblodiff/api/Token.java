package org.oblodiff.api;

import java.util.List;

/**
 * A token is a part of the diff that can be uniquely identified and that might be split up into smaller tokens.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public interface Token {

    /**
     * Returns the child tokens. These children built this token.
     *
     * @return a {@link java.util.List} of {@link Token}s that might be empty but never {@code null}.
     */
    List<Token> getChildren();
}
