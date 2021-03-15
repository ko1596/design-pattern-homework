package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StopWordManagerTest {
    @Test
    public void test_list_is_stop_word_first(){
        IOHandler ioh = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt",ioh);
        assertTrue(swm.isStopWordList("a"));
    }
    @Test
    public void test_list_is_stop_word_middle(){
        IOHandler ioh = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt",ioh);
        assertTrue(swm.isStopWordList("me"));
    }
    @Test
    public void test_list_is_stop_word_last(){
        IOHandler ioh = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt",ioh);
        assertTrue(swm.isStopWordList("your"));
    }
    @Test
    public void test_set_is_stop_word_first(){
        IOHandler ioh = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt",ioh);
        assertTrue(swm.isStopWordSet("a"));
    }
    @Test
    public void test_set_is_stop_word_middle(){
        IOHandler ioh = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt",ioh);
        assertTrue(swm.isStopWordSet("me"));
    }
    @Test
    public void test_set_is_stop_word_last(){
        IOHandler ioh = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt",ioh);
        assertTrue(swm.isStopWordSet("your"));
    }
    @Test
    public void test_is_not_a_stop_word(){
        IOHandler ioh = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt",ioh);
        assertTrue(!swm.isStopWordSet("1234"));
    }
    @Test
    public void test_compare_efficiency_between_list_and_set(){
        IOHandler ioh = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt",ioh);
        long startTimeList = System.nanoTime();
        assertTrue(swm.isStopWordList("me"));
        assertTrue(swm.isStopWordList("your"));
        long endTimeList = System.nanoTime();

        long startTimeSet = System.nanoTime();
        assertTrue(swm.isStopWordSet("me"));
        assertTrue(swm.isStopWordSet("your"));
        long endTimeSet = System.nanoTime();

        assertTrue(endTimeSet - startTimeSet< endTimeList - startTimeList);

    }
    @Test
    public void test_single_character_should_be_a_stop_word(){
        IOHandler ioh = new IOHandler();
        StopWordManager swm = new StopWordManager("input/stop_words.txt",ioh);
        assertTrue(swm.isStopWordSet("s"));
    }
 }
