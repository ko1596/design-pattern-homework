package org.ntutssl.shop;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart implements EventListener {

  private Map<Integer, Integer> shoppingCart;
  private Map<Integer, Goods> goods;
  private String str;

  public ShoppingCart() {
    this.shoppingCart = new LinkedHashMap<>();
    this.goods = new LinkedHashMap<>();
    str = "";

    EventManager.getInstance().subscribe(EventType.ADD_TO_CART, this);
    EventManager.getInstance().subscribe(EventType.PAY, this);
    EventManager.getInstance().subscribe(EventType.LIST_CART, this);
    EventManager.getInstance().subscribe(EventType.PRINT_RECEIPT, this);
    EventManager.getInstance().subscribe(EventType.SORT_CART, this);
   }

  public void onEvent(Event event) {
    if(event.type()==EventType.ADD_TO_CART) add(event);
    if(event.type()==EventType.PAY)  pay();
    if(event.type()==EventType.LIST_CART)  listCart();
    if(event.type()==EventType.PRINT_RECEIPT) printReceipt(event);
    if(event.type()==EventType.SORT_CART) sort();
   }

  /**
   * add goods to shopping cart
   * @param goodsEvent the data of this event is the goods to be added
   */
  private void add(Event<Goods> event) {
    if(this.shoppingCart.containsKey(event.data().id())) {
      this.shoppingCart.put(event.data().id(), this.shoppingCart.get(event.data().id())+event.count());
    }
    else {
      this.shoppingCart.put(event.data().id(), event.count());
      this.goods.put(event.data().id(), event.data());
    }
   }

  /**
   * pay for all items in the shopping cart
   */
  private void pay() {
    double price=0;
    for(Integer id : shoppingCart.keySet()){
      price+=this.goods.get(id).price()*shoppingCart.get(id);
    }
    EventManager.getInstance().publish(new StringEvent(EventType.CALCULATE,Double.toString(price)));
   }

  /**
   * print receipt and publish PURCHASE
   */
  private void printReceipt(Event<String> event) {
    System.out.print("================================================================================\n");
    System.out.print("Receipt:\n");
    str=String.format("%-40s%-10s%-10s\n", "name","price", "count");
    System.out.print(str);
    for(Integer id : shoppingCart.keySet()){
      Goods g = this.goods.get(id);
      str=String.format("%-40s%-10s%-10s\n", g.name(),"$"+g.price(), shoppingCart.get(id));
      System.out.print(str);
      EventManager.getInstance().publish(new GoodsEvent(EventType.PURCHASE,g,shoppingCart.get(id)));
    }
    System.out.print("--------------------------------------------------------------------------------\n");
    System.out.print("Total Price: " + event.data()+ "\n");
    System.out.print("================================================================================\n");
   }

  /**
   * list all items in the shopping cart
   */
  private void listCart() {
    if(shoppingCart.isEmpty()){
      System.out.print("Your shopping cart is empty\n");
    }
    else{
      System.out.print("================================================================================\n");
      str=String.format("%-4s%-22s%-40s%-8s%-6s\n", "ID","name", "description", "price", "count");
      System.out.print(str);
      System.out.print("--------------------------------------------------------------------------------\n");
      for(Integer id : shoppingCart.keySet()){
        Goods g = this.goods.get(id);
        str=String.format("%-4s%-22s%-40s%-8s%-6s\n", g.id(),g.name(), g.description(), g.price(), shoppingCart.get(id));
        System.out.print(str);
      }
      System.out.print("================================================================================\n");
    } 
   }

   private void sort(){
    List<Entry<Integer, Integer>> list = new LinkedList<>(this.shoppingCart.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return (o1.getKey()).compareTo((o2.getKey()));
        }
    });
    this.shoppingCart = new LinkedHashMap<>();
    for (Iterator<Entry<Integer, Integer>> it = list.iterator(); it.hasNext();) {
        Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
        this.shoppingCart.put(entry.getKey(), entry.getValue());
    }
  }
  
}
