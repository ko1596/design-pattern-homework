package org.ntutssl.organization;

public interface Visitor<T> {
  public void visitTeam(Team team);
  public void visitIndividual(Individual individual);
  public T getResult();
}