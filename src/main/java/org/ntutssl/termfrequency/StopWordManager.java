package org.ntutssl.termfrequency;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class StopWordManager{
    private List<String> stopWordsList;
    private Set<String> stopWordsSet;
    private String nextStopWord;

    public StopWordManager(String filePath){
        this.stopWordsList = new ArrayList<>();
        this.stopWordsSet = new HashSet<>();
        try(Scanner sc = new Scanner(new File(filePath))){
            sc.useDelimiter(",");
            while(sc.hasNext()){
                nextStopWord = sc.next();
                this.stopWordsList.add(nextStopWord);
                this.stopWordsSet.add(nextStopWord);
            }
            
        }catch(IOException e){
            System.out.println("Cannot found the file.");
        }
     }

     public boolean isStopWordList(String word){
         return this.stopWordsList.contains(word);
     }

     public boolean isStopWordSet(String word){
         return this.stopWordsSet.contains(word);
     }


}