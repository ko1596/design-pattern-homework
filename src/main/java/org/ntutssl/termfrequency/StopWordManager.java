package org.ntutssl.termfrequency;

import java.util.ArrayList;
import java.util.List;

public class StopWordManager implements EventListener {

  private List<String> stopWord;
  public StopWordManager(EventManager eventManager) {
    stopWord = new ArrayList<>();
   }

  public List<String> getStopWords() {
    return stopWord;
   }

  public void onEvent(EventType eventType, String event) {

  }
}