package org.ntutssl.document;

import static org.junit.Assert.assertFalse;

import java.util.NoSuchElementException;

import org.junit.Test;

public class NullIteratorTest {

    @Test
    public void hasNextIswork(){
        assertFalse(new NullIterator().hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyIteratorUseNextShouldThrowException(){
        new NullIterator().next();
    }
 }