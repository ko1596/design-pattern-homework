package org.ntutssl.document;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Document {
  public default int getLevel() {
    throw new DocumentException("getLevel function is not found");
  }
  
  public default void add(Document document) {
    throw new DocumentException("add function is not found");
  }
  
  public default Iterator<Document> iterator() {
    throw new NoSuchElementException("NoSuchElementException");
  }
  
  public default int getSize() {
    throw new DocumentException("getSize function is not found");
  }

  public default void remove(Document document) {
    throw new DocumentException("remove function is not found");
  }
  
  public String getText();

  public String toString();
}