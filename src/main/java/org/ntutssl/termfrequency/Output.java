package org.ntutssl.termfrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Output implements EventListener {
  private EventManager eventManager;
  private Map<String, Object> wordFrequencyMap;
  private String order;
  private int range;
  
  public Output(EventManager eventManager, int range, String order) {
    this.wordFrequencyMap = new HashMap<>();
    this.eventManager=eventManager;
    this.eventManager.subscribe(EventType.OUTPUT, this);
    this.order=order;
    this.range=range;
  }

  public void onEvent(EventType eventType, String event) {
    if(eventType==EventType.OUTPUT){
      for(String s : event.split("\n")){
        String key = s.split(":")[0];
        Integer value = Integer.valueOf(s.split(": ")[1]);
        this.wordFrequencyMap.put(key, value);
      }
      if(this.wordFrequencyMap.isEmpty()) 
        throw new WordFrequencyException("Word not found.");

      List<String> outputList = this.sort(this.wordFrequencyMap, this.order);
      
      if(range < 1)
       throw new WordFrequencyException("Out of range!");
      
      try{
        outputList=outputList.subList(0, range);
      }catch(IndexOutOfBoundsException e){
        throw new WordFrequencyException("Out of range!");
      }

      for(String word : outputList)
        System.out.println(word);
    }
   }

   private List<String> sort(Map<String, Object> wordFrequencyMap, String order){
    List<Map.Entry> wordFrequencyEntryList = new ArrayList<>(this.wordFrequencyMap.entrySet());
        List<String> sortedKey = new ArrayList<>();
        Comparator< Map.Entry> sortByValue = (e1,e2)->{ 
            if(order.equals("des")) 
              return (Integer.parseInt(String.valueOf(e2.getValue())) - Integer.parseInt(String.valueOf(e1.getValue())));
            else if(order.equals("asc"))  
              return (Integer.parseInt(String.valueOf(e1.getValue())) - Integer.parseInt(String.valueOf(e2.getValue())));
            else 
              throw new WordFrequencyException("The order should be asc or des.");
        };
        Collections.sort(wordFrequencyEntryList, sortByValue);
        for(Map.Entry e : wordFrequencyEntryList)
            sortedKey.add(e.getKey() + ": " + e.getValue()+"\n");
        return sortedKey;
  }
}
