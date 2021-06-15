package org.ntutssl.shop;

import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class EventManager {
  private static EventManager instance;
  private Multimap<EventType, EventListener> eventMap;

  private EventManager() { 
    eventMap = ArrayListMultimap.create();
  }

  public void subscribe(EventType eventType, EventListener listener) {
    eventMap.put(eventType, listener);
   }

  public <T> void publish(Event<T> event) {
    for(Map.Entry<EventType, EventListener> eventEntry: this.eventMap.entries()){
      if(eventEntry.getKey() != null && eventEntry.getKey() == event.type()){
        eventEntry.getValue().onEvent(event);
      }
    }
  }

  // SINGLETON implementation below
  
  public static EventManager getInstance() {
    if (instance == null) {
      synchronized(EventManager.class) {
        if (instance == null) {
          instance = new EventManager();
        }
      }
    }
    return instance;
  }

  static synchronized void reset(){
    instance = null;
  }

}
