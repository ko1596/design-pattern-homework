package org.ntutssl.termfrequency;

public class Main {
    public static void main(String[] args){
        IOHandler ioHandler = new IOHandler();
        IStopWordManager swm = new StopWordManager();
        IDataStorageManager dsm = new DataStorageManager();
        IWordFrequencyManager wfm = new WordFrequencyManagerStream();
        new WordFrequencyController(ioHandler, swm, dsm, swm).run(args[4], Integer.parseInt(args[3]) , args[2]);;
     }
}