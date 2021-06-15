package org.ntutssl.shop;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Shop implements EventListener {

  private Map<Integer, Integer> shop;
  private Map<Integer, Goods> goods;
  private String str;

  public Shop() {
    this.shop = new LinkedHashMap<>();
    this.goods = new LinkedHashMap<>();
    EventManager.getInstance().subscribe(EventType.REPLENISH, this);
    EventManager.getInstance().subscribe(EventType.CHECK_STOCK, this);
    EventManager.getInstance().subscribe(EventType.PURCHASE, this);
    EventManager.getInstance().subscribe(EventType.LIST_SHOP, this);
    EventManager.getInstance().subscribe(EventType.SORT_SHOP, this);
   }  

  public void onEvent(Event event) {
    if(event.type()==EventType.REPLENISH) replenish(event);
    if(event.type()==EventType.CHECK_STOCK) checkStock(event);
    if(event.type()==EventType.PURCHASE) purchase(event);
    if(event.type()==EventType.LIST_SHOP) listShop();
    if(event.type()==EventType.SORT_SHOP) sort();
   }

  /**
   * replenish stock
   * @param event Event of Goods to replenish
   */
  private void replenish(Event<Goods> event) {
    if(this.shop.containsKey(event.data().id())) {
      this.shop.put(event.data().id(), this.shop.get(event.data().id())+event.count());
    }
    else {
      this.shop.put(event.data().id(), event.count());
      this.goods.put(event.data().id(), event.data());
    }
   }

  /**
   * check if the specific goods is in stock, if so, publish an 
   * event ADD_TO_CART
   * @param event Event of Goods to check
   */
  private void checkStock(Event<Goods> event) {
    if(this.shop.containsKey(event.data().id()) && this.shop.get(event.data().id()) >= event.count()){
      EventManager.getInstance().publish(new GoodsEvent(EventType.ADD_TO_CART, event.data(), event.count()));
    }
    else if(!this.shop.containsKey(event.data().id()))
      System.out.print("The store doesn't have this goods.\n");
    else if(this.shop.get(event.data().id()) < event.count())
      System.out.print("out of stock. goods ID: "+event.data().id()+"\n");
   }

  /**
   * deduct stock after user complete purchase
   * @param event Event of Goods to be deducted
   */
  private void purchase(Event<Goods> event) {
    if(this.shop.containsKey(event.data().id()) && this.shop.get(event.data().id()) >= event.count())
      this.shop.put(event.data().id(), this.shop.get(event.data().id()) - event.count());
    else if(!this.shop.containsKey(event.data().id()))
      System.out.print("The store doesn't have this goods.\n");
    else if(this.shop.get(event.data().id()) < event.count())
      System.out.print("out of stock. goods ID: "+event.data().id()+"\n");
   }

  /**
   * show stocks of this shop
   */
  private void listShop() {
    if(this.shop.isEmpty()){
      System.out.print("This shop does not sell anything.\n");
    }
    else{
      System.out.print("================================================================================\n");
      str=String.format("%-4s%-22s%-40s%-8s%-6s\n", "ID","name", "description", "price", "count");
      System.out.print(str);
      System.out.print("--------------------------------------------------------------------------------\n");
      for(Integer id : shop.keySet()){
        str=String.format("%-4s%-22s%-40s%-8s%-6s\n", id ,this.goods.get(id).name(), this.goods.get(id).description(), this.goods.get(id).price(), shop.get(id));
        System.out.print(str);
      }
      System.out.print("================================================================================\n");
    }
   }
   
   private void sort(){
    List<Entry<Integer, Integer>> list = new LinkedList<>(this.shop.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return (o1.getKey()).compareTo((o2.getKey()));
        }
    });
    this.shop = new LinkedHashMap<>();
    for (Iterator<Entry<Integer, Integer>> it = list.iterator(); it.hasNext();) {
        Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
        this.shop.put(entry.getKey(), entry.getValue());
    }
  }
}
