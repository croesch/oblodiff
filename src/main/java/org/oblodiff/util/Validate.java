package org.oblodiff.util;

/**
 * Provides methods to validate inputs.
 *
 * @since 1.0.0
 * @author Sven Strittmatter &lt;weltraumschaf@googlemail.com&gt;
 */
public final class Validate {

    /**
     * Hidden for pure static class.
     */
    private Validate() {
        super();
        throw new UnsupportedOperationException("Must not be caled via reflection!");
    }

    /**
     * Validates that a given reference is not {@code null}.
     *
     * <p>
     * This example validates that {@code input} is not null. If it is {@code null} a
     * {@link java.lang.NullPointerException} will be thrown with the {@code name} as hint in the exception message.:
     * </p>
     * <pre>{@code
     * void someMethod(final Object input) {
     *     final Object validInput = Validate.notNull(input, "input");
     *     // ...
     * }
     * }</pre>
     *
     * <p>
     * The second parameter {@code name} may be omitted. Then a {@link java.lang.NullPointerException} without any
     * message will be thrown. For this purpose you can call the convenience method {@link #notNull(java.lang.Object)}.
     * </p>
     *
     * @param <T> type of reference
     * @param reference validated reference
     * @param name name of validated reference, may be {@code null}
     * @return the reference, if it is valid
     */
    public static <T> T notNull(final T reference, final String name) {
        if (null == reference) {
            if (null == name) {
                throw new NullPointerException();
            } else {
                throw new NullPointerException(String.format("Parameter '%s' must not be null!", name));
            }
        }

        return reference;
    }

    /**
     * Convenience message for {@link #notNull(java.lang.Object, java.lang.String)} with {@code null} as second
     * parameter.
     *
     * @param <T> type of reference
     * @param reference validated reference
     * @return the reference, if it is valid
     */
    public static <T> T notNull(final T reference) {
        return notNull(reference, null);
    }

    /**
     * Validates that a given string reference is not {@code null} or empty.
     *
     * <p>
     * This example validates that {@code input} is not null. If it is {@code null} a
     * {@link java.lang.NullPointerException} will be thrown with the {@code name} as hint in the exception message.
     * Also it validates that {@code input} is not empty by calling {@link java.lang.String#isEmpty()}. If the string is
     * empty an {@link java.lang.IllegalArgumentException} will be thrown:
     * </p>
     * <pre>{@code
     * void someMethod(final String input) {
     *     final Strign validInput = Validate.notEmpty(input, "input");
     *     // ...
     * }
     * }</pre>
     *
     * <p>
     * The second parameter {@code name} may be omitted. Then a {@link java.lang.NullPointerException} or
     * {@link java.lang.IllegalArgumentException} without any message will be thrown. For this purpose you can call the
     * convenience method {@link #notEmpty(java.lang.String)}.
     * </p>
     *
     * @param reference validated reference
     * @param name name of validated reference, may be {@code null}
     * @return the reference, if it is valid
     */
    public static String notEmpty(final String reference, final String name) {
        notNull(reference, name);

        if (reference.isEmpty()) {
            if (null == name) {
                throw new IllegalArgumentException("Parameter must not be empty!");
            } else {
                throw new IllegalArgumentException(String.format("Parameter '%s' must not be empty!", name));
            }
        }

        return reference;
    }

    /**
     * Convenience message for {@link #notEmpty(java.lang.String, java.lang.String)} with {@code null} as second
     * parameter.
     *
     * @param reference validated reference
     * @return the reference, if it is valid
     */
    public static String notEmpty(final String reference) {
        return notEmpty(reference, null);
    }

}
