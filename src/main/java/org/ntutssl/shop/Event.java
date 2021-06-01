package org.ntutssl.shop;

public abstract class Event<T> {
  private EventType eventType;
  private T data;

  public Event(EventType eventType, T data) {
    this.eventType = eventType;
    this.data = data;
  }
  
  public EventType type() {
    return this.eventType;
  }

  public T data() {
    return this.data;
  }

  public int count() {
    throw new ShopException("invalid operation");
  }
}
