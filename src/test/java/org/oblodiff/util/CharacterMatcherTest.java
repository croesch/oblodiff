package org.oblodiff.util;

import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for {@link CharacterMatcher}.
 */
public class CharacterMatcherTest {

    @Test
    public void isLineFeed_null() {
        assertThat(CharacterMatcher.isLineFeed(null), is(false));
    }

    @Test
    public void isLineFeed_space() {
        assertThat(CharacterMatcher.isLineFeed(' '), is(false));
    }

    @Test
    public void isLineFeed_someChars() {
        assertThat(CharacterMatcher.isLineFeed('a'), is(false));
        assertThat(CharacterMatcher.isLineFeed('F'), is(false));
        assertThat(CharacterMatcher.isLineFeed('X'), is(false));
        assertThat(CharacterMatcher.isLineFeed('?'), is(false));
        assertThat(CharacterMatcher.isLineFeed(';'), is(false));
    }

    @Test
    public void isLineFeed_cr() {
        assertThat(CharacterMatcher.isLineFeed('\r'), is(false));
    }

    @Test
    public void isLineFeed_lf() {
        assertThat(CharacterMatcher.isLineFeed('\n'), is(true));
    }

    @Test
    public void isCariageReturn_null() {
        assertThat(CharacterMatcher.isCariageReturn(null), is(false));
    }

    @Test
    public void isCariageReturn_space() {
        assertThat(CharacterMatcher.isCariageReturn(' '), is(false));
    }

    @Test
    public void isCariageReturn_someChars() {
        assertThat(CharacterMatcher.isCariageReturn('a'), is(false));
        assertThat(CharacterMatcher.isCariageReturn('F'), is(false));
        assertThat(CharacterMatcher.isCariageReturn('X'), is(false));
        assertThat(CharacterMatcher.isCariageReturn('?'), is(false));
        assertThat(CharacterMatcher.isCariageReturn(';'), is(false));
    }

    @Test
    public void isCariageReturn_cr() {
        assertThat(CharacterMatcher.isCariageReturn('\r'), is(true));
    }

    @Test
    public void isCariageReturn_lf() {
        assertThat(CharacterMatcher.isCariageReturn('\n'), is(false));
    }

    @Test
    public void isWhiteSpace_null() {
        assertThat(CharacterMatcher.isWhiteSpace(null), is(false));
    }

    @Test
    public void isWhiteSpace_spaces() {
        assertThat(CharacterMatcher.isWhiteSpace(' '), is(true));
        assertThat(CharacterMatcher.isWhiteSpace('\t'), is(true));
    }

    @Test
    public void isWhiteSpace_nonSpaces() {
        assertThat(CharacterMatcher.isWhiteSpace('.'), is(false));
        assertThat(CharacterMatcher.isWhiteSpace('a'), is(false));
        assertThat(CharacterMatcher.isWhiteSpace('Z'), is(false));
        assertThat(CharacterMatcher.isWhiteSpace('9'), is(false));
    }

    @Test
    public void isNonWhiteSpace_null() {
        assertThat(CharacterMatcher.isNonWhiteSpace(null), is(false));
    }

    @Test
    public void isNonWhiteSpace_spaces() {
        assertThat(CharacterMatcher.isNonWhiteSpace(' '), is(false));
        assertThat(CharacterMatcher.isNonWhiteSpace('\t'), is(false));
    }

    @Test
    public void isNonWhiteSpace_nonSpaces() {
        assertThat(CharacterMatcher.isNonWhiteSpace('.'), is(true));
        assertThat(CharacterMatcher.isNonWhiteSpace('a'), is(true));
        assertThat(CharacterMatcher.isNonWhiteSpace('Z'), is(true));
        assertThat(CharacterMatcher.isNonWhiteSpace('9'), is(true));
    }
}
