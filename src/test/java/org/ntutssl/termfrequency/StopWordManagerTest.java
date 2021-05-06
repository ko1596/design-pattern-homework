package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StopWordManagerTest {
    @Test
    public void isStopword(){
        EventManager eventManager = new EventManager();
        StopWordManager swm = new StopWordManager(eventManager);
        swm.onEvent(EventType.LOAD, "");
        assertTrue(swm.getStopWords().contains("a"));
    }
 }
