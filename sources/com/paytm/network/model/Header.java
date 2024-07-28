package com.paytm.network.model;

import java.io.Serializable;

public final class Header implements Serializable {
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

    public final int hashCode() {
        return (this.mName.hashCode() * 31) + this.mValue.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.mName + ",value=" + this.mValue + "]";
    }
}
