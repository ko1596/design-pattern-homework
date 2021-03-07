package org.ntutssl.termfrequency;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class StopWordManager{
    private List<String> stopWords;

    public StopWordManager(){
        this.stopWords = new ArrayList<>();
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