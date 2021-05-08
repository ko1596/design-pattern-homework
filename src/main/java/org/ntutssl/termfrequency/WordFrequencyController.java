package org.ntutssl.termfrequency;

public class WordFrequencyController implements EventListener {
  private EventManager eventManager;
  public WordFrequencyController(EventManager eventManager) {
    this.eventManager=eventManager;
    this.eventManager.subscribe(EventType.START, this);
   }

  public void onEvent(EventType eventType, String event) {
    if(EventType.START==eventType) {
      eventManager.publish(EventType.LOAD, event);
      eventManager.publish(EventType.RUN, "");
    }
   }
}