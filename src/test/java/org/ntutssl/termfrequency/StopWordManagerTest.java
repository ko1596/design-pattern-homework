package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StopWordManagerTest{
    @Test
    public void test_list_is_stop_word_first(){
        StopWordManager swm = new StopWordManager("input/stop_words.txt");
        assertTrue(swm.isStopWordList("a"));
    }

    public void test_list_is_stop_word_middle(){
        StopWordManager swm = new StopWordManager("input/stop_words.txt");
        assertTrue(swm.isStopWordList("me"));
    }

    public void test_list_is_stop_word_last(){
        StopWordManager swm = new StopWordManager("input/stop_words.txt");
        assertTrue(swm.isStopWordList("your"));
    }

    public void test_set_is_stop_word_first(){
        StopWordManager swm = new StopWordManager("input/stop_words.txt");
        assertTrue(swm.isStopWordSet("a"));
    }

    public void test_set_is_stop_word_middle(){
        StopWordManager swm = new StopWordManager("input/stop_words.txt");
        assertTrue(swm.isStopWordSet("me"));
    }

    public void test_set_is_stop_word_last(){
        StopWordManager swm = new StopWordManager("input/stop_words.txt");
        assertTrue(swm.isStopWordSet("your"));
    }
 }