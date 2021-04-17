package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class NullIteratorTest {
    @Test
    public void test_has_next(){
        Editor editor = new Editor();
        Document article = new Article("topic", 3);
        editor.add(article);
        Iterator<Document> it = editor.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void test_next_element(){
        Editor editor = new Editor();
        Document article = new Article("topic", 3);
        editor.add(article);
        Iterator<Document> it = editor.iterator();
        assertEquals(article, it.next());
    }
 }