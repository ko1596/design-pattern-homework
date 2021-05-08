package org.ntutssl.termfrequency;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopWordManager implements EventListener {

  private List<String> stopWord;
  private EventManager eventManager;
  public StopWordManager(EventManager eventManager) {
    stopWord = new ArrayList<>();
    this.eventManager = eventManager;
    this.eventManager.subscribe(EventType.LOAD, this);
    this.eventManager.subscribe(EventType.VALIDATE, this);
   }

  public List<String> getStopWords() {
    return stopWord;
   }

  public void onEvent(EventType eventType, String event) {
    switch (eventType) {
      case LOAD:
        try(Scanner sc = new Scanner(new File("input/stop_words.txt"))){
          sc.useDelimiter(",");
          while(sc.hasNext()){
            stopWord.add(sc.next().toLowerCase());
          }
        }catch(IOException e){
            throw new WordFrequencyException("File not found.");
        }
        for(int i = 98;i<123;i++){
          if(i!=105) stopWord.add(Character.toString((char)i));
        }
        break;
      
      case VALIDATE:
        if(!stopWord.contains(event))
          eventManager.publish(EventType.COUNT, event);
        break;

      default:
        break;
    }
  }
}