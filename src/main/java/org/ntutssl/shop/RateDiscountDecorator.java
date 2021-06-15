package org.ntutssl.shop;

public class RateDiscountDecorator extends Decorator {

  /**
   * constructor
   * @param goods goods to be decorated
   * @param rate discount rate, which should be [0, 1)
   */

  private double rate;

  public RateDiscountDecorator(Goods goods, double rate) {
    super(goods);
    if(rate<0 || rate>=1) throw new ShopException("Discount rate, which should be [0, 1)");
    this.rate = rate;
   }

  public int id() {
    return goods.id();
  }

  public double price() {
    return goods.price()*rate;
  }

  public String name() {
    return goods.name();
  }

  public String description() {
    return goods.description();
  }
}
