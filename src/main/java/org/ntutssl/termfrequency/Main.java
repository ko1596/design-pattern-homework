package org.ntutssl.termfrequency;

public class Main {
    public static void main(String[] args){
        IOHandler ioHandler = new IOHandler();
        IStopWordManager swm = new StopWordManager(args[0],ioHandler);
        IDataStorageManager dsm = new DataStorageManager(args[1],ioHandler);
        IWordFrequencyManager wfm = new WordFrequencyManagerStream();
        new WordFrequencyController(ioHandler, swm, dsm, swm).run(args[4], Integer.parseInt(args[3]) , args[2]);;
     }
}