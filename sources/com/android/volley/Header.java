package com.android.volley;

import android.text.TextUtils;

public final class Header {
    private final String mName;
    private final String mValue;

    public Header(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getValue() {
        return this.mValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Header header = (Header) obj;
            return TextUtils.equals(this.mName, header.mName) && TextUtils.equals(this.mValue, header.mValue);
        }
    }

    public final int hashCode() {
        return (this.mName.hashCode() * 31) + this.mValue.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.mName + ",value=" + this.mValue + "]";
    }
}
