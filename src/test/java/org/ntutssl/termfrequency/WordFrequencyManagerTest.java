package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordFrequencyManagerTest implements EventListener{
    public int outputNum = 0;
    public void onEvent(EventType eventType, String event) {
        if(eventType == EventType.OUTPUT)
            this.outputNum++;
    }
    @Test
    public void test_event_count_should_increment_count(){
            EventManager em = new EventManager();
            WordFrequencyManager wfm = new WordFrequencyManager(em);

            em.publish(EventType.COUNT, "worda");
            em.publish(EventType.COUNT, "worda");
            em.publish(EventType.COUNT, "wordb");
            em.publish(EventType.COUNT, "worda");
            em.publish(EventType.COUNT, "worda");

            assertEquals(wfm.getNumOfWords(), 2);
            assertEquals(wfm.getCount("worda"), Integer.valueOf(4));
            assertEquals(wfm.getCount("wordb"), Integer.valueOf(1));
    }
    @Test
    public void test_event_eof_should_publish_event_output(){
            this.outputNum = 0;
            EventManager em = new EventManager();
            WordFrequencyManager wfm = new WordFrequencyManager(em);
            em.subscribe(EventType.OUTPUT, this);
            em.publish(EventType.EOF, "word");
            assertEquals(this.outputNum, 1);
    }
 }