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

  public void accept(Document document) { }
}