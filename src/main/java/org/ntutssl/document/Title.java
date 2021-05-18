package org.ntutssl.document;

public class Title implements Document {

  private String text;
  private int size;

  public Title(String text, int size) {
    this.text = text;
    this.size = size;
   }

   public String getText() {
    return this.text;
  }

  public int getSize() {
    return this.size;
  }

  @Override
  public String toString() {
    String string = "";
    string += "Title\t\t";
    string += "text: ";
    string += this.text;
    string += "\n";
    string += "\t\tsize: ";
    string += this.size;
    string += "\n";
    return string;

  }
}