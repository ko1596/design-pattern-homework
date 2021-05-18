package org.ntutssl.document;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class HtmlOutputConsumerTest {

    @Test
    public void test_accept_empty_article(){
        List<String> result = new ArrayList();
        HtmlOutputConsumer hoc = new HtmlOutputConsumer(result);
        Article article = new Article("Article", 1);

        hoc.accept(article);
        assertEquals(result.get(0),"<article topic='Article'>\n");
    }
    
    @Test
    public void test_accept_h1_title(){
        List<String> result = new ArrayList();
        HtmlOutputConsumer hoc = new HtmlOutputConsumer(result);
        Title title = new Title("Title", 1);

        hoc.accept(title);
        assertEquals(result.get(0),"<h1>Title</h1>\n");
    }

    @Test
    public void test_accept_h2_title(){
        List<String> result = new ArrayList();
        HtmlOutputConsumer hoc = new HtmlOutputConsumer(result);
        Title title = new Title("Title", 2);

        hoc.accept(title);
        assertEquals(result.get(0),"<h2>Title</h2>\n");
    }

    @Test
    public void test_accept_paragraph(){
        List<String> result = new ArrayList();
        HtmlOutputConsumer hoc = new HtmlOutputConsumer(result);
        Paragraph paragraph = new Paragraph("Paragraph");
        
        hoc.accept(paragraph);
        assertEquals(result.get(0),"<p>Paragraph</p>\n");
    }

    @Test
    public void test_visit_article_containing_another_article(){
        List<String> result = new ArrayList();
        HtmlOutputConsumer hoc = new HtmlOutputConsumer(result);
        Article article = new Article("Article", 1);
        Article innerArticle = new Article("Article2", 2);
        Title title = new Title("Title",1);
        innerArticle.add(title);
        article.add(innerArticle);
        hoc.accept(article);
        assertEquals(result.get(0),"<article topic='Article'>\n");
        assertEquals(result.get(1),"  <article topic='Article2'>\n");
        assertEquals(result.get(2),"    <h1>Title</h1>\n");
        assertEquals(result.get(3),"  </article>\n");
        assertEquals(result.get(4),"</article>\n");
    }

    @Test
    public void test_visit_article_with_some_title_and_paragraph(){
        List<String> result = new ArrayList();
        HtmlOutputConsumer hoc = new HtmlOutputConsumer(result);
        Article article = new Article("Article", 1);
        Title title = new Title("Title",1);
        Paragraph paragraph = new Paragraph("Paragraph");
        Title title2 = new Title("Title2",2);
        article.add(title);
        article.add(paragraph);
        article.add(title2);
        hoc.accept(article);
        assertEquals(result.get(0),"<article topic='Article'>\n");
        assertEquals(result.get(1),"  <h1>Title</h1>\n");
        assertEquals(result.get(2),"  <p>Paragraph</p>\n");
        assertEquals(result.get(3),"  <h2>Title2</h2>\n");
        assertEquals(result.get(4),"</article>\n");
    }
 }