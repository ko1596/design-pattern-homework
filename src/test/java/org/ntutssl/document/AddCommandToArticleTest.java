package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AddCommandToArticleTest {
    @Test
    public void test_execute(){
        Article article = new Article("good", 0);
        Paragraph paragraph = new Paragraph("text");
        AddCommandToArticle commandToArticle = new AddCommandToArticle(article, paragraph);
        commandToArticle.execute();
        assertEquals(paragraph, article.iterator().next());
    }

    @Test
    public void test_undo(){
        Article article = new Article("good", 0);
        Paragraph paragraph = new Paragraph("text");
        AddCommandToArticle commandToArticle = new AddCommandToArticle(article, paragraph);
        commandToArticle.execute();
        commandToArticle.undo();
        assertFalse(article.iterator().hasNext());
    }

    @Test
    public void test_redo(){
        Article article = new Article("good", 0);
        Paragraph paragraph = new Paragraph("text");
        AddCommandToArticle commandToArticle = new AddCommandToArticle(article, paragraph);
        commandToArticle.execute();
        commandToArticle.redo();
        assertEquals(paragraph,article.iterator().next());
    }
}
