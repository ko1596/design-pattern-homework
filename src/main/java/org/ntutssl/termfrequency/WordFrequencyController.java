package org.ntutssl.termfrequency;

public class WordFrequencyController {
    private IOHandler ioHandler;
    private  IStopWordManager swm;
    private  IDataStorageManager dsm;
    private  IWordFrequencyManager wfm;
    public WordFrequencyController(
        IOHandler handler, 
        IStopWordManager swm, 
        IDataStorageManager dsm, 
        IWordFrequencyManager wfm
    ){
        this.ioHandler = handler;
        this.swm = swm;
        this.dsm = dsm;
        this.wfm = wfm;
     }

    public void run(String order, Integer range, String outputPath) {
        for (String word : dsm.getWords()){
            if(!swm.isStopWordList(word)) wfm.incrementCount(word);
        }
        wfm.output(outputPath, order, range, this.ioHandler);
     }
}