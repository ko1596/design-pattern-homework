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

    public StopWordManager(){
        this.stopWordsList = new ArrayList<>();
        this.stopWordsSet = new HashSet<>();
        try(Scanner sc = new Scanner(new File("input/stop_words.txt"))){
            sc.useDelimiter(",");
            while(sc.hasNext()){
                this.stopWords.add(sc.next());
            }
            
        }catch(IOException e){
            System.out.println("Cannot found the file.");
        }
     }

     public boolean isStopWord(String word){
         return this.stopWords.contains(word);
     }


}