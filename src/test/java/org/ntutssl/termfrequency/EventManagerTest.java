package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EventManagerTest implements EventListener{
    public int startcount =0;
    public void onEvent(EventType eventType, String event){
        if(eventType == EventType.START) startcount++;
    }
    
    @Test
    public void test_START(){
        EventManager em = new EventManager();
        em.subscribe(EventType.START, this);
        em.publish(EventType.START, "");
        assertEquals(1, startcount);
        em.publish(EventType.START, "");
        assertEquals(2, startcount);
    }
 }