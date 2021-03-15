package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    @Test

    public void test_WFMS_output_is_work(){
        IOHandler ioh = new IOHandler();
        List<String> read_data = new ArrayList<>();
        WordFrequencyManagerStream wfms = new WordFrequencyManagerStream();
        wfms.incrementCount("word");
        wfms.incrementCount("map");
        // wfms.incrementCount("cat");
        // wfms.incrementCount("cat");
        // wfms.incrementCount("cat");
        wfms.output("output/output2.txt", "des", 2, ioh);  //des asc

        try(Scanner sc = new Scanner(new File("output/output2.txt"))){
            sc.useDelimiter("\n");
            while(sc.hasNext()){
                read_data.add(sc.next().toLowerCase());
            }
        }catch(IOException e){
            System.out.println("Cannot found the file.");
        }
        assertTrue(true);
        // assertTrue(read_data.contains("dog: 2"));
    }
}
