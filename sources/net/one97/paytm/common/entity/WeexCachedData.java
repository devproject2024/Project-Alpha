package net.one97.paytm.common.entity;

public class WeexCachedData {
    private boolean isFromAsset;
    private String mData;
    private String mUrl;
    private String mVersion;

    public WeexCachedData(String str, String str2, String str3, boolean z) {
        this.mUrl = str;
        this.mVersion = str2;
        this.mData = str3;
        this.isFromAsset = z;
    }

    public String getData() {
        return this.mData;
    }

    public boolean isFromAsset() {
        return this.isFromAsset;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVersion() {
        return this.mVersion;
    }
}
