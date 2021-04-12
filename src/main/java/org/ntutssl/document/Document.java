package org.ntutssl.document;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Document {  
  public default int getLevel() {
    throw new DocumentException("Invalid action: getLevel");
  }
  
  public default void add(Document document) {
    throw new DocumentException("Invalid action: add");
  }
  
  public default Iterator<Document> iterator() {
    throw new NoSuchElementException("Invalid action: Iterator is null");
  }
  
  public default int getSize() {
    throw new DocumentException("Invalid action: getSize");
  }

  public String getText();

  public void accept(Visitor visitor);

  public String toString();
}
