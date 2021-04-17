package org.ntutssl.organization;

import java.time.LocalDate;


public class Individual implements Workforce {

  private String name;
  private int salary;
  private LocalDate startDate;
  private boolean isInHouse;

  public Individual(
    String name, 
    int salary, 
    LocalDate startDate, 
    boolean isInHouse
  ) {
    this.name = name;
    this.salary = salary;
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
    return this.isInHouse;
  }

  public String toString(int indentCount) {
    String buffer = "";
    for (int i = 0; i < indentCount;i++){
      buffer += " ";
    }
    buffer += "Type:\tIndividual ";
    if(isInHouse()) buffer += "(in-house)\n";
    else buffer += "(not in-house)\n";
    buffer += "Name:\t" + getName() + "\n";
    buffer += "Salary:\t" + getSalary() + "\n";
    buffer += "Start date:\t" + getStartDate().toString() + "\n";
    return buffer;
  }

  public <T> void accept(Visitor<T> visitor) {
    visitor.visitIndividual(this);
  }

  @Override
  public int getSalary() {
    return salary;
  }
}