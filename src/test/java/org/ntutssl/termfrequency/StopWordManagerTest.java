package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StopWordManagerTest implements EventListener{
    public int stopwordcount = 0;
    public void onEvent(EventType eventType, String event){
        if(eventType == EventType.COUNT) stopwordcount++;
        System.out.println(eventType);
    }
    @Test
    public void loadData(){
        EventManager eventManager = new EventManager();
        StopWordManager swm = new StopWordManager(eventManager);
        swm.onEvent(EventType.LOAD, "");
        assertTrue(swm.getStopWords().contains("z"));
    }
    @Test
    public void not_StopWord(){
        stopwordcount = 0;
        EventManager eventManager = new EventManager();
        StopWordManager swm = new StopWordManager(eventManager);
        eventManager.subscribe(EventType.COUNT, this);
        swm.onEvent(EventType.LOAD, "");
        swm.onEvent(EventType.VALIDATE, "asdasd");
        assertEquals(1, stopwordcount);
    }
    @Test
    public void is_StopWord(){
        stopwordcount = 0;
        EventManager eventManager = new EventManager();
        StopWordManager swm = new StopWordManager(eventManager);
        eventManager.subscribe(EventType.COUNT, this);
        swm.onEvent(EventType.LOAD, "");
        swm.onEvent(EventType.VALIDATE, "a");
        assertEquals(0, stopwordcount);
    }
 }
