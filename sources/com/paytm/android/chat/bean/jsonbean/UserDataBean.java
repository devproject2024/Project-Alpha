package com.paytm.android.chat.bean.jsonbean;

public class UserDataBean {
    private String content;
    private boolean isForward = false;
    private long messageId;
    private String title;
    private int type;
    private String url;
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public boolean isForward() {
        return this.isForward;
    }

    public void setForward(boolean z) {
        this.isForward = z;
    }

    public UserDataBean() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public UserDataBean(long j) {
        this.messageId = j;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public void setMessageId(long j) {
        this.messageId = j;
    }
}
