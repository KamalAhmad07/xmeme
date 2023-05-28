package com.crio.starter.exception;

public class DataMatchedEception extends Exception {

    static final long serialVersionUID = 1L;

    public DataMatchedEception() {
        super();
    }

    public DataMatchedEception(String message) {
        super(message);
    }

    public DataMatchedEception(String message, Throwable cause) {
        super(message, cause);
    }

    public DataMatchedEception(Throwable cause) {
        super(cause);
    }

    protected DataMatchedEception(String message, Throwable cause,
                        boolean enableSuppression,
                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
