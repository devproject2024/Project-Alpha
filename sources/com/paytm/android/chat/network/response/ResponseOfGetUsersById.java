package com.paytm.android.chat.network.response;

import java.io.Serializable;

public class ResponseOfGetUsersById extends ResponseBase implements Serializable {
    private String data;

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String toString() {
        return super.toString() + "->ResponseOfRegister{data=" + this.data + '}';
    }
}
