package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.exception;

public class SheroesSdkNotInitializedException extends SheroesException {
    static final long serialVersionUID = 1;

    public SheroesSdkNotInitializedException() {
    }

    public SheroesSdkNotInitializedException(String str) {
        super(str);
    }

    public SheroesSdkNotInitializedException(String str, Throwable th) {
        super(str, th);
    }

    public SheroesSdkNotInitializedException(Throwable th) {
        super(th);
    }
}
