package org.ntutssl.termfrequency;

public class Main {
  
  public static void main(String[] args) {
    String dataPath= args[0];
    int range= Integer.parseInt(args[1]);
    String sortOrder= args[2];

    EventManager eventManager = new EventManager();
    DataStorageManager dsm = new DataStorageManager(eventManager);
    StopWordManager swm = new StopWordManager(eventManager);
    WordFrequencyManager wfm = new WordFrequencyManager(eventManager);
    WordFrequencyController wfc = new WordFrequencyController(eventManager);
    Output output = new Output(eventManager, range, sortOrder);
    
    eventManager.publish(EventType.START, dataPath);
   }
}