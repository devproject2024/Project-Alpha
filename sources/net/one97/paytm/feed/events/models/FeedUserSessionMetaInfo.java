package net.one97.paytm.feed.events.models;

import kotlin.g.b.k;

public final class FeedUserSessionMetaInfo extends MetaInfo {
    private String begin_at;
    private String ended_at;
    private int request_count;
    private String requested_at;

    public final String getBegin_at() {
        return this.begin_at;
    }

    public final void setBegin_at(String str) {
        k.c(str, "<set-?>");
        this.begin_at = str;
    }

    public final String getEnded_at() {
        return this.ended_at;
    }

    public final void setEnded_at(String str) {
        k.c(str, "<set-?>");
        this.ended_at = str;
    }

    public final int getRequest_count() {
        return this.request_count;
    }

    public final void setRequest_count(int i2) {
        this.request_count = i2;
    }

    public final String getRequested_at() {
        return this.requested_at;
    }

    public final void setRequested_at(String str) {
        k.c(str, "<set-?>");
        this.requested_at = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedUserSessionMetaInfo(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, boolean z, String str10, String str11, int i2, String str12) {
        super(str, str2, str3, str4, str5, str6, num, str7, str8, str9, z);
        String str13 = str10;
        String str14 = str11;
        String str15 = str12;
        k.c(str13, "begin_at");
        k.c(str14, "ended_at");
        k.c(str15, "requested_at");
        this.begin_at = str13;
        this.ended_at = str14;
        this.request_count = i2;
        this.requested_at = str15;
    }
}
