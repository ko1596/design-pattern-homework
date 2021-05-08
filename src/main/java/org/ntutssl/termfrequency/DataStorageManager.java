package org.ntutssl.termfrequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataStorageManager implements EventListener {

  private List<String> words;
  private EventManager eventManager;

  public DataStorageManager(EventManager eventManager) {
    words = new ArrayList<>();
    this.eventManager=eventManager;
    this.eventManager.subscribe(EventType.LOAD, this);
    this.eventManager.subscribe(EventType.RUN, this);
   }

  public List<String> getWords() {
    return words;
   }

  public void onEvent(EventType eventType, String event) {
    switch (eventType) {
      case LOAD:
        try(Scanner sc = new Scanner(new File(event), "UTF-8")){
          sc.useDelimiter("[\\W_]+");
          while(sc.hasNext()){
              this.words.add(sc.next().toLowerCase());
          }
        }catch(FileNotFoundException e){
          throw new WordFrequencyException("File not found.");
        }
        break;
    
      case RUN:
        for(String word : this.words){
          this.eventManager.publish(EventType.VALIDATE, word);
        }
        this.eventManager.publish(EventType.EOF, "successfully");
      default:
        break;
    }
   }
}