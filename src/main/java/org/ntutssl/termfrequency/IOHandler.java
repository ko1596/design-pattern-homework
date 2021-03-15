package org.ntutssl.termfrequency;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class IOHandler {

    public List<String> handleInputAsList(String filePath, String pattern) {
        List<String> wordsList = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(filePath))){
            sc.useDelimiter(pattern);
            while(sc.hasNext()){
                wordsList.add(sc.next().toLowerCase());
            }
        }catch(IOException e){
            throw new WordFrequencyException("File not found.",e);
        }

        return wordsList;
     }

    public Set<String> handleInputAsSet(String filePath, String pattern) {
        Set<String> wordsSet = new HashSet<>();
        try(Scanner sc = new Scanner(new File(filePath))){
            sc.useDelimiter(pattern);
            while(sc.hasNext()){
                wordsSet.add(sc.next().toLowerCase());
            }
        }catch(IOException e){
            throw new WordFrequencyException("File not found.",e);
        }

        return wordsSet;
     }

    public void handleOutput(String outputPath, int range, List<String> data){
        File file = new File(outputPath);
        try(BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));) {
            if(data.isEmpty()){
                fw.append("");
            }else{
                for(int i=0;i<range;i++){
                    fw.append(data.get(i));
                }
            }
            
            
            fw.flush(); // 全部寫入緩存中的內容
        }catch (Exception e) {
            throw new WordFrequencyException(e.getMessage(),e);
        }


     }
}