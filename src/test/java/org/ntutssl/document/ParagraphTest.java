package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.NoSuchElementException;

public class ParagraphTest {
    @Test
    public void test_getText(){
        Paragraph paragraph = new Paragraph("aa");
        assertEquals("aa", paragraph.getText());
    }

    @Test(expected = DocumentException.class)
    public void test_getSize_should_exception(){
        Paragraph paragraph = new Paragraph("aa");
        paragraph.getSize();
    }

    @Test
    public void test_toString(){
        Paragraph paragraph = new Paragraph("aaa");
        String string = paragraph.toString();
        assertEquals(string, "Paragraph\ttext: aaa\n");
    }

    @Test(expected = DocumentException.class)
    public void test_getLevels_should_exception(){
        Paragraph paragraph = new Paragraph("text");
        paragraph.getLevel();
    }

    @Test(expected = DocumentException.class)
    public void test_addtitle_should_exception(){
        Paragraph paragraph = new Paragraph("text");
        paragraph.add(new Title("text", 1));
    }

    @Test(expected = DocumentException.class)
    public void test_addParagraph_should_exception(){
        Paragraph paragraph = new Paragraph("text");
        paragraph.add(new Paragraph("text"));
    }

    @Test(expected = DocumentException.class)
    public void test_addArticle_should_exception(){
        Paragraph paragraph = new Paragraph("text");
        paragraph.add(new Article("text", 1));
    }

    @Test(expected = NoSuchElementException.class)
    public void test_Iterator_should_exception(){
        Paragraph paragraph = new Paragraph("Test");
        paragraph.iterator();
    }
 }