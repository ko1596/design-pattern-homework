package org.ntutssl.shop;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Goods {
  public int id();
  public double price();
  public String name();
  public String description();

  public default void add(Goods goods) {
    throw new ShopException("add function is not found");
   }
  public default Iterator<Goods> iterator() {
    throw new NoSuchElementException("NoSuchElementException");
   }
}
