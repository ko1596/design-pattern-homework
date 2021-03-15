package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordFrequencyControllerTest {
    @Test
    public void test_run_work(){
        IOHandler ioHandler = new IOHandler();
        IStopWordManager swm = new StopWordManager("input/stop_words.txt",ioHandler);
        IDataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt",ioHandler);
        IWordFrequencyManager wfm = new WordFrequencyManagerStream();
        new WordFrequencyController(ioHandler, swm, dsm, wfm).run("des", 3 , "output/output.txt");;
        assertTrue(true);
    }

 }
