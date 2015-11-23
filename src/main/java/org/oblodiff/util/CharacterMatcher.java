package org.oblodiff.util;

/**
 * Provides methods to match characters.
 *
 * @since 1.0.0
 * @author Sven Strittmatter &lt;weltraumschaf@googlemail.com&gt;
 */
public final class CharacterMatcher {

    /**
     * Matches for single non white space character.
     */
    private static final String NON_WHITE_SPACE_REGEX = "\\S";
    /**
     * Matches for single white space character.
     */
    private static final String WHITE_SPACE_REGEX = "\\s";

    /**
     * Hidden for pure static class.
     */
    private CharacterMatcher() {
        super();
        throw new UnsupportedOperationException("Must not be caled via reflection!");
    }

    /**
     * Tests if given character is a {@link Delimiters#LINE_FEED line feed}.
     *
     * @param ch may be {@code null}
     * @return {@code true} if LF is given, else {@code false}
     */
    public static boolean isLineFeed(final Character ch) {
        if (null == ch) {
            return false;
        }

        return Delimiters.LINE_FEED.equals(ch);
    }

    /**
     * Tests if given character is a {@link Delimiters#CARRIAGE_RETURN carriage return}.
     *
     * @param ch may be {@code null}
     * @return {@code true} if CR is given, else {@code false}
     */
    public static boolean isCariageReturn(final Character ch) {
        if (null == ch) {
            return false;
        }

        return Delimiters.CARRIAGE_RETURN.equals(ch);
    }

    /**
     * Tests if given character is a white space.
     *
     * @param ch may be {@code null}
     * @return {@code true} if white space is given, else {@code false}
     */
    public static boolean isWhiteSpace(final Character ch) {
        if (null == ch) {
            return false;
        }

        return String.valueOf(ch.charValue()).matches(WHITE_SPACE_REGEX);
    }

    /**
     * Tests if given character is not a white space.
     *
     * @param ch may be {@code null}
     * @return {@code true} if not white space is given, else {@code false}
     */
    public static boolean isNonWhiteSpace(final Character ch) {
        if (null == ch) {
            return false;
        }

        return String.valueOf(ch.charValue()).matches(NON_WHITE_SPACE_REGEX);
    }
}
