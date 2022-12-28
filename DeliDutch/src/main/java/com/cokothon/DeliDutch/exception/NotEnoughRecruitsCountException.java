package com.cokothon.DeliDutch.exception;

public class NotEnoughRecruitsCountException extends RuntimeException{
    public NotEnoughRecruitsCountException() {
        super();
    }

    public NotEnoughRecruitsCountException(String message) {
        super(message);
    }

    public NotEnoughRecruitsCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughRecruitsCountException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughRecruitsCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
