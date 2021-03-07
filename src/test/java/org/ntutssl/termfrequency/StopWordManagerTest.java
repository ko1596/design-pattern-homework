package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StopWordManagerTest{
    @Test
    public void test_stop_word(){
        StopWordManager swm = new StopWordManager();
        assertTrue(swm.isStopWord("a"));
        assertTrue(swm.isStopWord("the"));
    }
 }