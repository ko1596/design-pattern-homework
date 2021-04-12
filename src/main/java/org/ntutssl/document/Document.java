package org.ntutssl.document;

public interface Document {  
  public default int getLevel() {
    
  }
  
  public default void add(Document document) {
    
  }
  
  public default Iterator<Document> iterator() {
    
  }
  
  public default int getSize() {
    
  }

  public String getText();

  public void accept(Visitor visitor);

  public String toString();
}
