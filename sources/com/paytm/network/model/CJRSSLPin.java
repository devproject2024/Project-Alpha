package com.paytm.network.model;

import android.text.TextUtils;

public class CJRSSLPin {
    private String domain;
    private boolean isEnabled = false;
    private String value;

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public boolean isValid() {
        return this.isEnabled && !TextUtils.isEmpty(this.domain) && !TextUtils.isEmpty(this.value);
    }
}
