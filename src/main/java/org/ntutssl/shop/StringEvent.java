package org.ntutssl.shop;

public class StringEvent extends Event<String> {
  private EventType eventType;
  private String data;

  public StringEvent(EventType eventType, String data) {
    super(eventType, data);
    this.data = data;
    this.eventType = eventType;
  }
  public EventType type() {
    return this.eventType;
  }

  public String data() {
    return this.data;
  }
}
