package org.ntutssl.document;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArticleTest {

    @Test
    public void test_accept_visitor(){
        FindContentVisitor fcv = new FindContentVisitor("article");
        Document art = new Article("article", 1);
        fcv.visitArticle((Article) art);
        System.out.println(fcv.getResult());
        assertEquals(art, fcv.getResult().get(0));
    }

    @Test
    public void test_add_an_article_with_higher_level_into_article(){
        Document article = new Article("abc",3);
        Document article_high = new Article("abc",4);
        article.add(article_high);
        assertEquals("cbd", article.getContent(0).getText());
    }

    @Test(expected = DocumentException.class)
    public void test_add_an_article_with_lower_level_into_article(){
        Document article = new Article("abc",3);
        Document article_low = new Article("abc",2);
        article.add(article_low);
    }

    @Test(expected = DocumentException.class)
    public void test_add_an_article_with_same_level_into_article(){
        Document article = new Article("abc",3);
        Document article_low = new Article("abc",3);
        article.add(article_low);
    }
 }
