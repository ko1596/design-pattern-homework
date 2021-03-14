package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DataStorageManagerTest {
    @Test
    public void test_getWords_first(){
        IOHandler ioh = new IOHandler();
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt",ioh);
        assertTrue(dsm.getWords().contains("the"));
    }

    @Test
    public void test_getWords_last(){
        IOHandler ioh = new IOHandler();
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt",ioh);
        assertTrue(dsm.getWords().contains("ebooks"));
    }

 }
