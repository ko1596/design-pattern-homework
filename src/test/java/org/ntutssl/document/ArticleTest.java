package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class ArticleTest {
    @Test
    public void test_add_high_level_artical(){
        Article article = new Article("aa", 1);
        Article article2 = new Article("bb", 2);
        article.add(article2);
        Iterator<Document> it = article.iterator();
        assertEquals(it.next(), article2);
    }

    @Test(expected = DocumentException.class)
    public void test_add_low_level_artical_should_exception(){
        Article article = new Article("aa", 1);
        article.add(new Article("bb", 0));
    }
 }
