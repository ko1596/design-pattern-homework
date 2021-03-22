package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArticleTest {
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void test_add_an_article_with_higher_level_into_article(){
        Document article = new Article("abc",3);
        Document article_high = new Article("cbd",4);
        article.add(article_high);
        assertEquals("cbd", article.getContent(0).getText());
    }

    @Test
    public void test_add_an_article_with_lower_level_into_article(){
        Document article = new Article("abc",3);
        Document article_low = new Article("abc",2);
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: add an article with lower level into article");
        article.add(article_low);
    }

    @Test
    public void test_get_text_of_article(){
        Document article = new Article("abc",3);
        assertEquals("abc", article.getText());
    }
    @Test
    public void test_get_level_of_article(){
        Document article = new Article("abc",3);
        assertEquals(3, article.getLevel());
    }

    @Test
    public void test_get_text_after_add_another_document(){
        Document article = new Article("abc",3);
        Document title = new Title("abc");
        Document paragraph = new Paragraph("aaa");
        article.add(title);
        article.add(paragraph);
        assertEquals("abc", article.getText());
    }
  }
