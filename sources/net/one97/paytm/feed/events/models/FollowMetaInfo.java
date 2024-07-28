package net.one97.paytm.feed.events.models;

public class FollowMetaInfo extends MetaInfo {
    private Long followerCount;
    private Integer providerId;
    private String providerName;

    public final Integer getProviderId() {
        return this.providerId;
    }

    public final void setProviderId(Integer num) {
        this.providerId = num;
    }

    public final String getProviderName() {
        return this.providerName;
    }

    public final void setProviderName(String str) {
        this.providerName = str;
    }

    public final Long getFollowerCount() {
        return this.followerCount;
    }

    public final void setFollowerCount(Long l) {
        this.followerCount = l;
    }

    public FollowMetaInfo(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, String str9, boolean z, int i2, String str10, Long l) {
        super(str, str2, str3, str4, str5, str6, num, str7, str8, str9, z);
        this.providerId = Integer.valueOf(i2);
        this.providerName = str10;
        this.followerCount = l;
    }
}
