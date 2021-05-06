package org.ntutssl.termfrequency;

import java.util.ArrayList;
import java.util.List;

public class DataStorageManager {

  private List<String> words;

  public DataStorageManager(EventManager eventManager) {
    words = new ArrayList<>();
   }

  public List<String> getWords() {
    return words;
   }

  public void onEvent(EventType eventType, String event) { }
}