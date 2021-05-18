package org.ntutssl.document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.*;
import java.io.File;

public class Editor {

  private List<Document> documentList;

  public Editor() {
    this.documentList = new ArrayList<>();
   }

  public void importDocumentFromJsonFile(String filePath) {
    
   }

  public void exportDocumentAsHtmlFile(String outputPath) { }

  public void findContent(String target) { }

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