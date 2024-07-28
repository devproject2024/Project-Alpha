package net.one97.paytm.feed.ui.feed.actions.comment;

import kotlin.g.b.k;

public enum a {
    UNMODERATED("UNMODERATED"),
    APPROVED("APPROVED"),
    SENSITIVE("SENSITIVE"),
    BLOCKED("BLOCKED");
    
    private String type;

    private a(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        k.c(str, "<set-?>");
        this.type = str;
    }
}
