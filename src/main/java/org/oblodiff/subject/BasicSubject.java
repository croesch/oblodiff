package org.oblodiff.subject;

import org.oblodiff.api.Subject;

/**
 * The basic implementation of a Subject, contains code that all Subjects share.
 *
 * @param <T> the type of the content this subject represents
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class BasicSubject<T extends Object> implements Subject {

    /**
     * the representation of the value/content of this subject.
     */
    private final T content;

    public BasicSubject(final T ct) {
        super();
        content = ct;
    }

    @Override
    public final int hashCode() {
        return content.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (!(obj instanceof BasicSubject)) {
            return false;
        }

        return content.equals(((BasicSubject) obj).content);
    }

    protected T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return super.toString() + " >" + content + "<";
    }
}
