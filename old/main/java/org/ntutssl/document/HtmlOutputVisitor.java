package org.ntutssl.document;

import java.util.Iterator;

public class HtmlOutputVisitor implements Visitor{
  private String result;
  private int countArticle;

  public HtmlOutputVisitor() {
    this.result = "";
  }

  public void visitParagraph(Paragraph paragraph) {
    result += "<p>" + paragraph.getText() + "</p>\n";
  }

  public void visitTitle(Title title) {
    result += "<h" + title.getSize()  +">"+ title.getText() + "</h" + title.getSize() +">\n";
  }

  public void visitArticle(Article article) {
    
    countArticle++;
    result += "<article topic='" + article.getText() + "'>\n";
    Iterator<Document> it = article.iterator();
    while(it.hasNext()){
      for(int i = 0; i<countArticle; i++) result += "  ";
      it.next().accept(this);
    }
    countArticle--;

    for(int i = 0; i<countArticle; i++) result += "  ";
    result += "</article>\n";
  }

  public String getResult() {
    return this.result;
  }
}
