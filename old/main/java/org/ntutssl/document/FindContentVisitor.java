package org.ntutssl.document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindContentVisitor implements Visitor{  

  private List<Document> documents;
  private String target;

  public FindContentVisitor(String target) {
    this.documents = new ArrayList<>();
    this.target = target.toLowerCase();
  }

  public void visitParagraph(Paragraph paragraph) {
    if(paragraph.getText().toLowerCase().contains(this.target) && (this.target.length()>0 || paragraph.getText().length()==0)){
        this.documents.add(paragraph);
    }
  }

  public void visitTitle(Title title) {
    if(title.getText().toLowerCase().contains(this.target) && (this.target.length()>0 || title.getText().length()==0)){
      this.documents.add(title);
    }
  }

  public void visitArticle(Article article) {
    if(article.getText().toLowerCase().contains(this.target) && (this.target.length()>0 || article.getText().length()==0)){
      this.documents.add(article);
    }

    Iterator<Document> it = article.iterator();
    while(it.hasNext()) it.next().accept(this);
    
  }
  
  public List<Document> getResult() {
    return documents;
  }
}
