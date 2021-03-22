package org.ntutssl.document;

public class DocumentException extends RuntimeException {
  static final long serialVersionUID = 1L;

  public DocumentException(String errorMessage) {
    super(errorMessage);
  }
}
