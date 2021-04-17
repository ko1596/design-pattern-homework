package org.ntutssl.organization;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Workforce {
    public String getName();
  
    public LocalDate getStartDate();
  
    public boolean isInHouse();
  
    public String toString(int indentCount);
  
    public <T> void accept(Visitor<T> visitor);
  
    public default void add(Workforce employee) {
        throw new OrganizationException("Invalid action: add");
    }
  
    public default Iterator<Workforce> iterator() {
        throw new NoSuchElementException("Invalid action: Iterator is null");
    }
  
    public default int getSize() {
        throw new OrganizationException("Invalid action: add");
    }
    public default int getSalary() {
        throw new OrganizationException("Invalid action: add");
    }
 }