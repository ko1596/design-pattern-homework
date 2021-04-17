package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class TitleTest {
    @Test
    public void test_accept_visitor(){
        FindContentVisitor fcv = new FindContentVisitor("text");
        Document title = new Title("text", 1);
        fcv.visitTitle((Title) title);
        assertEquals(title, fcv.getResult().get(0));
    }

    @Test(expected = DocumentException.class)
    public void test_add_article_to_title_should_throw_exception(){
        Document title = new Title("text", 1);
        Document article = new Article("abc",3);
        title.add(article);
    }

    @Test(expected = DocumentException.class)
    public void test_add_paragraph_to_title_should_throw_exception(){
        Document paragraph = new Paragraph("paragraph");
        Document title = new Title("text", 1);
        title.add(paragraph);
    }

    @Test(expected = DocumentException.class)
    public void test_add_title_to_title_should_throw_exception(){
        Document title = new Title("text", 1);
        Document title2 = new Title("text", 1);
        title.add(title2);
    }

    @Test(expected = DocumentException.class)
    public void test_get_level_should_throw_exception(){
        Document title = new Title("text", 1);
        title.getLevel();
    }

    @Test
    public void est_get_size_should_throw_exception(){
        Document title = new Title("text", 1);
        assertEquals(1, title.getSize()); 
    }

    @Test
    public void test_get_text_of_plain_text(){
        Document title = new Title("text", 1);
        assertEquals("text", title.getText());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_paragraph_iterator_should_get_null_iterator(){
        Document title = new Title("text", 1);
        Iterator<Document> it = title.iterator();
        it.hasNext();
    }

    @Test
    public void test_to_string(){
        Document title = new Title("text", 1);
        assertEquals("Title\t\ttext: text\n\t\tsize: 1\n", title.toString());
    }
 }
