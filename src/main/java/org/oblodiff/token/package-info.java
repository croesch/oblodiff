/**
 * Describes the different tokens available for diffing.
 * <p>
 * A token (at the top level) can be considered as a mode of
 * the diff. Each token consists of many tokens itself. These child tokens are also tokens and therefore consist
 * of child tokens, too. So the classes in this package define:
 * </p>
 * <ul>
 * <li>which tokens are available</li>
 * <li>how these tokens are split up</li>
 * <li>how the identity of a token is defined</li>
 * </ul>
 */
package org.oblodiff.token;
