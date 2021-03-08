package org.ntutssl.termfrequency;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WordFrequencyController{
    public static void main(String[] args){
        StopWordManager swm = new StopWordManager(args[0]);
        DataStorageManager dsm = new DataStorageManager(args[1]);
        WordFrequencyManager wfm = new WordFrequencyManager();
        Integer range = Integer.parseInt(args[2]);
        String order = args[3];
        LinkedHashMap<String, Integer> orderWord=null;

        for (String word : dsm.getWords()){
            if(!swm.isStopWordList(word)) wfm.incrementCount(word);
        }
        
        switch (order) {
            case "asc":
                orderWord = new LinkedHashMap<>(wfm.getWordFrequencyAscending());
                break;
            
            case "des":
                orderWord = new LinkedHashMap<>(wfm.getWordFrequencyDescending());
                break;

            default:
                break;
        }
        int count=0;
        for (Map.Entry<String, Integer> ent : orderWord.entrySet()){
            if(count<range){
                System.out.println(ent.getKey() + ": " + ent.getValue());
                count++;
            }
            else break;
        }
     }
}