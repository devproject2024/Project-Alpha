package com.alipay.mobile.h5container.api;

import java.io.InputStream;

public class H5PreSetPkgInfo {
    String appId;
    String downloadUrl;
    boolean forceSync;
    InputStream inputStream;
    String version;

    public H5PreSetPkgInfo(String str, String str2, InputStream inputStream2, boolean z) {
        this.appId = str;
        this.version = str2;
        this.inputStream = inputStream2;
        this.forceSync = z;
    }

    public H5PreSetPkgInfo(String str, String str2, InputStream inputStream2, boolean z, String str3) {
        this.appId = str;
        this.version = str2;
        this.inputStream = inputStream2;
        this.forceSync = z;
        this.downloadUrl = str3;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setInputStream(InputStream inputStream2) {
        this.inputStream = inputStream2;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean getForceSync() {
        return this.forceSync;
    }

    public void setForceSync(boolean z) {
        this.forceSync = z;
    }
}
