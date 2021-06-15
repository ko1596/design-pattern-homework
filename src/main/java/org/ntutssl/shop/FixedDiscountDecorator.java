package org.ntutssl.shop;

public class FixedDiscountDecorator extends Decorator {

  /**
   * counstructor
   * @param goods goods to be decorated
   * @param discount fixed discount, which should be lower than the price of goods
   */
  private double discount;
  
  public FixedDiscountDecorator(Goods goods, double discount) {
    super(goods);
    if(discount>this.goods.price()) throw new ShopException("Discount which should be lower than the price of goods");
    this.discount = discount;
  }

  public int id() {
    return goods.id();
  }

  public double price() {
    return goods.price()-discount;
  }

  public String name() {
    return goods.name();
  }

  public String description() {
    return goods.description();
  }
}
