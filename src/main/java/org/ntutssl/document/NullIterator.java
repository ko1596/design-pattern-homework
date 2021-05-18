package org.ntutssl.document;

public class NullIterator implements Iterator<Document> {
  
  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Document next() {
    throw new NoSuchElementException("NoSuchElementException");
  }
}