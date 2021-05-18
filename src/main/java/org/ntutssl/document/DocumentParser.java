package org.ntutssl.document;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

class DocumentParser {

  private DocumentBuilder documentBuilder;

  public DocumentParser() {
    documentBuilder = new DocumentBuilder();
   }

  public Document parse(JsonObject jObj) {
    if(jObj.get("type").getAsString().equals("title"))
      documentBuilder.buildTitle(jObj.get("text").getAsString(), jObj.get("size").getAsInt());
    else if(jObj.get("type").getAsString().equals("paragraph"))
      documentBuilder.buildParagraph(jObj.get("text").getAsString());
    else if(jObj.get("type").getAsString().equals("article")){
      documentBuilder.startBuildArticle(jObj.get("text").getAsString(),jObj.get("level").getAsInt());
      JsonArray ja = jObj.get("contents").getAsJsonArray();
      for (JsonElement je : ja)
        this.parse(je.getAsJsonObject());
      documentBuilder = documentBuilder.endBuildArticle();
    }
    return documentBuilder.getResult();
   }
}