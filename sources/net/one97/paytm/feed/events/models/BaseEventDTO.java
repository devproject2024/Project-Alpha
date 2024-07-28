package net.one97.paytm.feed.events.models;

public class BaseEventDTO {
    private String action;
    private String category;
    private String createdAt;
    private MetaInfo metaInfo;
    private String name;
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public MetaInfo getMetaInfo() {
        return this.metaInfo;
    }

    public void setMetaInfo(MetaInfo metaInfo2) {
        this.metaInfo = metaInfo2;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public BaseEventDTO(String str, String str2, String str3, String str4, MetaInfo metaInfo2, String str5) {
        setUserId(str);
        setName(str2);
        setAction(str3);
        setCategory(str4);
        setMetaInfo(metaInfo2);
        setCreatedAt(str5);
    }
}
