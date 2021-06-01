package org.ntutssl.shop;

import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class EventManager {

  private Multimap<EventType, EventListener> eventMap;
  
  public EventManager() { 
    eventMap = ArrayListMultimap.create();
  }

  public void subscribe(EventType eventType, EventListener listener) {
    eventMap.put(eventType, listener);
   }

  public <T> void publish(Event<T> event) {
    
  }

  // SINGLETON implementation below
  
}
