package org.oblodiff.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link Validate}.
 *
 * @author Sven Strittmatter &lt;weltraumschaf@googlemail.com&gt;
 */
public class ValidateTest {

    @Rule
    //CHECKSTYLE:OFF
    public final ExpectedException thrown = ExpectedException.none();
    //CHECKSTYLE:ON

    @Test
    public void invokeConstructorByReflectionThrowsException() throws Exception {
        assertThat(Validate.class.getDeclaredConstructors().length, is(1));

        final Constructor<Validate> ctor = Validate.class.getDeclaredConstructor();
        ctor.setAccessible(true);

        thrown.expect(either(instanceOf(UnsupportedOperationException.class))
                .or(instanceOf(InvocationTargetException.class)));
        ctor.newInstance();
    }

    @Test
    public void notNull_nullReferenceThrowsException_nullName() {
        thrown.expect(NullPointerException.class);
        Validate.notNull(null, null);
    }

    @Test
    public void notNull_nullReferenceThrowsException_notNullName() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Parameter 'foo' must not be null!");
        Validate.notNull(null, "foo");
    }

    @Test
    public void notNull_nullReferenceThrowsException() {
        thrown.expect(NullPointerException.class);
        Validate.notNull(null);
    }

    @Test
    public void notNull_notNullReferenceReturnsIt() {
        final Object o = new Object();
        assertThat(Validate.notNull(o), is(sameInstance(o)));
        assertThat(Validate.notNull(o, null), is(sameInstance(o)));
    }

    @Test
    public void notEmpty_nullReferenceThrowsException_nullName() {
        thrown.expect(NullPointerException.class);
        Validate.notEmpty(null, null);
    }

    @Test
    public void notEmpty_emptyReferenceThrowsException_nullName() {
        thrown.expect(IllegalArgumentException.class);
        Validate.notEmpty("", null);
    }

    @Test
    public void notEmpty_nullReferenceThrowsException_notNullName() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Parameter 'foo' must not be null!");
        Validate.notEmpty(null, "foo");
    }

    @Test
    public void notEmpty_emptyReferenceThrowsException_notNullName() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Parameter 'foo' must not be empty!");
        Validate.notEmpty("", "foo");
    }

    @Test
    public void notEmpty_nullReferenceThrowsException() {
        thrown.expect(NullPointerException.class);
        Validate.notEmpty(null);
    }

    @Test
    public void notEmpty_emptyReferenceThrowsException() {
        thrown.expect(IllegalArgumentException.class);
        Validate.notEmpty("");
    }

    @Test
    public void notEmpty_notEmptyReferenceReturnsIt() {
        final String str = "foobar";
        assertThat(Validate.notEmpty(str), is(sameInstance(str)));
        assertThat(Validate.notEmpty(str, null), is(sameInstance(str)));
    }

}
