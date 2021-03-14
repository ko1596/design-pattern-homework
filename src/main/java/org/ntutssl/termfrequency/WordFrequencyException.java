package org.ntutssl.termfrequency;

public class WordFrequencyException extends RuntimeException {
    static final long serialVersionUID = 1L;
    
    public WordFrequencyException(String errorMessage, Throwable err) {
        super(errorMessage,err);
     }

    public WordFrequencyException(String errorMessage) {
        super(errorMessage);
     }
}
