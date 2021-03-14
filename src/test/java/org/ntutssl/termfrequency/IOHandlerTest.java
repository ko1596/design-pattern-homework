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

    @Test
    public void test_list_input_Content_first_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_list_string = ioh.handleInputAsList("input/pride-and-prejudice.txt", "[\\W_]+");
        assertTrue(test_list_string.contains("the"));
    }

    @Test
    public void test_list_input_Content_middle_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_list_string = ioh.handleInputAsList("input/pride-and-prejudice.txt", "[\\W_]+");
        assertTrue(test_list_string.contains("light"));
    }

    @Test
    public void test_list_input_Content_last_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_list_string = ioh.handleInputAsList("input/pride-and-prejudice.txt", "[\\W_]+");
        assertTrue(test_list_string.contains("ebooks"));
    }

    //--------------------------------------------------------------------------------------------------------

    @Test
    public void test_set_input_stop_word_first_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_set_string = ioh.handleInputAsSet("input/stop_words.txt", ",");
        assertTrue(test_set_string.contains("a"));
    }

    @Test
    public void test_set_input_stop_word_middle_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_set_string = ioh.handleInputAsSet("input/stop_words.txt", ",");
        assertTrue(test_set_string.contains("let"));
    }

    @Test
    public void test_set_input_stop_word_last_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_set_string = ioh.handleInputAsSet("input/stop_words.txt", ",");
        assertTrue(test_set_string.contains("your"));
    }

    @Test
    public void test_set_input_Content_first_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_set_string = ioh.handleInputAsSet("input/pride-and-prejudice.txt", "[\\W_]+");
        assertTrue(test_set_string.contains("the"));
    }

    @Test
    public void test_set_input_Content_middle_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_set_string = ioh.handleInputAsSet("input/pride-and-prejudice.txt", "[\\W_]+");
        assertTrue(test_set_string.contains("light"));
    }

    @Test
    public void test_set_input_Content_last_word(){
        IOHandler ioh = new IOHandler();
        List<String> test_set_string = ioh.handleInputAsSet("input/pride-and-prejudice.txt", "[\\W_]+");
        assertTrue(test_set_string.contains("ebooks"));
    }

 }
