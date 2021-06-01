package org.ntutssl.shop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection implements Goods {
  
  /**
   * consturctor
   * @param id goods id which should not be negative
   * @param name
   * @param desc
   */
  private int ids;
  private String names;
  private double prices;
  private String descriptions;
  private List<Goods> collitionLists;

  public Collection(int id, String name, String desc) {
    this.ids = id;
    this.names = name;
    this.descriptions = desc;
    this.collitionLists = new ArrayList<>();
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

  @Override
  public void add(Goods goods) {
      // TODO Auto-generated method stub
      Goods.super.add(goods);
  }

  @Override
  public Iterator<Goods> iterator() {
      // TODO Auto-generated method stub
      return this.collitionLists.iterator();
  }
}