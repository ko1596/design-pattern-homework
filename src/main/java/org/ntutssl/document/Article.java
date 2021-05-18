package org.ntutssl.document;

public class Article implements Document {
  
  public Article(String topic, int level) { }

  public String getText() { }

  @Override
  public int getLevel() { }
  
  @Override
  public void add(Document document) { }

  @Override
  public Iterator<Document> iterator() { }

  @Override
  public String toString() { }
}