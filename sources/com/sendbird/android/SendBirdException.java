package com.sendbird.android;

public final class SendBirdException extends Exception {
    protected int code;

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i2) {
        this.code = i2;
    }

    public SendBirdException(String str) {
        super(str);
        setCode(0);
    }

    public SendBirdException(String str, int i2) {
        super(str);
        setCode(i2);
    }
}
