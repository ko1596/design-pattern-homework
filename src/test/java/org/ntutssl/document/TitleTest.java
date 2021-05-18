package org.ntutssl.document;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
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

    @Test
    public void test_toString(){
        Title title = new Title("aaa", 1);
        String string = title.toString();
        assertEquals(string, "Title\t\ttext: aaa\n\t\tsize: 1\n");
    }

    @Test(expected = DocumentException.class)
    public void test_getLevels_should_exception(){
        Title title = new Title("text", 1);
        title.getLevel();
    }

    @Test(expected = DocumentException.class)
    public void test_addtitle_should_exception(){
        Title title = new Title("text", 1);
        title.add(new Title("text", 1));
    }

    @Test(expected = DocumentException.class)
    public void test_addParagraph_should_exception(){
        Title title = new Title("text", 1);
        title.add(new Paragraph("text"));
    }

    @Test(expected = DocumentException.class)
    public void test_addArticle_should_exception(){
        Title title = new Title("text", 1);
        title.add(new Article("text", 1));
    }

    @Test(expected = NoSuchElementException.class)
    public void test_Iterator_should_exception(){
        Title title = new Title("Test", 1);
        title.iterator();
    }


 }