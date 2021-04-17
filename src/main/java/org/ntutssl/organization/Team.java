package org.ntutssl.organization;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Team implements Workforce {

  private String name;
  private LocalDate startDate;
  private boolean isInHouse;
  private List<Workforce> workforce;

  public Team(String name, LocalDate startDate, boolean isInHouse) {
    this.name = name;
    this.startDate = startDate;
    this.isInHouse = isInHouse;
  }

  public String getName() {
    return name;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public boolean isInHouse() {
    return isInHouse;
  }

  public String toString(int indentCount) {
    String buffer = "";
    for (int i = 0; i < indentCount;i++){
      buffer += " ";
    }
    buffer += "Type:\tTeam ";
    if(isInHouse()) buffer += "(in-house)\n";
    else buffer += "(outsourcing)\n";
    for (int i = 0; i < indentCount;i++){
      buffer += " ";
    }
    buffer += "Name:\t" + getName() + "\n";
    for (int i = 0; i < indentCount;i++){
      buffer += " ";
    }
    buffer += "Start date:\t" + getStartDate().toString() + "\n";
    return buffer;
  }

  public <T> void accept(Visitor<T> visitor) {
    visitor.visitTeam(this);
  }

  @Override
  public void add(Workforce employee) {
    workforce.add(employee);
  }

  @Override
  public Iterator<Workforce> iterator() {
    return workforce.iterator();
  }

  @Override
  public int getSize() {
    return workforce.size();
  }
}