package com.paytm.notification.models;

import com.google.gson.a.c;

public final class FlashFetchResponse {
    private String campaignId;
    @c(a = "content")
    private String content;
    @c(a = "pushId")
    private String pushId;
    @c(a = "received")
    private String receivedDate;
    @c(a = "tag")
    private String tag;

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getPushId() {
        return this.pushId;
    }

    public final void setPushId(String str) {
        this.pushId = str;
    }

    public final String getReceivedDate() {
        return this.receivedDate;
    }

    public final void setReceivedDate(String str) {
        this.receivedDate = str;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final void setCampaignId(String str) {
        this.campaignId = str;
    }
}
