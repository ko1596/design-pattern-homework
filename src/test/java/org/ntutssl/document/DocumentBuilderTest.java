package org.ntutssl.document;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Iterator;
public class DocumentBuilderTest {
    
    @Test
    public void test_build_complex_article(){
        Article article = new Article("Test", 1);
        DocumentBuilder db = new DocumentBuilder();
        db = db.startBuildArticle("Article", 0);
        db = db.buildParagraph("Paragraph");
        db = db.startBuildArticle("Article2", 1);
        db = db.buildTitle("Title",1);
        db = db.endBuildArticle();
        db = db.endBuildArticle();
        Iterator<Document> it = db.getResult().iterator();
        assertEquals(db.getResult().getText(), "Article");
        assertEquals(db.getResult().getLevel(), 0);
        Paragraph innerParagraph = (Paragraph) it.next();
        assertEquals(db.getResult().iterator().next().getText(), "Paragraph");
        Article innerArticle = (Article) it.next();
        assertEquals(innerArticle.getText(), "Article2");
        assertEquals(innerArticle.getLevel(), 1);
        Title innerTitle = (Title) innerArticle.iterator().next();
        assertEquals(innerTitle.getText(),"Title");
        assertEquals(innerTitle.getSize(),1);
    }

    @Test
    public void test_build_paragraph(){
        DocumentBuilder db = new DocumentBuilder();
        db = db.buildParagraph("Paragraph");
        assertEquals(db.getResult().getText(), "Paragraph");
    }

    @Test
    public void test_build_simple_article(){
        DocumentBuilder db = new DocumentBuilder();
        db = db.startBuildArticle("Article", 0);
        db = db.buildParagraph("Paragraph");
        db = db.endBuildArticle();
        Article articleTest = new Article("Article", 0);
        articleTest.add(new Paragraph("Paragraph"));
        assertEquals(db.getResult().getText(), "Article");
        assertEquals(db.getResult().getLevel(), 0);
        Iterator<Document> it = db.getResult().iterator();
        Paragraph innerParagraph =(Paragraph) it.next();
        assertEquals(innerParagraph.getText(), "Paragraph");
    }

    @Test
    public void test_build_title(){
        DocumentBuilder db = new DocumentBuilder();
        db = db.buildTitle("Title",1);
        assertEquals(db.getResult().getText(), "Title");
        assertEquals(db.getResult().getSize(), 1);
    }

    @Test
    public void test_build_article(){
        DocumentBuilder db = new DocumentBuilder();
        db = db.startBuildArticle("Article", 0);
        db = db.endBuildArticle();
        assertEquals("Article", db.getResult().getText());
    }

 }