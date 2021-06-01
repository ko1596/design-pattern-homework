package org.ntutssl.shop;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullIterator implements Iterator<Goods> {
  
  @Override
  public Goods next() {
    throw new NoSuchElementException("NoSuchElementException");
   }

  @Override
  public boolean hasNext() {
    return false;
   }
}
