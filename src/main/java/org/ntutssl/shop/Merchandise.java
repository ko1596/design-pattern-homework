package org.ntutssl.shop;

public class Merchandise implements Goods {

  /**
   * constructor
   * @param id goods id which should not be negative
   * @param name
   * @param desc
   * @param price goods price which should not be negative
   */
  private int ids;
  private String names;
  private double prices;
  private String descriptions;

  public Merchandise(int id, String name, String desc, double price) {
    if(id<0) throw new ShopException("Goods id which should not be negative");
    if(price<0) throw new ShopException("Goods price which should not be negative");
    
    this.ids = id;
    this.names = name;
    this.descriptions = desc;
    this.prices = price;
   }
   @Override
  public int id() {
    // TODO Auto-generated method stub
    return ids;
  }

  @Override
  public double price() {
    // TODO Auto-generated method stub
    return prices;
  }

  @Override
  public String name() {
    // TODO Auto-generated method stub
    return names;
  }

  @Override
  public String description() {
    // TODO Auto-generated method stub
    return descriptions;
  }
}