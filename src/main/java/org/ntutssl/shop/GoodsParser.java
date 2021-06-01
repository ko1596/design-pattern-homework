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
  private void importShoppingCartList(Event<String> event) { }

  private void importReplenishmentList(Event<String> event) {
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
