package org.ntutssl.shop;

public class Main {
  public static void main(String args[]) {
    ShoppingCart shoppingCart = new ShoppingCart();
    Shop shop = new Shop();
    GoodsParser goodsParser = new GoodsParser();
    
    EventManager.getInstance().publish(new StringEvent(EventType.IMPORT_REPLENISH_LIST, "imput/replenish_list.json"));
    EventManager.getInstance().publish(new StringEvent(EventType.LIST_SHOP, ""));
    EventManager.getInstance().publish(new StringEvent(EventType.IMPORT_SHOPPING_LIST, "imput/shopping_list.json"));
    EventManager.getInstance().publish(new StringEvent(EventType.LIST_CART, ""));
    EventManager.getInstance().publish(new StringEvent(EventType.PAY, ""));
    EventManager.getInstance().publish(new StringEvent(EventType.LIST_SHOP, ""));
    EventManager.getInstance().publish(new StringEvent(EventType.LIST_CART, ""));
   }
}
