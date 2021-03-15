package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SortOrder;

import org.junit.Test;

public class WordFrequencyManagerTest {
    @Test(expected = WordFrequencyException.class)
    public void return_exception_if_order_is_invalid(){
        IOHandler ioh = new IOHandler();
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("word");
        wfm.incrementCount("map");
        wfm.output("output/output2.txt", "invalid", 2, ioh);
    }
    @Test(expected = WordFrequencyException.class)
    public void return_exception_if_range_exceeds_lower_limit(){
        IOHandler ioh = new IOHandler();
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("word");
        wfm.incrementCount("map");
        wfm.output("output/output2.txt", "des", -1, ioh);
    }
    @Test(expected = WordFrequencyException.class)
    public void return_exception_if_range_exceeds_upper_limit(){
        IOHandler ioh = new IOHandler();
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("word");
        wfm.incrementCount("map");
        wfm.output("output/output2.txt", "des", 3, ioh);
    }
    @Test(expected = WordFrequencyException.class)
    public void return_exception_if_word_not_found(){
        IOHandler ioh = new IOHandler();
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.output("output/output2.txt", "des", 1, ioh);
    }

    @Test
    public void test_wfm_output_is_work(){
        WordFrequencyManager wfm = new WordFrequencyManager();
        List<String> testList = new ArrayList<>();
        wfm.incrementCount("word");
        testList.add("word: 1\n");
        assertEquals(testList, wfm.getWordFrequency(SortOrder.DESCENDING));
    }
    @Test
    public void test_count_a_word_twice_should_return_two(){
        WordFrequencyManager wfm = new WordFrequencyManager();
        List<String> testList = new ArrayList<>();
        wfm.incrementCount("word");
        wfm.incrementCount("word");
        testList.add("word: 2\n");
        assertEquals(testList, wfm.getWordFrequency(SortOrder.DESCENDING));
    }
    @Test
    public void test_count_two_words_should_return_correct_map(){
        List<String> testList = new ArrayList<>();
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("map");
        wfm.incrementCount("word");
        testList.add("map: 1\n");
        testList.add("word: 1\n");
        assertEquals(testList, wfm.getWordFrequency(SortOrder.DESCENDING));
    }
    @Test
    public void test_empty_array_in_the_beginning(){
        WordFrequencyManager wfm = new WordFrequencyManager();
        assertEquals(0, wfm.getNumOfWords());
    }
    @Test
    public void test_get_num_of_words(){
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("word");
        assertEquals(1, wfm.getNumOfWords());
    }
    @Test
    public void test_sort_ascending(){
        List<String> testList = new ArrayList<>();
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("map");
        wfm.incrementCount("word");
        wfm.incrementCount("word");
        wfm.incrementCount("set");
        wfm.incrementCount("set");
        wfm.incrementCount("set");
        testList.add("map: 1\n");
        testList.add("word: 2\n");
        testList.add("set: 3\n");
        assertEquals(testList, wfm.getWordFrequency(SortOrder.ASCENDING));
    }
    @Test
    public void test_sort_descending(){
        List<String> testList = new ArrayList<>();
        WordFrequencyManager wfm = new WordFrequencyManager();
        wfm.incrementCount("map");
        wfm.incrementCount("word");
        wfm.incrementCount("word");
        wfm.incrementCount("set");
        wfm.incrementCount("set");
        wfm.incrementCount("set");
        testList.add("set: 3\n");
        testList.add("word: 2\n");
        testList.add("map: 1\n");
        assertEquals(testList, wfm.getWordFrequency(SortOrder.DESCENDING));
    }
 }
