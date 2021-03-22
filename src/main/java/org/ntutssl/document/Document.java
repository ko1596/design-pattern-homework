package org.ntutssl.document;

public interface Document {
    default Document getContent(int index){
        throw new DocumentException("Invalid action: getContent");
    };

    String getText();

    default int getLevel(){
        throw new DocumentException("Invalid action: getLevel");
    };
  
    default void add(Document document){
        throw new DocumentException("Invalid action: add");
    };
  }
