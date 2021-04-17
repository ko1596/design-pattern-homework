package org.ntutssl.document;

public interface Visitor<T> { // you don't need to modify this interface
  public void visitParagraph(Paragraph paragraph);
  public void visitTitle(Title title);
  public void visitArticle(Article article);
  public T getResult();
}
