package org.ntutssl.organization;

import java.util.Iterator;

public class ListVisitor implements Visitor<String> {
  private String result;

  public ListVisitor() {
    this.result = "";
  }

  public void visitTeam(Team team) {
    result += team.toString(0);
    // Iterator<Workforce> it = team.iterator();
    // while(it.hasNext()){
    //   it.next().accept(this);
    // }
  }

  public void visitIndividual(Individual individual) {
    result += individual.toString(0);
  }

  public String getResult() {
    return this.result;
  }
}