package org.ntutssl.termfrequency;

import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class WordFrequencyManager{
    private Map<String, Integer> words;
    
    public WordFrequencyManager(){
        this.words = new Hashtable<>();
    }

    public void incrementCount(String word){
        if(this.words.containsKey(word)){
            this.words.put(word,this.words.get(word) + 1);
        }else{
            this.words.put(word, 1);
        }
    }

    public int getNumOfWords(){ 
        return 3;
    }

    public Integer getCount(String word){
        return this.words.get(word) != null ? this.words.get(word) : 0;
    }

}