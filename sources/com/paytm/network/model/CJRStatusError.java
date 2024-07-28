package com.paytm.network.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class CJRStatusError implements Serializable {
    private static final long serialVersionUID = 1;
    @b(a = "code")
    private int mCode;
    @b(a = "message")
    private CJRError mMessage;
    @b(a = "result")
    private String mResult;

    public String getmResult() {
        return this.mResult;
    }

    public CJRError getmMessage() {
        return this.mMessage;
    }

    public int getmCode() {
        return this.mCode;
    }
}
