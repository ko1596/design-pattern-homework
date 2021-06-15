package org.ntutssl.shop;

import java.util.Map;
import java.util.HashMap;

public class Shop implements EventListener {

  public Shop() { }  

  public void onEvent(Event event) { }

  /**
   * replenish stock
   * @param event Event of Goods to replenish
   */
  private void replenish(Event<Goods> event) { }

  /**
   * check if the specific goods is in stock, if so, publish an 
   * event ADD_TO_CART
   * @param event Event of Goods to check
   */
  private void checkStock(Event<Goods> event) { }

  /**
   * deduct stock after user complete purchase
   * @param event Event of Goods to be deducted
   */
  private void purchase(Event<Goods> event) { }

  /**
   * show stocks of this shop
   */
  private void listShop() { }
}
