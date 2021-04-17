package org.ntutssl.document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Article implements Document {
  private String topic;
  private List<Document> allDocumenList = new ArrayList<>();
  private int level;
  public Article(String topic, int level) {
    this.topic = topic;
    this.level = level;
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
      if(document.getLevel() <= this.level){
        throw new DocumentException("Invalid action: add an article with lower level into article");
      }else this.allDocumenList.add(document);
    }else this.allDocumenList.add(document);
    
  }

  @Override
  public Iterator<Document> iterator() {
    return this.allDocumenList.iterator();
  }

  @Override
  public void accept(Visitor<Document> visitor) {
    visitor.visitArticle(this);
  }

  @Override
  public String toString() {
    return "Article\t\t" + "topic: " + this.getText() + "\n\t\t" + "level: " + this.getLevel() + "\n";
  }
}
