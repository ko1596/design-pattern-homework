package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ParagraphTest {
    @Test
    public void test_accept_visitor(){
        FindContentVisitor fcv = new FindContentVisitor("paragraph");
        Document paragraph = new Paragraph("paragraph");
        fcv.visitParagraph((Paragraph) paragraph);
        assertEquals(paragraph, fcv.getResult().get(0));
    }

    @Test(expected = DocumentException.class)
    public void test_add_article_to_paragraph_should_throw_exception(){
        Document paragraph = new Paragraph("paragraph");
        Document article = new Article("abc",3);
        paragraph.add(article);
    }

    @Test(expected = DocumentException.class)
    public void test_add_paragraph_to_paragraph_should_throw_exception(){
        Document paragraph = new Paragraph("paragraph");
        Document paragraph2 = new Paragraph("paragraph2");
        paragraph.add(paragraph2);
    }

    @Test(expected = DocumentException.class)
    public void test_add_title_to_paragraph_should_throw_exception(){
        Document paragraph = new Paragraph("paragraph");
        Document title = new Title("text", 1);
        paragraph.add(title);
    }

    @Test(expected = DocumentException.class)
    public void test_get_level_should_throw_exception(){
        Document paragraph = new Paragraph("paragraph");
        paragraph.getLevel();
    }

    @Test(expected = DocumentException.class)
    public void est_get_size_should_throw_exception(){
        Document paragraph = new Paragraph("paragraph");
        paragraph.getSize();
    }

    @Test
    public void test_get_text_of_plain_text(){
        Document paragraph = new Paragraph("paragraph");
        assertEquals("paragraph", paragraph.getText());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_paragraph_iterator_should_get_null_iterator(){
        Document paragraph = new Paragraph("paragraph");
        Iterator<Document> it = paragraph.iterator();
        it.hasNext();
    }

    @Test
    public void test_to_string(){
        Document paragraph = new Paragraph("paragraph");
        assertEquals("Paragraph	text: paragraph\n", paragraph.toString());
    }
 }
