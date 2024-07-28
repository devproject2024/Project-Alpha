package com.alipay.mobile.nebula.appcenter.apphandler;

public class H5PreferAppInfo {
    private String nbsn;
    private String nbsv;
    private long saveTime;

    public H5PreferAppInfo() {
    }

    public H5PreferAppInfo(String str, long j, String str2) {
        this.nbsv = str;
        this.saveTime = j;
        this.nbsn = str2;
    }

    public String getNbsv() {
        return this.nbsv;
    }

    public void setNbsv(String str) {
        this.nbsv = str;
    }

    public long getSaveTime() {
        return this.saveTime;
    }

    public void setSaveTime(long j) {
        this.saveTime = j;
    }

    public String getNbsn() {
        return this.nbsn;
    }

    public void setNbsn(String str) {
        this.nbsn = str;
    }

    public String toString() {
        return "H5PreferAppInfo{nbsv='" + this.nbsv + '\'' + ", saveTime=" + this.saveTime + ", nbsn='" + this.nbsn + '\'' + '}';
    }
}
