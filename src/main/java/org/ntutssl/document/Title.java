package org.ntutssl.document;

public class Title implements Document {

  private String text;
  private Integer size;

  public Title(String text, int size) {
    this.text = text;
    this.size = size;
  }

  public String getText() {
    return this.text;
  }

  @Override
  public int getSize() {
    return this.getSize();
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitTitle(this);
  }

  @Override
  public String toString() {
    return "Title\t\t" + "text: " + this.getText() + "\n\t\t" + "size: " + this.getSize() + "\n";
  }
}