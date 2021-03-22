package org.ntutssl.document;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TitleTest { 
    @Test
    public void test_for_content(){
        Document title = new Title("abc");
        assertEquals("abc", title.getText());
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void test_for_err(){
        Document title = new Title("abc");
        expected.expect(DocumentException.class);
        expected.expectMessage("Invalid action: add");
        title.add(title);

    }
 }
