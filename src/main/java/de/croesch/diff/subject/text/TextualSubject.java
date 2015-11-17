package de.croesch.diff.subject.text;

import de.croesch.diff.subject.BasicSubject;

/**
 * A textual subject is a subject representing a text.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public abstract class TextualSubject<CT extends Object> extends BasicSubject<CT> {

    public TextualSubject(CT ct) {
        super(ct);
    }
}
