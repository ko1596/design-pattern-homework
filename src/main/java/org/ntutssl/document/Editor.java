package org.ntutssl.document;

public class Editor {

  private List<Document> documentList;

  public Editor() { }

  public void importDocumentFromJsonFile(String filePath) { }

  public void exportDocumentAsHtmlFile(String outputPath) { }

  public void findContent(String target) { }

  public void add(Document document) {
    documentList.add(document);
  }

  public int size() {
    return documentList.size();
   }

  public Iterator<Document> iterator() {
    return documentList.iterator();
   }
}