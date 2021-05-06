package org.ntutssl.termfrequency;

import java.util.HashMap;
import java.util.Map;

public class EventManager {

  private Map<EventType, EventListener> event;

  public EventManager() { 
    event = new HashMap<>();
  }

  public void subscribe(EventType eventType, EventListener listener) { 
    event.put(eventType, listener);
  }

  public void publish(EventType eventType, String event) { }
}