package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TitleTest { 
    @Test
    public void test_for_content(){
        Document title = new Title("abc");
        assertEquals("abc", title.getText());
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void test_add_article_to_title_should_throw_exception(){
        Document title = new Title("abc");
        Document article = new Article("aaa",3);
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: add");
        title.add(article);
    }
    @Test
    public void test_add_paragraph_to_title_should_throw_exception(){
        Document title = new Title("abc");
        Document paragraph = new Paragraph("aaa");
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: add");
        title.add(paragraph);
    }

    @Test
    public void test_add_title_to_title_should_throw_exception(){
        Document title = new Title("abc");
        Document title2 = new Title("aaa");
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: add");
        title.add(title2);
    }

    @Test
    public void test_get_content_should_throw_exception(){
        Document title = new Title("abc");
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: getContent");
        title.getContent(3);
    }
    @Test
    public void test_get_level_should_throw_exception(){
        Document title = new Title("abc");
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: getLevel");
        title.getLevel();
    }
 }
