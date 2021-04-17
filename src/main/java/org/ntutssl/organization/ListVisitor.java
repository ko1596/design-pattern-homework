package org.ntutssl.organization;

import java.util.Iterator;

public class ListVisitor implements Visitor<String> {
  private String result;
  private int countTeam;
  public ListVisitor() {
    this.result = "";
  }

  public void visitTeam(Team team) {
    countTeam++;
    result += team.toString((countTeam-1)*2);
    Iterator<Workforce> it = team.iterator();
    while(it.hasNext()){
      it.next().accept(this);
    }
    countTeam--;
    
  }

  public void visitIndividual(Individual individual) {
    result += individual.toString(countTeam*2);
  }

  public String getResult() {
    return this.result;
  }
}