package org.oblodiff.token.text.linebased;

import org.oblodiff.token.api.Token;
import org.oblodiff.token.text.TextualTokenContainerToken;
import org.oblodiff.token.text.Word;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * A line is a line as in line feed or line break. It is used to split a text into chunks as most other diff algorithms
 * do.
 *
 * @author Christian Rösch &lt;christianroesch@gmx.net&gt;
 */
public class Line extends TextualTokenContainerToken {
  private static final Collection<Character> DELIMITERS = new HashSet<>(Arrays.asList(
      new Character(' '),
      new Character('\t'),
      new Character((char) 0x0b),
      new Character('\f'),
      new Character('.'),
      new Character(','),
      new Character('?'),
      new Character('!'),
      new Character('"'),
      new Character('\''),
      new Character(':'),
      new Character(';')
  ));

  public Line(String s) {
    super(s, DELIMITERS);
  }

  @Override
  protected Token newSubject(String content) {
    return new Word(content);
  }
}
