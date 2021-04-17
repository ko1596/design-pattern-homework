package org.ntutssl.organization;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullIterator implements Iterator<Workforce>{
  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Workforce next() {
    throw new NoSuchElementException("Do not have element.");
  }
}
