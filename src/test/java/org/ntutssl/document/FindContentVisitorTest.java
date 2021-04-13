package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindContentVisitorTest {
    @Test
    public void test_visit_article(){
        FindContentVisitor fcv = new FindContentVisitor("article");
        Document art = new Article("article", 1);
        fcv.visitArticle((Article) art);
        assertEquals(art, fcv.getResult().get(0));
    }

    @Test
    public void test_visit_article_with_empty_string(){
        FindContentVisitor fcv = new FindContentVisitor("");
        Document art = new Article("", 1);
        fcv.visitArticle((Article) art);
        assertEquals(art, fcv.getResult().get(0));
    }

    @Test
    public void test_visit_paragraph_and_found_paragraph(){
        FindContentVisitor fcv = new FindContentVisitor("text");
        Document par = new Paragraph("text");
        fcv.visitParagraph((Paragraph) par);
        assertEquals(par, fcv.getResult().get(0));
    }

    @Test
    public void test_visit_paragraph_containing_empty_string(){
        FindContentVisitor fcv = new FindContentVisitor("");
        Document par = new Paragraph("");
        fcv.visitParagraph((Paragraph) par);
        assertEquals(par, fcv.getResult().get(0));
    }

    @Test
    public void test_visit_paragraph_without_finding_any_paragraph(){
        FindContentVisitor fcv = new FindContentVisitor("");
        List<Document> testList = new ArrayList<>();
        assertEquals(testList, fcv.getResult());
    }

    @Test
    public void test_visit_title_and_found_title(){
        FindContentVisitor fcv = new FindContentVisitor("text");
        Document title = new Title("text", 1);
        fcv.visitTitle((Title) title);
        assertEquals(title, fcv.getResult().get(0));
    }

    @Test
    public void test_visit_title_containing_empty_string(){
        FindContentVisitor fcv = new FindContentVisitor("");
        Document title = new Title("", 1);
        fcv.visitTitle((Title) title);
        assertEquals(title, fcv.getResult().get(0));
    }

    @Test
    public void test_visit_title_without_finding_any_title(){
        FindContentVisitor fcv = new FindContentVisitor("123");
        List<Document> testList = new ArrayList<>();
        Document title = new Title("aaa", 1);
        fcv.visitTitle((Title) title);
        assertEquals(testList, fcv.getResult());
    }
 }
