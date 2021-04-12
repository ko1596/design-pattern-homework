package org.ntutssl.document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindContentVisitor {  

  private List<Document> documents;
  private String target;

  public FindContentVisitor(String target) {
    this.documents = new ArrayList<>();
    this.target = target.toLowerCase();
  }

  public void visitParagraph(Paragraph paragraph) {
    
  }

  public void visitTitle(Title title) {
    
  }

  public void visitArticle(Article article) {
    
  }
  
  public List<Document> getResult() {
    return documents;
  }
}
