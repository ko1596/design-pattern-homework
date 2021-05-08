package org.ntutssl.termfrequency;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DataStorageManagerTest implements EventListener {
    public int validateNum = 0;
    public int eofNum = 0;
    public void onEvent(EventType eventType, String event) {
        if(eventType == EventType.VALIDATE)
            this.validateNum++;
        if(eventType == EventType.EOF)
            this.eofNum++;
    }

    @Test
    public void test_event_eof_should_be_publish_successfully(){
            validateNum = 0;
            EventManager em = new EventManager();
            DataStorageManager dsm = new DataStorageManager(em);
            em.subscribe(EventType.VALIDATE, this);
            em.publish(EventType.LOAD, "input/testfile.txt");
            em.publish(EventType.RUN, "Run");
            assertEquals(7,this.validateNum);
    }

    @Test
    public void test_event_eof_should_be_load_from_file(){
            EventManager em = new EventManager();
            DataStorageManager dsm = new DataStorageManager(em);
            em.publish(EventType.LOAD, "input/testfile.txt");
            List<String> testFileList = new ArrayList<>();
            testFileList.add("aa");
            testFileList.add("bb");
            testFileList.add("cc");
            testFileList.add("dd");
            testFileList.add("dd");
            testFileList.add("cc");
            testFileList.add("kk");
            assertEquals(dsm.getWords(),testFileList);
    }
    
    @Test
    public void test_event_run_should_start_validating_words(){
            eofNum = 0;
            EventManager em = new EventManager();
            DataStorageManager dsm = new DataStorageManager(em);
            em.subscribe(EventType.EOF, this);
            em.publish(EventType.LOAD, "input/testfile.txt");
            em.publish(EventType.RUN, "Run");
            assertEquals(this.eofNum,1);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void fileNotFoundSetExceptionIsWork(){
        EventManager em = new EventManager();
        DataStorageManager dsm = new DataStorageManager(em);
        exceptionRule.expect(WordFrequencyException.class);
        exceptionRule.expectMessage("File not found.");
        em.publish(EventType.LOAD, "aaaa.txt");
    }
 }

