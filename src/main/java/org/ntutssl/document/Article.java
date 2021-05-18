package org.ntutssl.document;

public class Article implements Document {
  
  private String topic;
  private int level;
  private List<Document> contentList;

  public Article(String topic, int level) {
    this.topic = topic;
    this.level = level;
    this.contentList = new ArrayList<>();
   }

  public String getText() {
    return this.topic;
   }

  @Override
  public int getLevel() {
    return this.level;
   }
  
  @Override
  public void add(Document document) {
    try{
      int addLevel = document.getLevel();
      if(addLevel > this.level) this.contentList.add(document);
      else throw new DocumentException("Invalid Input");
    }catch(DocumentException e){
      if(e.getMessage().equals("getLevel function is not found"))
        this.contentList.add(document);
      else throw e;
    }
   }

  @Override
  public Iterator<Document> iterator() {
    return this.contentList.iterator();
   }

  @Override
  public String toString() {
    return "Article\t\ttopic: " + this.topic + "\n\t\tlevel: "+ this.level + "\n";
   }
}