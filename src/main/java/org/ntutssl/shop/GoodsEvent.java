package org.ntutssl.shop;


public class GoodsEvent extends Event<Goods> {

  private int count;
  public GoodsEvent(EventType eventType, Goods goods, int count) {
    super(eventType, goods);
    this.count = count;
   }

  @Override
  public int count() {
    return count;
  }
}
