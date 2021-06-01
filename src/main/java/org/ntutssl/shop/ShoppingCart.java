package org.ntutssl.shop;

import java.util.Map;

public class ShoppingCart implements EventListener {
  
  private Map<Goods, Integer> shopppingCart;
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
  private void add(Event<Goods> event) {
    if(shopppingCart.containsKey(event.data())) 
      shopppingCart.put(event.data(), shopppingCart.get(event.data())+event.count());
    else
      shopppingCart.put(event.data(), shopppingCart.get(event.data()));
  }

  /**
   * pay for all items in the shopping cart
   */
  private void pay() { 
    for(Goods goods : shopppingCart.keySet()){
      System.out.print(String.format("%-4s%-22s%-40s%-8s%-6s\n", goods.id(), goods.name(), goods.description()));
    }
  }

  /**
   * list all items in the shopping cart
   */
  private void listCart() {
    if(shopppingCart.isEmpty())
      System.out.print("Your shopping cart is empty.\n");
    else{
      System.out.print(String.format("%-4s%-22s%-40s%-8s%-6s\n", "ID", "name", "description", "price", "count"));
      for(Goods goods : shopppingCart.keySet()){
        System.out.print(String.format("%-4s%-22s%-40s%-8s%-6s\n", goods.id(), goods.name(), goods.description()));
      }
    }
   }
}
