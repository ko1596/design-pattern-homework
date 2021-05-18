package org.ntutssl.document;

public class HtmlOutputConsumer implements Consumer<Document> {

  private List<String> result;
  private String string;

  public HtmlOutputConsumer(List<String> result) {
    this.result = result;
    this.string = "";
  }

  public void accept(Document document) {
    if(document.getClass().equals(Title.class)) 
      visitTitle((Title)document);
    if(document.getClass().equals(Paragraph.class)) 
      visitParagraph((Paragraph)document);
    if(document.getClass().equals(Article.class)) 
      visitArticle((Article)document);
   }

  private void visitParagraph(Paragraph paragraph){
    this.result.add("<p>" + paragraph.getText() + "</p>\n");
  }

  private void visitTitle(Title title) {
    this.result.add("<h" + String.valueOf(title.getSize()) + ">" + title.getText() + "</h" + String.valueOf(title.getSize()) + ">\n");
  }
  private void visitArticle(Article article) {
    this.result.add("<article topic='" + article.getText() + "'>\n");

    Iterator<Document> it = article.iterator();
    while(it.hasNext()){
      Document context = it.next();
      for(int i = 0 ;i<article.getLevel();i++) this.string+="  ";
        this.accept(context);
      }
    for(int i = 0 ;i<article.getLevel()-1 ;i++) this.string+="  ";
    
    this.string+="</article>\n";
    this.result.add(this.string);
    this.string="";
  }
}