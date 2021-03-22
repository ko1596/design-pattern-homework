package org.ntutssl.document;

public class Title implements Document {
  private String text;
  public Title(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}