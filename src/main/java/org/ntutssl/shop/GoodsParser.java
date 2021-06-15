package org.ntutssl.shop;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class GoodsParser implements EventListener {

  private GoodsBuilder goodsBuilder;
  private int count;
  public GoodsParser() {
    this.goodsBuilder = new GoodsBuilder();
    this.count = 0;
    EventManager.getInstance().subscribe(EventType.IMPORT_SHOPPING_LIST, this);
    EventManager.getInstance().subscribe(EventType.IMPORT_REPLENISH_LIST, this);
   }

  public void onEvent(Event event) {
    if(event.type() == EventType.IMPORT_SHOPPING_LIST)
      importShoppingCartList(event);
    else if(event.type() == EventType.IMPORT_REPLENISH_LIST)
      importReplenishmentList(event);
   }

  /**
   * private methods are not necessary, but you can takce them as reference.
   */
  private void importShoppingCartList(Event<String> event) {
    try(JsonReader jReader = new JsonReader(new InputStreamReader(new FileInputStream(event.data()),"UTF-8")))
    {
        JsonArray jArray = JsonParser.parseReader(jReader).getAsJsonArray();
        for(JsonElement jElement : jArray){
            Goods goods = this.parse(jElement.getAsJsonObject());
            count = Integer.parseInt(jElement.getAsJsonObject().get("count").getAsString());
            EventManager.getInstance().publish(new GoodsEvent(EventType.CHECK_STOCK, goods, count));
        }
        EventManager.getInstance().publish(new StringEvent(EventType.SORT_CART,""));
    }catch(Exception e){
        e.printStackTrace();
    }
  }

  private void importReplenishmentList(Event<String> event) {
    try(JsonReader jReader = new JsonReader(new InputStreamReader(new FileInputStream(event.data()),"UTF-8")))
    {
        JsonArray jArray = JsonParser.parseReader(jReader).getAsJsonArray();
        for(JsonElement jElement : jArray){
            Goods goods = this.parse(jElement.getAsJsonObject());
            count = Integer.parseInt(jElement.getAsJsonObject().get("count").getAsString());
            EventManager.getInstance().publish(new GoodsEvent(EventType.REPLENISH, goods, count));
        }
        EventManager.getInstance().publish(new StringEvent(EventType.SORT_SHOP,""));
    }catch(Exception e){
        e.printStackTrace();
    }
   }

  private Goods parse(JsonObject jsonObj) {
    if(jsonObj.get("type").getAsString().equals("merchandise"))
      goodsBuilder.buildMerchandise(jsonObj.get("id").getAsInt(), jsonObj.get("name").getAsString(), jsonObj.get("description").getAsString(), jsonObj.get("price").getAsDouble());
    else if(jsonObj.get("type").getAsString().equals("collection")){
      goodsBuilder.startBuildCollection(jsonObj.get("id").getAsInt(), jsonObj.get("name").getAsString(), jsonObj.get("description").getAsString());
      JsonArray ja = jsonObj.get("contents").getAsJsonArray();
      for (JsonElement je : ja)
        this.parse(je.getAsJsonObject());
      goodsBuilder.endBuildCollection();
    }
    return goodsBuilder.getResult();
  }
}
