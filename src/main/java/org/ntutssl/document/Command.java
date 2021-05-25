package org.ntutssl.document;

public interface Command {
  // you don't need to modify this interface
  public void execute();
  public void undo();
  public void redo();
}
