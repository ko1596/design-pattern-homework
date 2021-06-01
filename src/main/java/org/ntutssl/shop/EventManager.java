package org.ntutssl.shop;

public class EventManager {
  
  public void subscribe(EventType eventType, EventListener listener) { }

  public <T> void publish(Event<T> event) { }

  // SINGLETON implementation below
  
}
