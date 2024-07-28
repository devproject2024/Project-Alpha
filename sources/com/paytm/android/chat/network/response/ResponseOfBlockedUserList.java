package com.paytm.android.chat.network.response;

import java.io.Serializable;
import java.util.List;

public class ResponseOfBlockedUserList extends ResponseBase implements Serializable {
    private List<Object> data;

    public List<Object> getData() {
        return this.data;
    }

    public void setData(List<Object> list) {
        this.data = list;
    }

    public String toString() {
        return super.toString() + "->ResponseOfRegister{data=" + this.data + '}';
    }
}
