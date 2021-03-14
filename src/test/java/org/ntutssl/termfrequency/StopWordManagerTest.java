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
 }
