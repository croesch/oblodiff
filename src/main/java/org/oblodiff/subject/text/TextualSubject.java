package org.oblodiff.subject.text;

import org.oblodiff.subject.BasicSubject;

/**
 * A textual subject is a subject representing a text.
 *
 * @param <T> the type of the content this subject represents
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class TextualSubject<T extends Object> extends BasicSubject<T> {

    public TextualSubject(T ct) {
        super(ct);
    }
}
