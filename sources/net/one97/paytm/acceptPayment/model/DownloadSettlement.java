package net.one97.paytm.acceptPayment.model;

import com.google.gsonhtcfix.a.b;

public class DownloadSettlement extends CommonResultInfo {
    @b(a = "downloadId")
    private String downloadId;
    @b(a = "ipRoleId")
    private String ipRoleId;

    public String getDownloadId() {
        return this.downloadId;
    }

    public void setDownloadId(String str) {
        this.downloadId = str;
    }

    public String getIpRoleId() {
        return this.ipRoleId;
    }

    public void setIpRoleId(String str) {
        this.ipRoleId = str;
    }
}
