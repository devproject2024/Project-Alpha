package net.one97.paytm.feed.events.models;

import kotlin.g.b.k;

public final class FeedUserViewedMetaInfo extends MetaInfo {
    private final String buckets;
    private final String content_format;
    private final Integer content_length;
    private int duration_msec;
    private final String feed_type;
    private final String mlCategory;
    private final String ml_version;
    private final Double score;

    public final Double getScore() {
        return this.score;
    }

    public final String getMlCategory() {
        return this.mlCategory;
    }

    public final String getBuckets() {
        return this.buckets;
    }

    public final String getContent_format() {
        return this.content_format;
    }

    public final String getFeed_type() {
        return this.feed_type;
    }

    public final String getMl_version() {
        return this.ml_version;
    }

    public final int getDuration_msec() {
        return this.duration_msec;
    }

    public final void setDuration_msec(int i2) {
        this.duration_msec = i2;
    }

    public final Integer getContent_length() {
        return this.content_length;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedUserViewedMetaInfo(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, boolean z, Double d2, String str10, String str11, String str12, String str13, String str14, int i2, Integer num2) {
        super(str, str2, str3, str4, str5, str6, num, str7, str8, str9, z);
        String str15 = str10;
        String str16 = str11;
        String str17 = str12;
        String str18 = str13;
        String str19 = str14;
        k.c(str15, "mlCategory");
        k.c(str16, "buckets");
        k.c(str17, "content_format");
        k.c(str18, "feed_type");
        k.c(str19, "ml_version");
        this.score = d2;
        this.mlCategory = str15;
        this.buckets = str16;
        this.content_format = str17;
        this.feed_type = str18;
        this.ml_version = str19;
        this.duration_msec = i2;
        this.content_length = num2;
    }
}
