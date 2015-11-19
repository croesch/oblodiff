package org.oblodiff.subject.text.simple;

import org.oblodiff.subject.text.linebased.Line;
import org.oblodiff.subject.text.Character;
import org.oblodiff.subject.text.linebased.Document;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Test_Document_getChildren {
  @Test
  public void should_Be_Empty_If_Document_Is_Empty() {
    assertThat(new org.oblodiff.subject.text.linebased.Document("").getChildren()).isEmpty();
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_CarriageReturn() {
    assertThat(new org.oblodiff.subject.text.linebased.Document("\r").getChildren()).containsExactly(new Character('\r'));
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_LineFeed() {
    assertThat(new org.oblodiff.subject.text.linebased.Document("\n").getChildren()).containsExactly(new Character('\n'));
  }

  @Test
  public void should_Return_One_Child_If_Consists_Of_One_Line() {
    assertThat(new org.oblodiff.subject.text.linebased.Document("super").getChildren()).containsExactly(new Line("super"));
  }

  @Test
  public void should_Add_NewLine_As_Character() {
    assertThat(new org.oblodiff.subject.text.linebased.Document("super\n").getChildren()).containsExactly(new Line("super"), new Character('\n'));
  }

  @Test
  public void should_Add_CarriageReturn_As_Character() {
    assertThat(new org.oblodiff.subject.text.linebased.Document("super\r").getChildren()).containsExactly(new Line("super"), new Character('\r'));
  }

  @Test
  public void should_Add_CarriageReturn_LineFeed_As_Characters() {
    assertThat(new Document("one\r\nis").getChildren()).containsExactly(new Line("one"), new Character('\r'), new
        Character('\n'), new Line("is"));
  }
}
