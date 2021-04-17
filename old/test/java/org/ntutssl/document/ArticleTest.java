package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

public class ArticleTest {

    @Test
    public void test_accept_visitor(){
        FindContentVisitor fcv = new FindContentVisitor("article");
        Document art = new Article("article", 1);
        fcv.visitArticle((Article) art);
        assertEquals(art, fcv.getResult().get(0));
    }

    @Test
    public void test_add_an_article_with_higher_level_into_article(){
        Document article = new Article("abc",3);
        Document article_high = new Article("test",4);
        article.add(article_high);
        Iterator<Document> it = article.iterator();
        while(it.hasNext()) assertEquals(article_high, it.next()); 
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

    @Test
    public void test_get_inner_document_text_after_add_some_documents(){
        Document article = new Article("main",3);
        Document article_test = new Article("test",4);
        article.add(article_test);
        Iterator<Document> it = article.iterator();
        while(it.hasNext()) assertEquals("test", it.next().getText()); 
    }

    @Test
    public void test_get_level_of_article(){
        Document article = new Article("main",3);
        assertEquals(3, article.getLevel()); 
    }

    @Test(expected = DocumentException.class)
    public void test_get_size_should_throw_exception(){
        Document article = new Article("abc",3);
        article.getSize();
    }

    @Test
    public void test_get_text_after_add_another_document(){
        Document article = new Article("main",3);
        Document article_test = new Article("test",4);
        article.add(article_test);
        assertEquals("main", article.getText());
    }

    @Test
    public void test_get_text_of_article(){
        Document article = new Article("main",3);
        assertEquals("main", article.getText());
    }

    @Test
    public void test_to_string(){
        Document article = new Article("main",3);
        assertEquals("Article\t\ttopic: main\n\t\tlevel: 3\n", article.toString());
    }
 }
