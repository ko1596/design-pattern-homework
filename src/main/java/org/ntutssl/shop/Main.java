package org.ntutssl.shop;

public class Main {
  public static void main(String args[]) {
    EventManager.getInstance().publish(new StringEvent(EventType.IMPORT_REPLENISH_LIST, "imput/replenish_list.json"));
    EventManager.getInstance().publish(new StringEvent(EventType.LIST_SHOP, ""));
    EventManager.getInstance().publish(new StringEvent(EventType.IMPORT_SHOPPING_LIST, "imput/shopping_list.json"));
    EventManager.getInstance().publish(new StringEvent(EventType.LIST_CART, ""));
    

   }
}
