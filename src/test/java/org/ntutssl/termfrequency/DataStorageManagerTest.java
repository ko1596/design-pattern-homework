package org.ntutssl.termfrequency;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataStorageManagerTest{
    @Test
    public void test_getWords_first(){
        
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt");
        assertTrue(dsm.getWords().contains("the"));
    }

    @Test
    public void test_getWords_last(){
        DataStorageManager dsm = new DataStorageManager("input/pride-and-prejudice.txt");
        assertTrue(dsm.getWords().contains("ebooks"));
    }
 }