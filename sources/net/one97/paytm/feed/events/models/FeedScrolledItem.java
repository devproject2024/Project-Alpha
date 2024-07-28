package net.one97.paytm.feed.events.models;

import kotlin.g.b.k;

public final class FeedScrolledItem {
    private final String buckets;
    private final String content_format;
    private final String feed_type;
    private final String mlCategory;
    private final String ml_version;
    private final String objectId;
    private final Double score;

    public static /* synthetic */ FeedScrolledItem copy$default(FeedScrolledItem feedScrolledItem, Double d2, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = feedScrolledItem.score;
        }
        if ((i2 & 2) != 0) {
            str = feedScrolledItem.objectId;
        }
        String str7 = str;
        if ((i2 & 4) != 0) {
            str2 = feedScrolledItem.buckets;
        }
        String str8 = str2;
        if ((i2 & 8) != 0) {
            str3 = feedScrolledItem.content_format;
        }
        String str9 = str3;
        if ((i2 & 16) != 0) {
            str4 = feedScrolledItem.feed_type;
        }
        String str10 = str4;
        if ((i2 & 32) != 0) {
            str5 = feedScrolledItem.ml_version;
        }
        String str11 = str5;
        if ((i2 & 64) != 0) {
            str6 = feedScrolledItem.mlCategory;
        }
        return feedScrolledItem.copy(d2, str7, str8, str9, str10, str11, str6);
    }

    public final Double component1() {
        return this.score;
    }

    public final String component2() {
        return this.objectId;
    }

    public final String component3() {
        return this.buckets;
    }

    public final String component4() {
        return this.content_format;
    }

    public final String component5() {
        return this.feed_type;
    }

    public final String component6() {
        return this.ml_version;
    }

    public final String component7() {
        return this.mlCategory;
    }

    public final FeedScrolledItem copy(Double d2, String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str2, "buckets");
        k.c(str3, "content_format");
        k.c(str4, "feed_type");
        k.c(str5, "ml_version");
        String str7 = str6;
        k.c(str7, "mlCategory");
        return new FeedScrolledItem(d2, str, str2, str3, str4, str5, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedScrolledItem)) {
            return false;
        }
        FeedScrolledItem feedScrolledItem = (FeedScrolledItem) obj;
        return k.a((Object) this.score, (Object) feedScrolledItem.score) && k.a((Object) this.objectId, (Object) feedScrolledItem.objectId) && k.a((Object) this.buckets, (Object) feedScrolledItem.buckets) && k.a((Object) this.content_format, (Object) feedScrolledItem.content_format) && k.a((Object) this.feed_type, (Object) feedScrolledItem.feed_type) && k.a((Object) this.ml_version, (Object) feedScrolledItem.ml_version) && k.a((Object) this.mlCategory, (Object) feedScrolledItem.mlCategory);
    }

    public final int hashCode() {
        Double d2 = this.score;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        String str = this.objectId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.buckets;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.content_format;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.feed_type;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.ml_version;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mlCategory;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "FeedScrolledItem(score=" + this.score + ", objectId=" + this.objectId + ", buckets=" + this.buckets + ", content_format=" + this.content_format + ", feed_type=" + this.feed_type + ", ml_version=" + this.ml_version + ", mlCategory=" + this.mlCategory + ")";
    }

    public FeedScrolledItem(Double d2, String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str2, "buckets");
        k.c(str3, "content_format");
        k.c(str4, "feed_type");
        k.c(str5, "ml_version");
        k.c(str6, "mlCategory");
        this.score = d2;
        this.objectId = str;
        this.buckets = str2;
        this.content_format = str3;
        this.feed_type = str4;
        this.ml_version = str5;
        this.mlCategory = str6;
    }

    public final Double getScore() {
        return this.score;
    }

    public final String getObjectId() {
        return this.objectId;
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

    public final String getMlCategory() {
        return this.mlCategory;
    }
}
