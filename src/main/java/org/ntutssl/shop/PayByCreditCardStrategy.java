package org.ntutssl.shop;

public class PayByCreditCardStrategy implements PayStrategy, EventListener {

  public PayByCreditCardStrategy() { }

  public void onEvent(Event event) { }

  /**
   * Card number are 16 digits.
   * The format of card expiration date is 'mm/yy', such as '06/21'.
   * CVV code are 3 digits.
   */
  @Override
  public void calculate(double totalPrice) { }
}
