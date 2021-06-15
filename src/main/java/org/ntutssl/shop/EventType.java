package org.ntutssl.shop;

public enum EventType {
  /**
   * user import shopping list
   */
  IMPORT_SHOPPING_LIST,

  /**
   * user import replenish list
   */
  IMPORT_REPLENISH_LIST,

  /**
   * shop replenish goods
   */
  REPLENISH,
  
  /**
   * check remaining stock
   */
  CHECK_STOCK,
  
  /**
   * add goods to shopping cart 
   */
  ADD_TO_CART,

  /**
   * user pay for all the items in the cart
   */
  PAY,

  /**
   * calculate total price with different strategy
   */
  CALCULATE,

  /**
   * print the receipt
   */
  PRINT_RECEIPT,

  /**
   * purchase goods in the cart from a shop
   */
  PURCHASE,

  /**
   * list shopping cart
   */
  LIST_CART,

  /**
   * list shop
   */
  LIST_SHOP,

  SORT_CART,
  
  SORT_SHOP,
}
