package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AddCommandToEditorTest {
    @Test
    public void test_execute(){
        Editor editor = new Editor();
        Paragraph paragraph = new Paragraph("text");
        AddCommandToEditor commandToArticle = new AddCommandToEditor(editor, paragraph);
        commandToArticle.execute();
        assertEquals(paragraph, editor.iterator().next());
    }

    @Test
    public void test_undo(){
        Editor editor = new Editor();
        Paragraph paragraph = new Paragraph("text");
        AddCommandToEditor commandToArticle = new AddCommandToEditor(editor, paragraph);
        commandToArticle.execute();
        commandToArticle.undo();
        assertFalse(editor.iterator().hasNext());
    }

    @Test
    public void test_redo(){
        Editor editor = new Editor();
        Paragraph paragraph = new Paragraph("text");
        AddCommandToEditor commandToArticle = new AddCommandToEditor(editor, paragraph);
        commandToArticle.execute();
        commandToArticle.undo();
        commandToArticle.redo();
        assertEquals(paragraph,editor.iterator().next());
    }
}