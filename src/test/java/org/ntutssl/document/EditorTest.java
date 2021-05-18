package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import org.junit.Test;

public class EditorTest {
    public void test_add_documents_to_editor(){
        Editor editor = new Editor();
        Paragraph paragraph =  new Paragraph("test");
        editor.add(paragraph);
        
        Iterator<Document> it = editor.iterator();
        assertEquals(it.next(), paragraph);
    }
    
    @Test
    public void test_iterator_does_not_have_next_in_the_beginning(){
        Editor editor = new Editor();
        Iterator<Document> it = editor.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void test_find_content_should_print(){
        Editor editor = new Editor();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        editor.add(new Title("Test", 1));
        editor.add(new Paragraph("Test1"));
        editor.add(new Title("Not",2));
        editor.findContent("Test");
        assertEquals("Title\t\ttext: Test\n\t\tsize: 1\nParagraph\ttext: Test1\n",stream.toString());
        System.setOut(originalOut);
    }

    @Test
    public void test_size_of_editor(){
        Editor editor = new Editor();
        Paragraph paragraph =  new Paragraph("test");
        editor.add(paragraph);
        assertEquals(editor.size(),1);
    }

    @Test
    public void test_import_document_from_file(){
        Editor editor = new Editor();
        editor.importDocumentFromJsonFile("input/test_input.json");
        Iterator<Document> it = editor.iterator();
        Title title = (Title) it.next();
        Paragraph paragraph = (Paragraph) it.next();
        Article article = (Article) it.next();
        it = article.iterator();
        Title innerTitle = (Title) it.next();
        Paragraph innerParagraph = (Paragraph) it.next();
        assertEquals(title.getClass(),Title.class);
        assertEquals(title.getText(),"I'm a simple title");
    }
 }