package org.ntutssl.document;

public class Title implements Document {

  private String text;
  private int size;

  public Title(String text, int size) {
    if(size < 1 || size > 6) throw new DocumentException("Invalid Input: Must be between 0~6");
    this.text = text;
    this.size = size;
  }

  public String getText() {
    return this.text;
  }

  @Override
  public int getSize() {
    return this.size;
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