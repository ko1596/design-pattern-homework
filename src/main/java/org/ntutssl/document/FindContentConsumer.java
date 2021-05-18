package org.ntutssl.document;

public class FindContentConsumer implements Consumer<Document> {
  
  /**
   * @param result you should add the document which contains `target` into here.
   */
  public FindContentConsumer(List<Document> result, String target) { }

  public void accept(Document document) { }
}