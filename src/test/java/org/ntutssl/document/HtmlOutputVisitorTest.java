package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HtmlOutputVisitorTest {
    @Test
    public void test_visit_article_containing_another_article(){
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document art = new Article("article", 1);
        Document inart = new Article("in article", 2);
        art.add(inart);
        hov.visitArticle((Article) art);
        assertEquals("<article topic='" + art.getText() + "'>\n  <article topic='" + inart.getText() + "'>\n  </article>\n</article>\n", hov.getResult());
    }

    @Test
    public void test_visit_article_with_some_title_and_paragraph(){
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document art = new Article("article", 1);
        Document title = new Title("text", 1);
        Document paragraph = new Paragraph("text");
        art.add(title);
        art.add(paragraph);
        hov.visitArticle((Article) art);
        assertEquals("<article topic='" + art.getText() + "'>\n  <h1>text</h1>\n  <p>text</p>\n</article>\n", hov.getResult());
    }

    @Test
    public void test_visit_empty_article(){
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document art = new Article("article", 1);
        hov.visitArticle((Article) art);
        assertEquals("<article topic='" + art.getText() + "'>\n</article>\n", hov.getResult());
    }

    @Test
    public void test_visit_h1_title(){
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document title = new Title("titleH1", 1);
        hov.visitTitle((Title)title);
        assertEquals("<h1>titleH1</h1>\n", hov.getResult());
    }

    @Test
    public void test_visit_h2_title(){
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document title = new Title("titleH1", 2);
        hov.visitTitle((Title)title);
        assertEquals("<h2>titleH1</h2>\n", hov.getResult());
    }

    @Test
    public void test_visit_paragraph(){
        HtmlOutputVisitor hov = new HtmlOutputVisitor();
        Document paragraph = new Paragraph("paragraph");
        hov.visitParagraph((Paragraph)paragraph);
        assertEquals("<p>paragraph</p>\n", hov.getResult());
    }
 }
