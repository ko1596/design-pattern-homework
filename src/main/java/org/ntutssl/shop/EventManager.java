package org.ntutssl.shop;

import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class EventManager {
  private static volatile EventManager instance = null;
  private Multimap<EventType, EventListener> eventMap;


  public void subscribe(EventType eventType, EventListener listener) {
    eventMap.put(eventType, listener);
   }

  public <T> void publish(Event<T> event) {
    if(this.eventMap.get(event.type())!=null){
      for(EventListener eventListener : this.eventMap.get(event.type()))
        eventListener.onEvent(event);
    }
  }

  // SINGLETON implementation below
  
  private EventManager() { 
    eventMap = ArrayListMultimap.create();
  }

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
}
