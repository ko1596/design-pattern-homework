package org.ntutssl.document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Editor {  

  private List<Document> allEditor;

  public Editor() {
    this.allEditor = new ArrayList<>();
  }

  public void add(Document document) {
    this.editor.add(document);
  }

  public int size() {
    return this.allEditor.size();
  }

  public Iterator<Document> iterator() {
    return this.allEditor.iterator();
  }
}
