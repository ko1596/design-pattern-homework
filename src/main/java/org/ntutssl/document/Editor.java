package org.ntutssl.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import com.google.gson.stream.JsonReader;
import com.google.gson.*;

public class Editor {

  private List<Document> documentList;

  public Editor() {
    this.documentList = new ArrayList<>();
   }

  public void importDocumentFromJsonFile(String filePath) {
    try(JsonReader jReader = new JsonReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8")))
    {
        JsonArray jArray = JsonParser.parseReader(jReader).getAsJsonArray();
        for(JsonElement jElement : jArray){
            DocumentParser documentParser = new DocumentParser();
            this.add(documentParser.parse(jElement.getAsJsonObject()));
        }
    }catch(Exception e){
        e.printStackTrace();
    }
   }

  public void exportDocumentAsHtmlFile(String outputPath) {
    try{
      List<String> results = new ArrayList<>();
      HtmlOutputConsumer hoc = new HtmlOutputConsumer(results);
      documentList.forEach(hoc);
      Path path = Paths.get(outputPath);
      Files.write(path, results, StandardCharsets.UTF_8);
    }catch(IOException e){
      throw new DocumentException("write fail.");
    }
  }

  public void findContent(String target) {
    List<Document> results = new ArrayList<>();
    FindContentConsumer fcc = new FindContentConsumer(results,target);
    documentList.forEach(fcc);
    results.forEach(System.out::print);
  }

  public void add(Document document) {
    documentList.add(document);
  }

  public int size() {
    return documentList.size();
   }

  public Iterator<Document> iterator() {
    return documentList.iterator();
   }
}