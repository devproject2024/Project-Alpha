package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.exception;

public class SheroesException extends RuntimeException {
    static final long serialVersionUID = 1;

    public SheroesException() {
    }

    public SheroesException(String str) {
        super(str);
    }

    public SheroesException(String str, Object... objArr) {
        this(String.format(str, objArr));
    }

    public SheroesException(String str, Throwable th) {
        super(str, th);
    }

    public SheroesException(Throwable th) {
        super(th);
    }

    public String toString() {
        return getMessage();
    }
}
