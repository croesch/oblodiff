package org.oblodiff.util;

/**
 * Defines a collection of delimiter characters.
 *
 * @since 1.0.0
 * @author Sven Strittmatter &lt;weltraumschaf@googlemail.com&gt;
 */
public interface Delimiters {

    /**
     * Constant for a carriage return.
     */
    Character CARRIAGE_RETURN = '\r';
    /**
     * Constant for a line feed.
     */
    Character LINE_FEED = '\n';
    /**
     * Constant for a single white space.
     */
    Character SPACE = ' ';
    /**
     * Constant for a tabulator.
     */
    Character TABULATOR = '\t';
    /**
     * Constant for a vertical tabulator.
     */
    Character VERTICAL_TABULATOR = (char) 0x0b;
    /**
     * Constant for a form feed.
     */
    Character FORM_FEED = '\f';
    /**
     * Constant for a period.
     */
    Character PERIOD = '.';
    /**
     * Constant for a comma.
     */
    Character COMMA = ',';
    /**
     * Constant for a question mark.
     */
    Character QUESTION_MARK = '?';
    /**
     * Constant for a exclamation mark.
     */
    Character EXCLAMATION_MARK = '!';
    /**
     * Constant for a double quote.
     */
    Character DOUBLE_QUOTE = '"';
    /**
     * Constant for a single quote.
     */
    Character SINGLE_QUOTE = '\'';
    /**
     * Constant for a colon.
     */
    Character COLON = ':';
    /**
     * Constant for a semicolon.
     */
    Character SEMICOLON = ';';
}
