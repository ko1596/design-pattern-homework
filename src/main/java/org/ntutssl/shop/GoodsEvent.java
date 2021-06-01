package org.ntutssl.shop;

import java.util.concurrent.CountDownLatch;

public class GoodsEvent extends Event<Goods> {

  private int count;
  public GoodsEvent(EventType eventType, Goods goods, int count) {
    this.count = count;
   }

  @Override
  public int count() {
    return count;
  }
}
