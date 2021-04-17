package org.ntutssl.organization;

import java.util.List;
import java.util.function.Function;

public class FindVisitor implements Visitor{
  
  private List<Workforce> workforces;
  private Function<Workforce, Boolean> condition;
  private String orderBy;

  public FindVisitor(Function<Workforce, Boolean> condition, String orderBy) {
    this.condition = condition;
    this.orderBy = orderBy;
  }

  public void visitTeam(Team team) {
   
  }

  public void visitIndividual(Individual individual) {
    
  }

  public List<Workforce> getResult() {
    return workforces;
  }
}
