package org.ntutssl.organization;

import java.util.Iterator;

public class ListVisitor implements Visitor<String> {
  private String result;

  public ListVisitor() {
    this.result = "";
  }

  public void visitTeam(Team team) {
    result += team.toString();
    Iterator<Workforce> it = team.iterator();
    while(it.hasNext()){
      it.next().accept(this);
    }
  }

  public void visitIndividual(Individual individual) {
    result += individual.toString();
  }

  public String getResult() {
    return this.result;
  }
}