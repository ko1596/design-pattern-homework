package org.ntutssl.termfrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyManager implements EventListener {
  private EventManager eventManager;
  private Map<String, Integer> wordFrequencyMap;
  public WordFrequencyManager(EventManager eventManager) {
    this.wordFrequencyMap = new HashMap<>();
    this.eventManager=eventManager;
    this.eventManager.subscribe(EventType.COUNT, this);
    this.eventManager.subscribe(EventType.EOF, this);
   }
  
  public int getNumOfWords() {
    return this.wordFrequencyMap.size();
   }

  public void onEvent(EventType eventType, String event) {
    switch (eventType) {
      case EOF:
        String str = "";
        List<Map.Entry> wordFrequencyEntryList = new ArrayList<>(this.wordFrequencyMap.entrySet());
        List<String> sortedKey = new ArrayList<>();
        Comparator< Map.Entry> sortByValue = (e1,e2)->{ 
          return (Integer.parseInt(String.valueOf(e1.getValue())) - Integer.parseInt(String.valueOf(e2.getValue())));
        };
        Collections.sort(wordFrequencyEntryList, sortByValue);
        for(Map.Entry e : wordFrequencyEntryList)
            sortedKey.add(e.getKey() + ": " + e.getValue()+"\n");
        for(String s : sortedKey)
          str+=s;
        this.eventManager.publish(EventType.OUTPUT, str);

        break;
    
      case COUNT:
        this.wordFrequencyMap.put(event, this.getCount(event)+1);
        break;
      default:
        break;
    }

    
   }
   public Integer getCount(String word){
    return this.wordFrequencyMap.containsKey(word) ? this.wordFrequencyMap.get(word) : 0;
  }
}