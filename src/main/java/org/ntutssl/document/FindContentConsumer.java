package org.ntutssl.document;

public class FindContentConsumer implements Consumer<Document> {
  
  /**
   * @param result you should add the document which contains `target` into here.
   */

  private List<Document> result;
  private String target;

  public FindContentConsumer(List<Document> result, String target) {
    this.result = result;
    this.target = target.toLowerCase();
   }

   public void accept(Document document){
    if(document.getClass().equals(Title.class)) 
      visitTitle((Title)document);
    if(document.getClass().equals(Paragraph.class)) 
      visitParagraph((Paragraph)document);
    if(document.getClass().equals(Article.class)) 
      visitArticle((Article)document);
  }

  private void visitParagraph(Paragraph paragraph) {
    if(paragraph.getText().toLowerCase().contains(this.target) && (this.target.length() > 0 || paragraph.getText().length() == 0)) {
      this.result.add(paragraph);
    }
  }

  private void visitTitle(Title title) {
    if(title.getText().toLowerCase().contains(this.target) && (this.target.length() > 0 || title.getText().length() == 0)) {
      this.result.add(title);
    }
  }

  private void visitArticle(Article article) {
    if(article.getText().toLowerCase().contains(this.target) && (this.target.length() > 0 || article.getText().length() == 0)) {
      this.result.add(article);
    }

    Iterator<Document> it = article.iterator();
    while(it.hasNext())
      this.accept(it.next());
  }
}