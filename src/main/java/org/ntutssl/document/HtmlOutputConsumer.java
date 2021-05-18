package org.ntutssl.document;

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
  public HtmlOutputConsumer(List<String> result) { }

  public void accept(Document document) { }
}