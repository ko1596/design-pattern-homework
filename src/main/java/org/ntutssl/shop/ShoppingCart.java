package org.ntutssl.shop;

public class ShoppingCart implements EventListener {
  
  public ShoppingCart() { }

  public void onEvent(Event event) {
    if(event.type() == EventType.ADD_TO_CART)
      add(event);
    else if(event.type() == EventType.PAY)
      pay();
    else if(event.type() == EventType.LIST_CART)
      listCart();
  }

  /**
   * private methods are not necessary, but you can takce them as reference.
   */
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
   * list all items in the shopping cart
   */
  private void listCart() { }
}
