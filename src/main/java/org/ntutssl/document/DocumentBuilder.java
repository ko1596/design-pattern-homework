package org.ntutssl.document;

/**
 * Document builder helps you build a Document object.
 * 
 * Please note that the return value of each build procedure is 
 * DocumentBuilder itself, so you can build a large object using
 * a single statement.
 */
class DocumentBuilder {

  public DocumentBuilder() { }

  public DocumentBuilder buildTitle(String text, int size) { }

  public DocumentBuilder buildParagraph(String text) { }

  public DocumentBuilder startBuildArticle(String topic, int level) { }

  public DocumentBuilder endBuildArticle() { }

  public Document getResult() { }
}