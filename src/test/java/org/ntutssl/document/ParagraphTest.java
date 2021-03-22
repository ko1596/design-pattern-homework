package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParagraphTest {
    @Test
    public void test_for_content(){
        Document title = new Paragraph("abc");
        assertEquals("abc", title.getText());
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void test_add_article_to_paragraph_should_throw_exception(){
        Document paragraph = new Paragraph("aaa");
        Document article = new Article("aaa",3);
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: add");
        paragraph.add(article);
    }
    @Test
    public void test_add_title_to_paragraph_should_throw_exception(){
        Document title = new Title("abc");
        Document paragraph = new Paragraph("aaa");
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: add");
        paragraph.add(title);
    }

    @Test
    public void test_add_paragraph_to_paragraph_should_throw_exception(){
        Document paragraph = new Paragraph("abc");
        Document paragraph2 = new Paragraph("aaa");
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: add");
        paragraph.add(paragraph2);
    }

    @Test
    public void test_get_content_should_throw_exception(){
        Document paragraph = new Paragraph("abc");
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: getContent");
        paragraph.getContent(3);
    }
    @Test
    public void test_get_level_should_throw_exception(){
        Document paragraph = new Paragraph("abc");
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: getLevel");
        paragraph.getLevel();
    }
}
