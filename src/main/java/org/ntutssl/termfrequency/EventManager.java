package org.ntutssl.termfrequency;

import java.util.HashMap;
import java.util.Map;

public class EventManager {

  private Map<EventType, EventListener> eventMap;

  public EventManager() { 
    eventMap = new HashMap<>();
  }

  public void subscribe(EventType eventType, EventListener listener) { 
    eventMap.put(eventType, listener);
  }

  public void publish(EventType eventType, String event) {
    for(Map.Entry<EventType, EventListener> i:eventMap.entrySet()){
      if(i.getKey()==eventType){
        i.getValue().onEvent(eventType, event);
      }
    }
   }
}