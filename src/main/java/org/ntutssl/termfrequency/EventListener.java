package org.ntutssl.termfrequency;

/**
 * Implementing this interface allows an object to be able to listen on
 * different event.
 * @param eventType type of event
 * @param event additional information for this event (use type "String" for
 * simplicity)
 */
public interface EventListener {
  public void onEvent(EventType eventType, String event);
}