package org.ntutssl.shop;

import java.util.HashMap;
import java.util.Map;

public class Shop implements EventListener {
  
  private Map<Goods, Integer> shop;
  public Shop() {
    this.shop = new HashMap<>();
    EventManager.getInstance().subscribe(EventType.REPLENISH, this);
    EventManager.getInstance().subscribe(EventType.CHECK_STOCK, this);
    EventManager.getInstance().subscribe(EventType.PURCHASE, this);
    EventManager.getInstance().subscribe(EventType.LIST_SHOP, this);
   }  

  public void onEvent(Event event) {
    if(event.type() == EventType.REPLENISH)
      replenish(event);
    if(event.type() == EventType.CHECK_STOCK)
      checkStock(event);
    if(event.type() == EventType.PURCHASE)
      purchase(event);
    if(event.type() == EventType.LIST_SHOP)
      listShop();
   }

  /**
   * private methods are not necessary, but you can takce them as reference.
   */
  /**
   * replenish stock
   * @param event Event of Goods to replenish
   */
  private void replenish(Event<Goods> event) {
    if(shop.containsKey(event.data()))
      shop.put(event.data(), shop.get(event.data())+event.count());
    else
      shop.put(event.data(), shop.get(event.data()));
   }

  /**
   * check if the specific goods is in stock, if so, publish an 
   * event ADD_TO_CART
   * @param event Event of Goods to check
   */
  private void checkStock(Event<Goods> event) {
    if(shop.containsKey(event.data()) && shop.get(event.data()) > event.count()){
      EventManager.getInstance().publish(new GoodsEvent(EventType.ADD_TO_CART, event.data(), event.count()));
    }
   }

  /**
   * deduct stock after user complete purchase
   * @param event Event of Goods to be deducted
   */
  private void purchase(Event<Goods> event) {
    EventManager.getInstance().publish(new GoodsEvent(EventType.ADD_TO_CART, event.data(), event.count())); 
   }

  /**
   * show stocks of this shop
   */
  private void listShop() {
    System.out.print(String.format("%-4s%-22s%-40s%-8s%-6s\n", "ID","name", "description", "price", "count"));
    System.out.print("--------------------------------------------------------------------------------\n");

    for(Goods goods : shop.keySet())
      System.out.print(String.format("%-4s%-22s%-40s%-8s%-6s\n", goods.id(),goods.name(), goods.description(), goods.price(), shop.get(goods)));
    
   }
}
