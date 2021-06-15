package org.ntutssl.shop;

public interface PayStrategy {
  public void calculate(double totalPrice);
}
