package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;

public class CJRCta {
    @b(a = "aligned")
    private String mAligned;
    @b(a = "label")
    private String mLabel;
    @b(a = "url")
    private String mUrl;

    public String getmLabel() {
        return this.mLabel;
    }

    public void setmLabel(String str) {
        this.mLabel = str;
    }

    public String getmUrl() {
        return this.mUrl;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    public String getmAligned() {
        return this.mAligned;
    }

    public void setmAligned(String str) {
        this.mAligned = str;
    }
}
