package org.ntutssl.termfrequency;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class DataStorageManager{
    private List<String> allWords;
    private String nextWord;

    public DataStorageManager(String filePath){
        this.allWords = new ArrayList<String>();
        try(Scanner sc = new Scanner(new File(filePath))){
            sc.useDelimiter("[\\W_]+");
            while(sc.hasNext()){
                this.allWords.add(sc.next().toLowerCase());
            }
            
        }catch(IOException e){
            System.out.println("Cannot found the file.");
        }
     }

    public List<String> getWords(){
        return this.allWords;
     }
}