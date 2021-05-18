package org.ntutssl.document;

public class Paragraph implements Document {

  private String text;

  public Paragraph(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }

  @Override
  public String toString() {
    String string = "";
    string += "Paragraph\t";
    string += "text: ";
    string += this.text;
    string += "\n";
    return string;
  }
}