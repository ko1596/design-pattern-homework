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

    private List<String> wordsList;
    private Set<String> wordsSet;

    public IOHandler() {
        this.wordsList = new ArrayList<>();
        this.wordsSet = new HashSet<>();
     }

    public List<String> handleInputAsList(String filePath, String pattern) {
        try(Scanner sc = new Scanner(new File(filePath))){
            sc.useDelimiter(pattern);
            while(sc.hasNext()){
                this.wordsList.add(sc.next().toLowerCase());
            }
        }catch(IOException e){
            System.out.println("Cannot found the file.");
        }

        return this.wordsList;
     }

    public Set<String> handleInputAsSet(String filePath, String pattern) {
        try(Scanner sc = new Scanner(new File(filePath))){
            sc.useDelimiter(pattern);
            while(sc.hasNext()){
                this.wordsSet.add(sc.next().toLowerCase());
            }
        }catch(IOException e){
            System.out.println("Cannot found the file.");
        }

        return this.wordsSet;
     }

    public void handleOutput(String outputPath, int range, List<String> data){
        BufferedWriter fw = null;
        try {
            File file = new File(outputPath);
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // 指點編碼格式，以免讀取時中文字符異常
            fw.append("input sentence 1 ");
            fw.newLine();
            fw.append("input sentence 2 ");
            fw.flush(); // 全部寫入緩存中的內容
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fw != null) {
            try {
              fw.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
        }
     }
}