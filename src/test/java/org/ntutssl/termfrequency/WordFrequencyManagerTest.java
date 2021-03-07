package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordFrequencyManagerTest{ 
    @Test
    public void word_frequency_manager_works(){
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("dog");
        wfm.incrementCount("dog");
        wfm.incrementCount("cat");
        assertEquals(Integer.valueOf(2), wfm.getCount("dog"));
        assertEquals(Integer.valueOf(1), wfm.getCount("cat"));
        assertEquals(Integer.valueOf(0), wfm.getCount("mouse"));
    }
}