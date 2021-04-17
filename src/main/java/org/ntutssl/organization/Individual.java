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
    return isInHouse;
  }

  public String toString(int indentCount) {
    return "aa";
  }

  public <T> void accept(Visitor<T> visitor) {
    visitor.visitIndividual(this);
  }

  @Override
  public int getSalary() {
    return salary;
  }
}