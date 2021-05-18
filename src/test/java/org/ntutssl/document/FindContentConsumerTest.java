package org.ntutssl.document;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindContentConsumerTest {
    @Test
    public void test_accept_complex_document(){
        List<Document> result = new ArrayList();
        FindContentConsumer fcc = new FindContentConsumer(result,"Test");
        Article article = new Article("Test", 1);
        Article article2 = new Article("Test2", 2);
        Article article3 = new Article("Not", 3);
        Title title = new Title("Test", 1);
        Title title2 = new Title("Test2", 2);
        Title title3 = new Title("Not", 3);

        article.add(title);
        article3.add(title3);
        article2.add(article3);
        article2.add(title2);
        article.add(article2);
        fcc.accept(article);

        Iterator<Document> it = result.iterator();
        assertEquals(it.next(),article);
        assertEquals(it.next(),title);
        assertEquals(it.next(),article2);
        assertEquals(it.next(),title2);
        assertFalse(it.hasNext());
    }
    
    @Test
    public void test_accept_document_and_found(){
        List<Document> result = new ArrayList();
        FindContentConsumer fcc = new FindContentConsumer(result,"Test");
        Title title = new Title("Test", 3);
        fcc.accept(title);
        Iterator<Document> it = result.iterator();
        assertEquals(it.next(),title);
        assertFalse(it.hasNext());
    }

    @Test
    public void test_accept_document_and_not_found(){
        List<Document> result = new ArrayList();
        FindContentConsumer fcc = new FindContentConsumer(result,"Test");
        Title title = new Title("a", 3);

        fcc.accept(title);

        Iterator<Document> it = result.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void test_accept_document_with_empty_string_and_found(){
        List<Document> result = new ArrayList();
        Title title = new Title("", 1);
        FindContentConsumer fcc = new FindContentConsumer(result,"");

        fcc.accept(title);

        Iterator<Document> it = result.iterator();
        assertEquals(it.next(),title);
        assertFalse(it.hasNext());
    }

    @Test
    public void test_accept_document_with_empty_string_and_not_found(){
        Title title = new Title("test", 1);
        List<Document> result = new ArrayList();
        FindContentConsumer fcc = new FindContentConsumer(result,"");
        fcc.accept(title);
        Iterator<Document> it = result.iterator();
        assertFalse(it.hasNext());
    }
 }