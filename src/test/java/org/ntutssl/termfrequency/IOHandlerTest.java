package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class IOHandlerTest {
    @Test
    public void test_list_input_stop_word_first_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_list_string = ioh.handleInputAsList("input/stop_words.txt", ",");
        assertTrue(test_list_string.contains("a"));
    }

    @Test
    public void test_list_input_stop_word_middle_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_list_string = ioh.handleInputAsList("input/stop_words.txt", ",");
        assertTrue(test_list_string.contains("let"));
    }

    @Test
    public void test_list_input_stop_word_last_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_list_string = ioh.handleInputAsList("input/stop_words.txt", ",");
        assertTrue(test_list_string.contains("your"));
    }

 }
