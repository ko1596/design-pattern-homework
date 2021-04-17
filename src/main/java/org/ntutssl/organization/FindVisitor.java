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
   condition.apply(team);
   if(true){
     if(orderBy.equals("ASC")){
       workforces.add(team);
     }else{
       workforces.add(team);
     }
   }
  }

  public void visitIndividual(Individual individual) {
    condition.apply(individual);
    if(true){
      if(orderBy.equals("ASC")){
        workforces.add(individual);
      }else{
        workforces.add(individual);
      }
    }
  }

  public List<Workforce> getResult() {
    return workforces;
  }
}
