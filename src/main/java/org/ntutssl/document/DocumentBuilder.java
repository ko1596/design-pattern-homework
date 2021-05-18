package org.ntutssl.document;

/**
 * Document builder helps you build a Document object.
 * 
 * Please note that the return value of each build procedure is 
 * DocumentBuilder itself, so you can build a large object using
 * a single statement.
 */
class DocumentBuilder {

  private Stack<Document> stack;
  private Document document;

  public DocumentBuilder() {
    this.document = null;
    this.stack = new Stack();
   }

   public DocumentBuilder buildTitle(String text, int size) {
    if(this.stack.empty()) document= new Title(text,size);
    else this.stack.peek().add(new Title(text,size));
    return this;
  }

  public DocumentBuilder buildParagraph(String text){
    if(this.stack.empty()) document=new Paragraph(text);
    else this.stack.peek().add(new Paragraph(text));
    return this;
  }

  public DocumentBuilder startBuildArticle(String topic, int level){
    this.stack.push(new Article(topic,level));
    return this;
  }

  public DocumentBuilder endBuildArticle(){
    if(this.stack.size() == 1)  document =this.stack.pop();
    else {
      Document temp = stack.pop();
      this.stack.peek().add(temp);
    }
    return this;
  }

  public Document getResult(){
    return document;
  }
}