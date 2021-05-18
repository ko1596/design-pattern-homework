package org.ntutssl.document;

import java.util.List;
import java.util.function.Consumer;
import java.util.Iterator;

public class HtmlOutputConsumer implements Consumer<Document> {

  /**
   * @param result you should add the result into here.
   * 
   * example:
   * this.result.get(0) = "<article topic='topic1'>\n";
   * this.result.get(1) = "  <h1>title1</h1>\n";
   * this.result.get(2) = "  <p>paragraph1</p>\n";
   * this.result.get(3) = "  <h2>title2</h2>\n";
   * this.result.get(4) = "</article>\n";
   */

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
    this.string+="<p>";
    this.string+=paragraph.getText();
    this.string+="</p>";
    this.string+="\n";
    this.result.add(this.string);
    this.string="";
  }

  private void visitTitle(Title title) {
    this.string+="<h"+String.valueOf(title.getSize())+">";
    this.string+=title.getText();
    this.string+="</h"+String.valueOf(title.getSize())+">";
    this.string+="\n";
    this.result.add(this.string);
    this.string="";
  }
  private void visitArticle(Article article) {
    this.string+="<article topic='";
    this.string+=article.getText();
    this.string+="'>";
    this.string+="\n";
    this.result.add(string);
    this.string="";
    Iterator<Document> it = article.iterator();
    while(it.hasNext()){
      Document context = it.next();
      for(int i = 0 ;i<article.getLevel();i++) this.string+="  ";
        this.accept(context);
      }
    for(int i = 0 ;i<article.getLevel()-1 ;i++) this.string+="  ";
    this.string+="</article>";
    this.string+="\n";
    this.result.add(this.string);
    this.string="";
  }
}