package com.sendbird.android.log;

import com.sendbird.android.constant.StringSet;

public enum Tag {
    DEFAULT(StringSet.SendBird),
    CONNECTION("CONNECTION"),
    PINGER("PINGER");
    
    private final String tag;

    private Tag(String str) {
        this.tag = str;
    }

    public final String tag() {
        return this.tag;
    }
}
