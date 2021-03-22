package org.ntutssl.document;

public class Article implements Document {  
  public Article(String topic, int level) {  }

  public Document getContent(int index) {  }

  public String getText() {  }

  @Override
  public int getLevel() {  }
  
  @Override
  public void add(Document document) {  }
}
