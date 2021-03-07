package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StopWordManagerTest{
    @Test
    public void test_stop_word_the(){
        StopWordManager swm = new StopWordManager();
        assertTrue(swm.isStopWord("the"));
    }
    
    public void test_is_stop_word_first_and_last(){
        StopWordManager swm = new StopWordManager();
        assertTrue(swm.isStopWord("a"));
        assertTrue(swm.isStopWord("your"));
    }
 }