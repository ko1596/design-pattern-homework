package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
        Set<String> test_set_string = ioh.handleInputAsSet("input/stop_words.txt", ",");
        assertTrue(test_set_string.contains("a"));
    }

    @Test
    public void test_set_input_stop_word_middle_word(){
        IOHandler ioh = new IOHandler();
        Set<String> test_set_string = ioh.handleInputAsSet("input/stop_words.txt", ",");
        assertTrue(test_set_string.contains("let"));
    }

    @Test
    public void test_set_input_stop_word_last_word(){
        IOHandler ioh = new IOHandler();
        Set<String> test_set_string = ioh.handleInputAsSet("input/stop_words.txt", ",");
        assertTrue(test_set_string.contains("your"));
    }

    @Test
    public void test_set_input_Content_first_word(){
        IOHandler ioh = new IOHandler();
        Set<String> test_set_string = ioh.handleInputAsSet("input/pride-and-prejudice.txt", "[\\W_]+");
        assertTrue(test_set_string.contains("the"));
    }

    @Test
    public void test_set_input_Content_middle_word(){
        IOHandler ioh = new IOHandler();
        Set<String> test_set_string = ioh.handleInputAsSet("input/pride-and-prejudice.txt", "[\\W_]+");
        assertTrue(test_set_string.contains("light"));
    }

    @Test
    public void test_set_input_Content_last_word(){
        IOHandler ioh = new IOHandler();
        Set<String> test_set_string = ioh.handleInputAsSet("input/pride-and-prejudice.txt", "[\\W_]+");
        assertTrue(test_set_string.contains("ebooks"));
    }

    @Test(expected = WordFrequencyException.class)
    public void test_set_file_not_found(){
        IOHandler ioh = new IOHandler();
        ioh.handleInputAsSet("input/notfile", "[\\W_]+");
    }

    @Test(expected = WordFrequencyException.class)
    public void test_list_file_not_found(){
        IOHandler ioh = new IOHandler();
        ioh.handleInputAsList("input/notfile", "[\\W_]+");
    }

    @Test
    public void test_handleOutput(){
        IOHandler ioh = new IOHandler();
        List<String> test_data = new ArrayList<>();
        List<String> read_data = new ArrayList<>();
        test_data.add("a\n");
        test_data.add("b\n");
        test_data.add("c\n");
        test_data.add("d\n");
        ioh.handleOutput("output/test.txt", 3, test_data);

        try(Scanner sc = new Scanner(new File("output/test.txt"))){
            sc.useDelimiter("[\\W_]+");
            while(sc.hasNext()){
                read_data.add(sc.next().toLowerCase());
            }
        }catch(IOException e){
            System.out.println("Cannot found the file.");
        }
        assertTrue(read_data.contains("b"));
    }

 }
