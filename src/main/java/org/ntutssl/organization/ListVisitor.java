package org.ntutssl.organization;

import java.util.List;

public class ListVisitor implements Visitor<String> {

  private List<Workforce> workforce;

  public ListVisitor() {

  }

  public void visitTeam(Team team) {

  }

  public void visitIndividual(Individual individual) {

  }

  public String getResult() {
    return "workforce";
  }
}