package org.ntutssl.shop;

import java.util.Stack;

public class GoodsBuilder {

  private Stack<Goods> stack;
  private Goods goods;
  
  public GoodsBuilder() {
    this.goods = null;
    this.stack = new Stack<>();
   }

  public void buildMerchandise(int id, String name, String desc, double price) {
    if(this.stack.empty())
      goods = new Merchandise(id, name, desc, price);
    else
      this.stack.peek().add(new Merchandise(id, name, desc, price));
  }

  public void startBuildCollection(int id, String name, String desc) {
    this.stack.push(new Collection(id, name, desc));
   }

  public void endBuildCollection() {
    if(this.stack.size() == 1)
      goods = this.stack.pop();
    else{
      Goods temp = stack.pop();
      this.stack.peek().add(temp);
    }
   }
  
  public Goods getResult() {
    return goods;
   }
}
