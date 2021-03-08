package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
    @Test
    public void test_get_number_of_word(){
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("dog");
        wfm.incrementCount("dog");
        wfm.incrementCount("cat");
        wfm.incrementCount("cat");
        assertEquals(2, wfm.getNumOfWords());
    }

    @Test
    public void test_get_Word_Frequency_Ascending_work(){
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("dog");
        wfm.incrementCount("dog");
        wfm.incrementCount("dqog");
        wfm.incrementCount("cat");
        wfm.incrementCount("cat");
        wfm.incrementCount("mouse");
        List<String> converteMap = 
        assertEquals(2, wfm.getNumOfWords());
    }
}