package net.one97.paytm.recharge.legacy.catalog.model.v2;

import java.io.Serializable;

public class CJRPrefetchObj implements Serializable {
    private String postText;
    private String preText;
    private String processingText;

    public String getPreText() {
        return this.preText;
    }

    public void setPreText(String str) {
        this.preText = str;
    }

    public String getProcessingText() {
        return this.processingText;
    }

    public void setProcessingText(String str) {
        this.processingText = str;
    }

    public String getPostText() {
        return this.postText;
    }

    public void setPostText(String str) {
        this.postText = str;
    }
}
