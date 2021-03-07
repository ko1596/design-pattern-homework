package org.ntutssl.termfrequency;


import java.util.List;
import java.util.ArrayList;


public class StopWordManager{
    private List<String> stopWords;

    public StopWordManager(){
        this.stopWords = new ArrayList<>();
        this.stopWords.add("the");
     }

     public boolean isStopWord(String word){
         return this.stopWords.contains(word);
     }


}