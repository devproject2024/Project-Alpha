package com.paytm.android.chat.bean.event;

import com.sendbird.android.BaseMessage;

public class FailMessageEvent {
    public BaseMessage message;
    public String url;

    public FailMessageEvent(String str, BaseMessage baseMessage) {
        this.url = str;
        this.message = baseMessage;
    }
}
