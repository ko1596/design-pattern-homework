package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class WordFrequencyManagerStreamTest {
    @Test
    public void test_get_number_of_word(){
        WordFrequencyManagerStream wfm = new WordFrequencyManagerStream();
        wfm.incrementCount("dog");
        wfm.incrementCount("dog");
        wfm.incrementCount("cat");
        wfm.incrementCount("cat");
        assertEquals(2, wfm.getNumOfWords());
    }
}
