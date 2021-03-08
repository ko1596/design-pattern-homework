package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        wfm.incrementCount("dog");
        wfm.incrementCount("cat");
        wfm.incrementCount("cat");
        wfm.incrementCount("mouse");
        List<Map.Entry<String, Integer>> converteMap = new ArrayList<Map.Entry<String, Integer>>(wfm.getWordFrequencyAscending().entrySet());
        assertTrue(converteMap.get(0).getValue() < converteMap.get(converteMap.size()-1).getValue() );
        
    }
}