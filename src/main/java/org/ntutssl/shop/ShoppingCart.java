package org.ntutssl.shop;

import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart implements EventListener {

  public ShoppingCart() { }

  public void onEvent(Event event) { }

  /**
   * add goods to shopping cart
   * @param goodsEvent the data of this event is the goods to be added
   */
  private void add(Event<Goods> event) { }

  /**
   * pay for all items in the shopping cart
   */
  private void pay() { }

  /**
   * print receipt and publish PURCHASE
   */
  private void printReceipt(Event<String> event) { }

  /**
   * list all items in the shopping cart
   */
  private void listCart() { }
}
