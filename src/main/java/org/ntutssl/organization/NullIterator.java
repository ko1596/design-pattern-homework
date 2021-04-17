package org.ntutssl.organization;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullIterator implements Iterator<Workforce>{
  public boolean hasNext() {
    return false;
  }

  public Workforce next() {
    throw new NoSuchElementException("Do not have element.");
  }
}
