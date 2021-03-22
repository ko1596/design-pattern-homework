package org.ntutssl.document;

public class Article implements Document {  
  public Article(String topic, int level) {  }

  public Document getContent(int index) {
    String text = "asd";
    Document a = new Title(text);
    return a;
  }

  public String getText() {
    String text = "asd";
    return text;
  }

  @Override
  public int getLevel() { 
    return 123;
   }
  
  @Override
  public void add(Document document) {  }
}
