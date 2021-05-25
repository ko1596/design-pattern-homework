package org.ntutssl.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CommandManagerTest {
    @Test
    public void test_execute_command(){
        CommandManager manager = new CommandManager();
        Editor editor = new Editor();
        Paragraph paragraph = new Paragraph("text");
        AddCommandToEditor command = new AddCommandToEditor(editor,paragraph);
        manager.executeCmd(command);
        assertEquals(paragraph,editor.iterator().next());
    }
    @Test
    public void test_redo_command(){
        CommandManager manager = new CommandManager();
        Editor editor = new Editor();
        Paragraph paragraph = new Paragraph("text");
        AddCommandToEditor command = new AddCommandToEditor(editor,paragraph);
        manager.executeCmd(command);
        manager.undoCmd();
        manager.redoCmd();
        assertEquals(paragraph,editor.iterator().next());
    }
    @Test
    public void test_undo_command(){
        CommandManager manager = new CommandManager();
        Editor editor = new Editor();
        Title title = new Title("aa",1);
        Title title2 = new Title("bb",2);
        AddCommandToEditor command1 = new AddCommandToEditor(editor,title);
        AddCommandToEditor command2 = new AddCommandToEditor(editor,title2);
        manager.executeCmd(command1);
        manager.executeCmd(command2);
        manager.undoCmd();
        manager.undoCmd();
        assertFalse(editor.iterator().hasNext());
    }

    @Test(expected = DocumentException.class)
    public void test_undoo_no_command(){
        CommandManager manager = new CommandManager();
        manager.undoCmd();
    }
    @Test(expected = DocumentException.class)
    public void test_redo_no_command(){
        CommandManager manager = new CommandManager();
        manager.redoCmd();
    }
}