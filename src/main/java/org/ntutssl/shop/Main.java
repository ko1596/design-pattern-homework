package org.ntutssl.shop;

public class Main {
  public static void main(String args[]) {
    ShoppingCart shoppingCart = new ShoppingCart();
    Shop shop = new Shop();
    GoodsParser goodsParser = new GoodsParser();
    InstructionHandler ih = new InstructionHandler();
    EventManager.getInstance().publish(new StringEvent(EventType.IMPORT_REPLENISH_LIST, "input/replenish_list.json"));
    ih.run();
   }
}
