package net.one97.paytm.common.entity.cst;

import java.util.ArrayList;

public class CJRSendFeedbackModel {
    private String comment;
    private String key;
    private ArrayList<String> reason;
    private String value;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public ArrayList<String> getReason() {
        return this.reason;
    }

    public void setReason(ArrayList<String> arrayList) {
        this.reason = arrayList;
    }
}
