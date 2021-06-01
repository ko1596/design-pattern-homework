package org.ntutssl.shop;

public class GoodsParser implements EventListener {
  
  public GoodsParser() { }

  public void onEvent(Event event) { }

  /**
   * private methods are not necessary, but you can takce them as reference.
   */
  private void importShoppingCartList(Event<String> event) { }

  private void importReplenishmentList(Event<String> event) { }

  private Goods parse(JsonObject jsonObj) { }
}
