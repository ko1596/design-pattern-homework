package org.ntutssl.shop;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements EventListener {
  
  private Map<Goods, Integer> shopppingCart;
  private String buffer;
  public ShoppingCart() {
    this.shopppingCart = new HashMap<>();
    EventManager.getInstance().subscribe(EventType.ADD_TO_CART, this);
    EventManager.getInstance().subscribe(EventType.PAY, this);
    EventManager.getInstance().subscribe(EventType.LIST_CART, this);
    buffer = "";
   }

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
    System.out.print("Receipt:\n");

    double price=0;
    for(Goods goods : shopppingCart.keySet()){
      buffer=String.format("%-40s%-10s%-10s\n", goods.name(),goods.price(), shopppingCart.get(goods));
      System.out.print(buffer);
      price+=goods.price()*shopppingCart.get(goods);
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
      System.out.print("--------------------------------------------------------------------------------\n");
      for(Goods goods : shopppingCart.keySet()){
        System.out.print(String.format("%-4s%-22s%-40s%-8s%-6s\n", goods.id(), goods.name(), goods.description(), goods.price(), shopppingCart.get(goods)));
      }
    }
   }
}
