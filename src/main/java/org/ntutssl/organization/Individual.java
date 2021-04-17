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
    if(salary<24000) {
      throw new OrganizationException("Your salary is set too low.");
    }
    if(name.equals("")){
      throw new OrganizationException("Your name is empty.");
    }
    if(name.equals("[\\W_]+")){
      throw new OrganizationException("Your name is contain number or non-word.");
    }
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
    for (int i = 0; i < indentCount;i++){
      buffer += " ";
    }
    buffer += "Name:\t" + getName() + "\n";
    for (int i = 0; i < indentCount;i++){
      buffer += " ";
    }
    buffer += "Salary:\t" + getSalary() + "\n";
    for (int i = 0; i < indentCount;i++){
      buffer += " ";
    }
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