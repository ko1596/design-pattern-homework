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
  private int id;
  private String name;
  private String desc;
  private List<Goods> goods;
  public Collection(int id, String name, String desc) {
    if(id < 0) throw new ShopException("Goods id which should not be negative");
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.goods = new ArrayList<>();
  }

  public int id(){
    return id;
  }

  public double price(){
    double price = 0;
    for(Goods g : goods) price+=g.price();
    return price;
  }
  
  public String name(){
    return name;
  }

  public String description(){
    return desc;
  }

  @Override
  public void add(Goods good){
    this.goods.add(good);
  }

  @Override
  public Iterator<Goods> iterator(){
    return this.goods.iterator();
  }
}