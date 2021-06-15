package org.ntutssl.shop;

public class RateDiscountDecorator extends Decorator {

  /**
   * constructor
   * @param goods goods to be decorated
   * @param rate discount rate, which should be [0, 1)
   */
  public RateDiscountDecorator(Goods goods, double rate) { }

  public int id() { }

  public double price() { }

  public String name() { }

  public String description() { }
}
