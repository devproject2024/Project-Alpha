package net.one97.paytm.feed.events.models;

public final class FeedUserViewed extends BaseEventDTO {
    private String objectId;

    public final String getObjectId() {
        return this.objectId;
    }

    public final void setObjectId(String str) {
        this.objectId = str;
    }

    public FeedUserViewed(String str, String str2, String str3, String str4, String str5, MetaInfo metaInfo, String str6) {
        super(str2, str3, str4, str5, metaInfo, str6);
        this.objectId = str;
    }
}
