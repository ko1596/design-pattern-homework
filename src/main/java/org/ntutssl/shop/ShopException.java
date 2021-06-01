package org.ntutssl.shop;

public class ShopException extends RuntimeException {
  static final long serialVersionUID = 1L;

  public ShopException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }

  public ShopException (String errorMessage) {
    super(errorMessage);
  }
}
