package org.ntutssl.document;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TitleTest {
    @Test
    public void test_getText(){
        Title title = new Title("aa", 1);
        assertEquals("aa", title.getText());
    }

    @Test
    public void test_getSize(){
        Title title = new Title("aa", 1);
        assertEquals(1, title.getSize());
    }

    
 }