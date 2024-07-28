package com.alipay.mobile.nebula.config;

public class H5EmbedViewConfig {
    public static final String TAG = "H5EmbedViewConfig";
    private String bundleName;
    private String className;
    private String type;

    public H5EmbedViewConfig(String str, String str2, String str3) {
        this.bundleName = str;
        this.className = str2;
        this.type = str3;
    }

    public String getBundleName() {
        return this.bundleName;
    }

    public String getClassName() {
        return this.className;
    }

    public String getType() {
        return this.type;
    }
}
