package org.ntutssl.document;

public class AddCommandToEditor implements Command {
  /**
   * @param target   the target editor
   * @param document the document to be added
   */
  private Editor target;
  private Document document;
  public AddCommandToEditor(Editor target, Document document) {
    this.target = target;
    this.document = document;
  }

  public void execute() {
    target.add(document);
  }

  public void undo() {
    target.remove(document);
  }

  public void redo() {
  }
}
