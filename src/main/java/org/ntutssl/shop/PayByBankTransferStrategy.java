package org.ntutssl.shop;

public class PayByBankTransferStrategy implements PayStrategy, EventListener {

  public PayByBankTransferStrategy() { }

  public void onEvent(Event event) { }

  /**
   * Bank code are 3 digits.
   * Account number are 12 digits.
   */
  @Override
  public void calculate(double totalPrice) { }
}
