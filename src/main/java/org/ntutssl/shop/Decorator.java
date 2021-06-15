package org.ntutssl.shop;

public abstract class Decorator implements Goods {
  protected Goods goods;

  /**
   * constructor
   * @param goods goods to be decorated
   */
  public Decorator(Goods goods) {
    this.goods = goods;
  }
}
