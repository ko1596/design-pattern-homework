package org.ntutssl.document;

import java.util.Stack;

public class CommandManager {

  private Stack<Command> usedCommands;
  private Stack<Command> undoCommands;

  public CommandManager() { 
    usedCommands = new Stack<>();
    undoCommands = new Stack<>();
  }

  public void executeCmd(Command cmd) {
    cmd.execute();
    usedCommands.push(cmd);
  }
  
  public void undoCmd() {
    if (!usedCommands.isEmpty()){
      undoCommands.push(usedCommands.peek());
      usedCommands.pop().undo();
    }else{
      throw new DocumentException("No command can be undid.");
    }
  }

  public void redoCmd() {
    if (!undoCommands.isEmpty()){
      usedCommands.push(undoCommands.peek());
      undoCommands.pop().redo();
    }else{
      throw new DocumentException("No command can be redid.");
    }
  }
}
