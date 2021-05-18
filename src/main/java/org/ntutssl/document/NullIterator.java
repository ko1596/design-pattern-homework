package org.ntutssl.document;

public class NullIterator implements Iterator<Document> {
  
  @Override
  public boolean hasNext() { }

  @Override
  public Document next() { }
}