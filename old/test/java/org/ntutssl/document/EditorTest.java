package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class EditorTest {
    @Test
    public void test_add_documents_to_editor(){
        Editor editor = new Editor();
        Document article = new Article("topic", 3);
        editor.add(article);
        Iterator<Document> it = editor.iterator();
        while(it.hasNext()) assertEquals(article, it.next()); 
    }

    @Test
    public void test_iterator_does_not_have_next_in_the_begining(){
        Editor editor = new Editor();
        Iterator<Document> it = editor.iterator();
        assertTrue(!it.hasNext());
    }

    @Test
    public void test_size_of_editor(){
        Editor editor = new Editor();
        Document article = new Article("topic", 3);
        editor.add(article);
        assertEquals(1, editor.size());
    }
 }