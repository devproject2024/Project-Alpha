package net.one97.paytm.feed.events.models;

import kotlin.g.b.k;

public final class FeedUserEngagedMetaInfo extends MetaInfo {
    private final String buckets;
    private final String content_format;
    private final String engage_end_at;
    private final String engage_start_at;
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

    public final String getEngage_end_at() {
        return this.engage_end_at;
    }

    public final String getEngage_start_at() {
        return this.engage_start_at;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedUserEngagedMetaInfo(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, boolean z, Double d2, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        super(str, str2, str3, str4, str5, str6, num, str7, str8, str9, z);
        String str17 = str10;
        String str18 = str11;
        String str19 = str12;
        String str20 = str13;
        String str21 = str14;
        String str22 = str15;
        String str23 = str16;
        k.c(str17, "mlCategory");
        k.c(str18, "buckets");
        k.c(str19, "content_format");
        k.c(str20, "feed_type");
        k.c(str21, "ml_version");
        k.c(str22, "engage_start_at");
        k.c(str23, "engage_end_at");
        this.score = d2;
        this.mlCategory = str17;
        this.buckets = str18;
        this.content_format = str19;
        this.feed_type = str20;
        this.ml_version = str21;
        this.engage_start_at = str22;
        this.engage_end_at = str23;
    }
}
