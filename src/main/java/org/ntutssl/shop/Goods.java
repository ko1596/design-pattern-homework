package org.ntutssl.shop;

public interface Goods {
  public int id();
  public double price();
  public String name();
  public String description();

  public default void add(Goods goods) { }
  public default Iterator<Goods> iterator() { }
}
