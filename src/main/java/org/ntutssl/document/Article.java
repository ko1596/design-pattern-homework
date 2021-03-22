package org.ntutssl.document;

import java.util.ArrayList;
import java.util.List;

public class Article implements Document {  
  private String topic;
  private List<Document> allDocumenList = new ArrayList<>();
  private int level;
  public Article(String topic, int level) {
    this.topic = topic;
    this.level = level;
  }

  public Document getContent(int index) {
    return allDocumenList.get(index);
  }

  public String getText() {
    return topic;
  }

  @Override
  public int getLevel() { 
    return level;
   }
  
  @Override
  public void add(Document document) {
    if(document.getClass() == Article.class){
      if(document.getLevel() < this.level){
        throw new DocumentException("Invalid action: add an article with lower level into article");
      }else this.allDocumenList.add(document);
    }else this.allDocumenList.add(document);
    
  }
}
