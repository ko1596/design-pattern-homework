package org.ntutssl.shop;

import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class EventManager {
  private static volatile EventManager instance = null;
  private Multimap<EventType, EventListener> eventMap;
  
  private EventManager() { 
    eventMap = ArrayListMultimap.create();
  }

  public static EventManager getInstance() {
    if (instance == null){
      instance = new EventManager();
    }
    return instance;
  }

  public void subscribe(EventType eventType, EventListener listener) {
    eventMap.put(eventType, listener);
   }

  public <T> void publish(Event<T> event) {
    for(Event)
  }

  

  // SINGLETON implementation below
  
}
